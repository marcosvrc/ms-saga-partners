package br.com.inventory.application.core.usecase;

import br.com.inventory.application.core.domain.Sale;
import br.com.inventory.application.core.domain.enums.SaleEvent;
import br.com.inventory.application.ports.in.DebitInventoryInputPort;
import br.com.inventory.application.ports.in.FindInventoryByProductIdInputPort;
import br.com.inventory.application.ports.out.SendToKafkaOutputPort;
import br.com.inventory.application.ports.out.UpdateInventoryOutputPort;

public class DebitInventoryUseCase implements DebitInventoryInputPort {

    private final FindInventoryByProductIdInputPort findInventoryByProductIdInputPort;

    private final UpdateInventoryOutputPort updateInventoryOutputPort;

    private final SendToKafkaOutputPort sendToKafkaOutputPort;

    public DebitInventoryUseCase(final FindInventoryByProductIdInputPort findInventoryByProductIdInputPort,
                                 final UpdateInventoryOutputPort updateInventoryOutputPort,
                                 final SendToKafkaOutputPort sendToKafkaOutputPort) {
        this.findInventoryByProductIdInputPort = findInventoryByProductIdInputPort;
        this.updateInventoryOutputPort = updateInventoryOutputPort;
        this.sendToKafkaOutputPort = sendToKafkaOutputPort;
    }


    @Override
    public void debit(final Sale sale) {
        try {
            var inventory = findInventoryByProductIdInputPort.find(sale.getProductId());
            if (inventory.getQuantity() < sale.getQuantity()) {
                throw new RuntimeException("Quantidade em estoque insuficiente");
            }
            inventory.debitQuantity(sale.getQuantity());
            updateInventoryOutputPort.update(inventory);
            sendToKafkaOutputPort.send(sale, SaleEvent.UPDATED_INVETORY);
        } catch (Exception e) {
            sendToKafkaOutputPort.send(sale, SaleEvent.ROLLBACK_INVENTORY);
        }
    }
}
