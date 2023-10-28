package br.com.sale.config.usecase;

import br.com.sale.adapters.out.FindSaleByIdAdapter;
import br.com.sale.application.core.usecase.FindSaleByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindSaleByIdConfig {

    @Bean
    public FindSaleByIdUseCase findSaleByIdUseCase(final FindSaleByIdAdapter findSaleByIdOutputPort) {
        return new FindSaleByIdUseCase(findSaleByIdOutputPort);
    }

}
