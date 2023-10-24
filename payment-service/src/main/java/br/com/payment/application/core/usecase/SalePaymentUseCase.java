package br.com.payment.application.core.usecase;

import br.com.payment.application.core.domain.Payment;
import br.com.payment.application.core.domain.Sale;
import br.com.payment.application.core.domain.enums.SaleEvent;
import br.com.payment.application.ports.in.FindUserByIdInputPort;
import br.com.payment.application.ports.in.SalePaymentInputPort;
import br.com.payment.application.ports.out.SavePaymentOutputPort;
import br.com.payment.application.ports.out.SendValidatedPaymentOuputPort;
import br.com.payment.application.ports.out.UpdateUserOutputPort;

public class SalePaymentUseCase implements SalePaymentInputPort {

    private final FindUserByIdInputPort findUserByIdInputPort;

    private final UpdateUserOutputPort updateUserOutputPort;

    private final SavePaymentOutputPort savePaymentOutputPort;

    private final SendValidatedPaymentOuputPort sendValidatedPaymentOuputPort;

    public SalePaymentUseCase(final FindUserByIdInputPort findUserByIdInputPort,
                              final UpdateUserOutputPort updateUserOutputPort,
                              final SavePaymentOutputPort savePaymentOutputPort,
                              final SendValidatedPaymentOuputPort sendValidatedPaymentOuputPort) {
        this.findUserByIdInputPort = findUserByIdInputPort;
        this.updateUserOutputPort = updateUserOutputPort;
        this.savePaymentOutputPort = savePaymentOutputPort;
        this.sendValidatedPaymentOuputPort = sendValidatedPaymentOuputPort;
    }

    @Override
    public void payment(Sale sale) {
        var user = findUserByIdInputPort.find(sale.getUserId());
        if (user.getBalance().compareTo(sale.getValue()) < 0) {
            throw new RuntimeException("Saldo insuficiente");
        }
        user.debitBalance(sale.getValue());
        updateUserOutputPort.update(user);
        savePaymentOutputPort.save(buildPayment(sale));
        sendValidatedPaymentOuputPort.send(sale, SaleEvent.VALIDATED_PAYMENT);
    }

    private Payment buildPayment(Sale sale) {
        return new Payment(null, sale.getUserId(), sale.getId(), sale.getValue());
    }

}
