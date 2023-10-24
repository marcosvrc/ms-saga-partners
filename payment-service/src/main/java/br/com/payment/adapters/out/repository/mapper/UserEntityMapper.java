package br.com.payment.adapters.out.repository.mapper;

import br.com.payment.adapters.out.repository.entity.UserEntity;
import br.com.payment.application.core.domain.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {

    User toUser(UserEntity userEntity);

    UserEntity toUserEntity(User user);

}
