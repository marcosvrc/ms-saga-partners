package br.com.payment.application.ports.in;

import br.com.payment.application.core.domain.User;

public interface FindUserByIdInputPort {

    User find(final Integer id);
}
