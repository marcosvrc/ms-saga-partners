package br.com.payment.adapters.out;

import br.com.payment.adapters.out.repository.UserRepository;
import br.com.payment.adapters.out.repository.mapper.UserEntityMapper;
import br.com.payment.application.core.domain.User;
import br.com.payment.application.ports.in.FindUserByIdInputPort;
import br.com.payment.application.ports.out.FindUserByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindUserByIdAdapter implements FindUserByIdOutputPort {

    private final UserRepository userRepository;

    private final UserEntityMapper userEntityMapper;

    @Autowired
    public FindUserByIdAdapter(UserRepository userRepository, UserEntityMapper userEntityMapper) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
    }


    @Override
    public Optional<User> find(Integer id) {
        var userEntity = userRepository.findById(id);
        return userEntity.map(userEntityMapper::toUser);
    }
}
