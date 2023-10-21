package br.com.sales.application.ports.out;

import br.com.sales.application.core.domain.Sale;
import br.com.sales.application.core.domain.enums.SaleEvent;

public interface SendCreatedSaleOutputPort {

    void send(Sale sale, SaleEvent event);
}
