package br.com.inventory.adapters.out;

import br.com.inventory.adapters.out.repository.InventoryRepository;
import br.com.inventory.adapters.out.repository.mapper.InventoryEntityMapper;
import br.com.inventory.application.core.domain.Inventory;
import br.com.inventory.application.ports.out.UpdateInventoryOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateInventoryAdapter implements UpdateInventoryOutputPort {

    private final InventoryRepository inventoryRepository;

    private final InventoryEntityMapper inventoryEntityMapper;

    @Autowired
    public UpdateInventoryAdapter(InventoryRepository inventoryRepository,
                                  InventoryEntityMapper inventoryEntityMapper) {
        this.inventoryRepository = inventoryRepository;
        this.inventoryEntityMapper = inventoryEntityMapper;
    }

    @Override
    public void update(Inventory inventory) {
        var inventoryEntity = inventoryEntityMapper.toInventoryEntity(inventory);
        inventoryRepository.save(inventoryEntity);
    }
}
