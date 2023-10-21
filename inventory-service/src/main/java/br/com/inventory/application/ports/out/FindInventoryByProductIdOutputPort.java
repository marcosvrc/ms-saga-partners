package br.com.inventory.application.ports.out;

import br.com.inventory.application.core.domain.Inventory;

import java.util.Optional;

public interface FindInventoryByProductIdOutputPort {

    Optional<Inventory> find(final Integer productId);
}
