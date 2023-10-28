package br.com.inventory.config.usecase;

import br.com.inventory.adapters.out.SendToKafkaAdapter;
import br.com.inventory.adapters.out.UpdateInventoryAdapter;
import br.com.inventory.application.core.usecase.CreditInventoryUseCase;
import br.com.inventory.application.core.usecase.FindInvetoryByProductIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreditInventoryConfig {

    @Bean
    public CreditInventoryUseCase creditInventoryUseCase(FindInvetoryByProductIdUseCase findInvetoryByProductIdUseCase,
                                                         UpdateInventoryAdapter updateInventoryAdapter,
                                                         SendToKafkaAdapter sendToKafkaAdapter) {
        return new CreditInventoryUseCase(findInvetoryByProductIdUseCase, updateInventoryAdapter, sendToKafkaAdapter);
    }
}
