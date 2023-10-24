package br.com.inventory.config.usecase;

import br.com.inventory.adapters.out.FindInventoryByProductIdAdapter;
import br.com.inventory.application.core.usecase.FindInvetoryByProductIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindInventoryByProductIdConfig {

    @Bean
    public FindInvetoryByProductIdUseCase findInvetoryByProductIdUseCase(FindInventoryByProductIdAdapter findInventoryByProductIdAdapter) {
        return new FindInvetoryByProductIdUseCase(findInventoryByProductIdAdapter);
    }
}
