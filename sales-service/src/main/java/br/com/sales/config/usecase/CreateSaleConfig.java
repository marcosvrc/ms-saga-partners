package br.com.sales.config.usecase;

import br.com.sales.adapters.out.SaveSaleAdapter;
import br.com.sales.adapters.out.SendCreatedSaleAdapter;
import br.com.sales.application.core.usecase.CreateSaleUseCase;
import br.com.sales.application.ports.out.SaveSaleOutputPort;
import br.com.sales.application.ports.out.SendCreatedSaleOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateSaleConfig {

    @Bean
    public CreateSaleUseCase createSaleUseCase(
            SaveSaleAdapter saveSaleAdapter,
            SendCreatedSaleAdapter sendCreatedSaleAdapter) {
        return new CreateSaleUseCase(saveSaleAdapter, sendCreatedSaleAdapter);
    }
}
