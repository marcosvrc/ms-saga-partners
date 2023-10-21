package br.com.inventory.application.ports.out;

import br.com.inventory.application.core.domain.Inventory;

public interface UpdateInventoryOutputPort {

    void update(Inventory inventory);
}
