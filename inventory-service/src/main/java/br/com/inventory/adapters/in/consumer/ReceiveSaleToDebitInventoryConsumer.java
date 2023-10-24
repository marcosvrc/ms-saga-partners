package br.com.inventory.adapters.in.consumer;

import br.com.inventory.adapters.out.message.SaleMessage;
import br.com.inventory.application.core.domain.enums.SaleEvent;
import br.com.inventory.application.ports.in.DebitInventoryInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ReceiveSaleToDebitInventoryConsumer {

        private DebitInventoryInputPort debitInventoryInputPort;

        @Autowired
        public ReceiveSaleToDebitInventoryConsumer() {
            this.debitInventoryInputPort = debitInventoryInputPort;
        }

        @KafkaListener(topics = "tp-sale", groupId = "inventory-debit")
        public void receive(SaleMessage saleMessage) {
            if(SaleEvent.CREATED_SALE.equals(saleMessage.getEvent())) {
                log.info("Início da separação de mercadoria");
                debitInventoryInputPort.debit(saleMessage.getSale());
                log.info("Fim da separação de mercadoria");
            }
        }

}
