package br.com.sale.adapters.out;

import br.com.sale.adapters.out.repository.SaleRepository;
import br.com.sale.adapters.out.repository.mapper.SaleEntityMapper;
import br.com.sale.application.core.domain.Sale;
import br.com.sale.application.ports.out.FindSaleByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindSaleByIdAdapter implements FindSaleByIdOutputPort {

    private final SaleRepository saleRepository;

    private final SaleEntityMapper saleEntityMapper;

    @Autowired
    public FindSaleByIdAdapter(SaleRepository saleRepository, SaleEntityMapper saleEntityMapper) {
        this.saleRepository = saleRepository;
        this.saleEntityMapper = saleEntityMapper;
    }

    @Override
    public Optional<Sale> find(final Integer id) {
        var saleEntity = saleRepository.findById(id);
        return saleEntity.map(saleEntityMapper::toSale);
    }
}
