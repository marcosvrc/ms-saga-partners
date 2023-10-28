package br.com.inventory.adapters.in.consumer;

import br.com.inventory.adapters.out.message.SaleMessage;
import br.com.inventory.application.core.domain.enums.SaleEvent;
import br.com.inventory.application.ports.in.CreditInventoryInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReceiveSaleToCreditInventoryConsumer {

    private final CreditInventoryInputPort creditInventoryInputPort;

    @Autowired
    public ReceiveSaleToCreditInventoryConsumer(CreditInventoryInputPort creditInventoryInputPort) {
        this.creditInventoryInputPort = creditInventoryInputPort;
    }

    @KafkaListener(topics = "tp-sale", groupId = "inventory-credit")
    public void receive(SaleMessage saleMessage) {
        if(SaleEvent.FAILED_PAYMENT.equals(saleMessage.getEvent())) {
            log.info("Início da devolução de mercadoria");
            creditInventoryInputPort.credit(saleMessage.getSale());
            log.info("Fim da devolução de mercadoria");
        }
    }



}
