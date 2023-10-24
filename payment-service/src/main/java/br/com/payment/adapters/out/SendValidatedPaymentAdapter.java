package br.com.payment.adapters.out;

import br.com.payment.adapters.out.message.SaleMessage;
import br.com.payment.application.core.domain.Sale;
import br.com.payment.application.core.domain.enums.SaleEvent;
import br.com.payment.application.ports.out.SendValidatedPaymentOuputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendValidatedPaymentAdapter implements SendValidatedPaymentOuputPort {

    private final KafkaTemplate<String, SaleMessage> kafkaTemplate;

    @Autowired
    public SendValidatedPaymentAdapter(KafkaTemplate<String, SaleMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void send(Sale sale, SaleEvent saleEvent) {
        var saleMessage = new SaleMessage(sale, saleEvent);
        kafkaTemplate.send("tp-sale", saleMessage);
    }
}
