package br.com.inventory.adapters.out.repository.mapper;

import br.com.inventory.adapters.out.repository.entity.InventoryEntity;
import br.com.inventory.application.core.domain.Inventory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InventoryEntityMapper {

    Inventory toInventory(InventoryEntity inventoryEntity);

    InventoryEntity toInventoryEntity(Inventory inventory);
}
