package br.com.payment.application.ports.out;

import br.com.payment.application.core.domain.User;

public interface UpdateUserOutputPort {

    void update(User user);
}
