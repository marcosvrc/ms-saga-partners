package br.com.payment.application.ports.out;

import br.com.payment.application.core.domain.User;

import java.util.Optional;

public interface FindUserByIdOutputPort {

    Optional<User> find(final Integer userId);
}
