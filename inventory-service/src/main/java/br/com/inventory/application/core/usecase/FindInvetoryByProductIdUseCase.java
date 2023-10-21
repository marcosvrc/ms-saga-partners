package br.com.inventory.application.core.usecase;

import br.com.inventory.application.core.domain.Inventory;
import br.com.inventory.application.ports.in.FindInventoryByProductIdInputPort;
import br.com.inventory.application.ports.out.FindInventoryByProductIdOutputPort;

public class FindInvetoryByProductIdUseCase implements FindInventoryByProductIdInputPort {

    private final FindInventoryByProductIdOutputPort findInventoryByProductIdOutputPort;

    public FindInvetoryByProductIdUseCase(FindInventoryByProductIdOutputPort findInventoryByProductIdOutputPort) {
        this.findInventoryByProductIdOutputPort = findInventoryByProductIdOutputPort;
    }

    @Override
    public Inventory find(final Integer productId) {
        return findInventoryByProductIdOutputPort.find(productId).orElseThrow(() ->
                new RuntimeException("Estoque não encontrado para este produto"));
    }
}
