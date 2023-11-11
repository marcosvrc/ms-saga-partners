package br.com.sale.adapters.in.consumer;

import br.com.sale.adapters.out.message.SaleMessage;
import br.com.sale.application.core.domain.enums.SaleEvent;
import br.com.sale.application.ports.in.CancelSaleInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CancelSaleConsumer {

    private final CancelSaleInputPort cancelSaleInputPort;

    @Autowired
    public CancelSaleConsumer(CancelSaleInputPort cancelSaleInputPort) {
        this.cancelSaleInputPort = cancelSaleInputPort;
    }

    @KafkaListener(topics = "saga-sale", groupId = "sale-cancel")
    public void receive(SaleMessage saleMessage) {
        if(SaleEvent.ROLLBACK_INVENTORY.equals(saleMessage.getEvent())) {
            log.info("Cancelando a venda...");
            cancelSaleInputPort.cancel(saleMessage.getSale());
            log.info("Venda cancelada com sucesso!");
        }
    }

}
