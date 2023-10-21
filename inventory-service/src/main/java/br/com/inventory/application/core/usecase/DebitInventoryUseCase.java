package br.com.inventory.application.core.usecase;

import br.com.inventory.application.core.domain.Sale;
import br.com.inventory.application.core.domain.enums.SaleEvent;
import br.com.inventory.application.ports.in.FindInventoryByProductIdInputPort;
import br.com.inventory.application.ports.out.SendUpdatedInventoryOutputPort;
import br.com.inventory.application.ports.out.UpdateInventoryOutputPort;

public class DebitInventoryUseCase {

    private final FindInventoryByProductIdInputPort findInventoryByProductIdInputPort;

    private final UpdateInventoryOutputPort updateInventoryOutputPort;

    private final SendUpdatedInventoryOutputPort sendUpdatedInventoryOutputPort;

    public DebitInventoryUseCase(final FindInventoryByProductIdInputPort findInventoryByProductIdInputPort,
                                 final UpdateInventoryOutputPort updateInventoryOutputPort,
                                 final SendUpdatedInventoryOutputPort sendUpdatedInventoryOutputPort) {
        this.findInventoryByProductIdInputPort = findInventoryByProductIdInputPort;
        this.updateInventoryOutputPort = updateInventoryOutputPort;
        this.sendUpdatedInventoryOutputPort = sendUpdatedInventoryOutputPort;
    }


    public void debit(final Sale sale) {
        var inventory = findInventoryByProductIdInputPort.find(sale.getProductId());
        if(inventory.getQuantity() < sale.getQuantity()) {
            throw new RuntimeException("Quantidade em estoque insuficiente");
        }
        inventory.debitQuantity(sale.getQuantity());
        updateInventoryOutputPort.update(inventory);
        sendUpdatedInventoryOutputPort.send(sale, SaleEvent.UPDATED_INVETORY);
    }

}
