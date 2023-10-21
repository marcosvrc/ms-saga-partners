package br.com.sales.adapters.out;

import br.com.sales.adapters.out.message.SaleMessage;
import br.com.sales.application.core.domain.Sale;
import br.com.sales.application.core.domain.enums.SaleEvent;
import br.com.sales.application.ports.out.SendCreatedSaleOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendCreatedSaleAdapter implements SendCreatedSaleOutputPort {

    private final KafkaTemplate<String, SaleMessage> kafkaTemplate;

    @Autowired
    public SendCreatedSaleAdapter(KafkaTemplate<String, SaleMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void send(Sale sale, SaleEvent event) {
        var saleMessage = new SaleMessage(sale, event);
        kafkaTemplate.send("tp-sale", saleMessage);
    }

}
