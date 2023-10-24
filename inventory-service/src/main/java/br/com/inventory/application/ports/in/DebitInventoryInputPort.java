package br.com.inventory.application.ports.in;

import br.com.inventory.application.core.domain.Sale;

public interface DebitInventoryInputPort {

    void debit(Sale sale);
}
