package br.com.sale.config.usecase;

import br.com.sale.adapters.out.SaveSaleAdapter;
import br.com.sale.application.core.usecase.CancelSaleUseCase;
import br.com.sale.application.core.usecase.FindSaleByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CancelSaleConfig {

    @Bean
    public CancelSaleUseCase cancelSaleUseCase(
            FindSaleByIdUseCase findSaleByIdUseCase,
            SaveSaleAdapter saveSaleAdapter) {
        return new CancelSaleUseCase(findSaleByIdUseCase, saveSaleAdapter);
    }

}
