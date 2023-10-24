package br.com.payment.application.ports.out;

import br.com.payment.application.core.domain.Sale;
import br.com.payment.application.core.domain.enums.SaleEvent;

public interface SendValidatedPaymentOuputPort {

    void send(Sale sale, SaleEvent saleEvent);
}
