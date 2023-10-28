package br.com.inventory.application.core.usecase;

import br.com.inventory.application.core.domain.Sale;
import br.com.inventory.application.core.domain.enums.SaleEvent;
import br.com.inventory.application.ports.in.CreditInventoryInputPort;
import br.com.inventory.application.ports.in.FindInventoryByProductIdInputPort;
import br.com.inventory.application.ports.out.SendToKafkaOutputPort;
import br.com.inventory.application.ports.out.UpdateInventoryOutputPort;

public class CreditInventoryUseCase implements CreditInventoryInputPort {

    private final FindInventoryByProductIdInputPort findInventoryByProductIdInputPort;

    private final UpdateInventoryOutputPort updateInventoryOutputPort;

    private final SendToKafkaOutputPort sendToKafkaOutputPort;

    public CreditInventoryUseCase(final FindInventoryByProductIdInputPort findInventoryByProductIdInputPort,
                                  final UpdateInventoryOutputPort updateInventoryOutputPort,
                                  final SendToKafkaOutputPort sendToKafkaOutputPort) {
        this.findInventoryByProductIdInputPort = findInventoryByProductIdInputPort;
        this.updateInventoryOutputPort = updateInventoryOutputPort;
        this.sendToKafkaOutputPort = sendToKafkaOutputPort;
    }

    @Override
    public void credit(Sale sale) {
        var inventory = findInventoryByProductIdInputPort.find(sale.getProductId());
        inventory.creditQuantity(sale.getQuantity());
        updateInventoryOutputPort.update(inventory);
        sendToKafkaOutputPort.send(sale, SaleEvent.ROLLBACK_INVENTORY);
    }
}
