package br.com.inventory.config.usecase;

import br.com.inventory.adapters.out.SendUpdateInventoryAdapter;
import br.com.inventory.adapters.out.UpdateInventoryAdapter;
import br.com.inventory.application.core.usecase.DebitInventoryUseCase;
import br.com.inventory.application.core.usecase.FindInvetoryByProductIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DebitInventoryConfig {

    @Bean
    public DebitInventoryUseCase debitInventoryUseCase(FindInvetoryByProductIdUseCase findInvetoryByProductIdUseCase,
                                                       UpdateInventoryAdapter updateInventoryAdapter,
                                                       SendUpdateInventoryAdapter sendUpdateInventoryAdapter) {
        return new DebitInventoryUseCase(findInvetoryByProductIdUseCase, updateInventoryAdapter, sendUpdateInventoryAdapter);
    }
}
