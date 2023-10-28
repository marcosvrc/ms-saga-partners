package br.com.payment.config.usecase;

import br.com.payment.adapters.out.SavePaymentAdapter;
import br.com.payment.adapters.out.SendToKafkaAdapter;
import br.com.payment.adapters.out.UpdateUserAdapter;
import br.com.payment.application.core.usecase.FindUserByIdUseCase;
import br.com.payment.application.core.usecase.SalePaymentUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SalePaymentConfig {

    @Bean
    public SalePaymentUseCase salePaymentUseCase(FindUserByIdUseCase findUserByIdUseCase,
                                                 UpdateUserAdapter updateUserAdapter,
                                                 SavePaymentAdapter savePaymentAdapter,
                                                 SendToKafkaAdapter sendToKafkaAdapter) {

        return new SalePaymentUseCase(findUserByIdUseCase, updateUserAdapter,
                savePaymentAdapter, sendToKafkaAdapter);
    }
}
