package br.com.payment.adapters.in.consumer;


import br.com.payment.adapters.out.message.SaleMessage;
import br.com.payment.application.core.domain.enums.SaleEvent;
import br.com.payment.application.core.usecase.SalePaymentUseCase;
import br.com.payment.application.ports.in.SalePaymentInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReceiveSaleToPaymentConsumer {

    private final SalePaymentInputPort salePaymentInputPort;

    @Autowired
    public ReceiveSaleToPaymentConsumer(SalePaymentUseCase salePaymentUseCase) {
        this.salePaymentInputPort = salePaymentUseCase;
    }

    @KafkaListener(topics = "tp-sale", groupId = "payment")
    public void receive(SaleMessage saleMessage) {
        if(SaleEvent.UPDATED_INVETORY.equals(saleMessage.getSaleEvent())){
           log.info("Início pagamento");
           salePaymentInputPort.payment(saleMessage.getSale());
           log.info("Fim pagamento");
        }
    }
}
