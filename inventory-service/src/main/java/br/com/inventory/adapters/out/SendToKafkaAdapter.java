package br.com.inventory.adapters.out;

import br.com.inventory.adapters.out.message.SaleMessage;
import br.com.inventory.application.core.domain.Sale;
import br.com.inventory.application.core.domain.enums.SaleEvent;
import br.com.inventory.application.ports.out.SendToKafkaOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendToKafkaAdapter implements SendToKafkaOutputPort {

    private static final String TOPIC = "tp-sale";
    private final KafkaTemplate<String, SaleMessage> kafkaTemplate;

    @Autowired
    public SendToKafkaAdapter(KafkaTemplate<String, SaleMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void send(Sale sale, SaleEvent event) {
        var saleMessage = new SaleMessage(sale, event);
        kafkaTemplate.send(TOPIC, saleMessage);
    }
}
