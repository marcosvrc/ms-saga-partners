package br.com.payment.application.ports.out;

import br.com.payment.application.core.domain.Payment;

public interface SavePaymentOutputPort {

    void save (Payment payment);
}
