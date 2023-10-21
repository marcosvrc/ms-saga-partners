package br.com.sales.application.ports.out;

import br.com.sales.application.core.domain.Sale;
public interface SaveSaleOutputPort {

    Sale save(Sale sale);
}
