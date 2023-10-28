package br.com.sale.adapters.in.consumer;

import br.com.sale.adapters.out.message.SaleMessage;
import br.com.sale.application.core.domain.enums.SaleEvent;
import br.com.sale.application.ports.in.FinalizeSaleInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReceiveSaleToFinalizeConsumer {

    private final FinalizeSaleInputPort finalizeSaleInputPort;

    @Autowired
    public ReceiveSaleToFinalizeConsumer(FinalizeSaleInputPort finalizeSaleInputPort) {
        this.finalizeSaleInputPort = finalizeSaleInputPort;
    }

    @KafkaListener(topics = "tp-sale", groupId = "sale-finalize")
    public void receive(SaleMessage saleMessage) {
      if(SaleEvent.VALIDATED_PAYMENT.equals(saleMessage.getEvent())) {
          log.info("Finalizando a venda...");
          finalizeSaleInputPort.finalize(saleMessage.getSale());
          log.info("Venda finalizada com sucesso!");
      }
    }


}
