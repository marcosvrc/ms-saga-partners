package br.com.sale.config.usecase;

import br.com.sale.adapters.out.SaveSaleAdapter;
import br.com.sale.application.core.usecase.FinalizeSaleUseCase;
import br.com.sale.application.core.usecase.FindSaleByIdUseCase;
import br.com.sale.application.ports.in.FinalizeSaleInputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FinalizeSaleConfig {

    @Bean
    public FinalizeSaleUseCase finalizeSaleUseCase(FindSaleByIdUseCase findSaleByIdUseCase,
                                                   SaveSaleAdapter saveSaleAdapter) {
        return new FinalizeSaleUseCase(findSaleByIdUseCase, saveSaleAdapter);
    }
}
