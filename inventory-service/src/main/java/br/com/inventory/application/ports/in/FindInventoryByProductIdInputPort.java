package br.com.inventory.application.ports.in;

import br.com.inventory.application.core.domain.Inventory;

public interface FindInventoryByProductIdInputPort {

    Inventory find(final Integer productId);
}
