package br.com.sale.application.core.usecase;

import br.com.sale.application.core.domain.Sale;
import br.com.sale.application.ports.in.FindSaleByIdInputPort;
import br.com.sale.application.ports.out.FindSaleByIdOutputPort;

public class FindSaleByIdUseCase implements FindSaleByIdInputPort {

    private final FindSaleByIdOutputPort findSaleByIdOutputPort;

    public FindSaleByIdUseCase(final FindSaleByIdOutputPort findSaleByIdOutputPort) {
        this.findSaleByIdOutputPort = findSaleByIdOutputPort;
    }

    @Override
    public Sale find(final Integer id) {
        return findSaleByIdOutputPort.find(id)
                                     .orElseThrow(() -> new IllegalArgumentException("Venda não encontrada"));
    }
}


