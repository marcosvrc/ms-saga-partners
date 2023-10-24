package br.com.payment.adapters.out;

import br.com.payment.adapters.out.repository.UserRepository;
import br.com.payment.adapters.out.repository.mapper.UserEntityMapper;
import br.com.payment.application.core.domain.User;
import br.com.payment.application.ports.out.UpdateUserOutputPort;
import org.springframework.stereotype.Component;

@Component
public class UpdateUserAdapter implements UpdateUserOutputPort {

    private final UserRepository userRepository;

    private final UserEntityMapper userEntityMapper;

    public UpdateUserAdapter(UserRepository userRepository,
                             UserEntityMapper userEntityMapper) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public void update(User user) {
        var userEntity = userEntityMapper.toUserEntity(user);
        userRepository.save(userEntity);
    }
}
