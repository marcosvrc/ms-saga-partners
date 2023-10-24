package br.com.payment.application.ports.in;

import br.com.payment.application.core.domain.Sale;

public interface SalePaymentInputPort {

    void payment(Sale sale);
}
