package br.com.sale.application.ports.out;


import br.com.sale.application.core.domain.Sale;

import java.util.Optional;

public interface FindSaleByIdOutputPort {

    Optional<Sale> find(final Integer id);
}
