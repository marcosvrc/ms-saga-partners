package br.com.sale.application.ports.in;

import br.com.sale.application.core.domain.Sale;

public interface FinalizeSaleInputPort {

    void finalize(Sale sale);
}
