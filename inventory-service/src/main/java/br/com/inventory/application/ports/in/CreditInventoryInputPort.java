package br.com.inventory.application.ports.in;

import br.com.inventory.application.core.domain.Sale;

public interface CreditInventoryInputPort {

    void credit(Sale sale);
}
