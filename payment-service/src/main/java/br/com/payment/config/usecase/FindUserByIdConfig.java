package br.com.payment.config.usecase;

import br.com.payment.adapters.out.FindUserByIdAdapter;
import br.com.payment.application.core.usecase.FindUserByIdUseCase;
import br.com.payment.application.ports.out.FindUserByIdOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindUserByIdConfig {

    @Bean
    public FindUserByIdUseCase findUserByIdUseCase(FindUserByIdAdapter findUserByIdAdapter) {
        return new FindUserByIdUseCase(findUserByIdAdapter);
    }
}
