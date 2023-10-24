package br.com.sale.application.ports.out;

import br.com.sale.application.core.domain.Sale;
import br.com.sale.application.core.domain.enums.SaleEvent;

public interface SendCreatedSaleOutputPort {

    void send(Sale sale, SaleEvent event);
}
