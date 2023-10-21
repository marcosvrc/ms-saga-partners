package br.com.inventory.adapters.out;

import br.com.inventory.adapters.out.repository.InventoryRepository;
import br.com.inventory.adapters.out.repository.mapper.InventoryEntityMapper;
import br.com.inventory.application.core.domain.Inventory;
import br.com.inventory.application.ports.out.FindInventoryByProductIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindInventoryByProductIdAdapter implements FindInventoryByProductIdOutputPort {

    private final InventoryRepository inventoryRepository;

    private final InventoryEntityMapper inventoryEntityMapper;

    @Autowired
    public FindInventoryByProductIdAdapter(InventoryRepository inventoryRepository,
                                           InventoryEntityMapper inventoryEntityMapper) {
        this.inventoryRepository = inventoryRepository;
        this.inventoryEntityMapper = inventoryEntityMapper;
    }

    @Override
    public Optional<Inventory> find(Integer productId) {
        var inventoryEntity = inventoryRepository.findByProductId(productId);
        return inventoryEntity.map(inventoryEntityMapper::toInventory);
    }
}
