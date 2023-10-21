package br.com.sales.application.ports.in;

import br.com.sales.application.core.domain.Sale;

public interface CreateSaleInputPort {

    void create(Sale sale);
}
