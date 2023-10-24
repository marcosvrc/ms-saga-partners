package br.com.sale.application.ports.out;

import br.com.sale.application.core.domain.Sale;
public interface SaveSaleOutputPort {

    Sale save(Sale sale);
}
