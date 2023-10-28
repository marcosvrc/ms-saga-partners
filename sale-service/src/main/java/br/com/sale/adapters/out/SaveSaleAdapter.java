package br.com.sale.adapters.out;

import br.com.sale.adapters.out.repository.SaleRepository;
import br.com.sale.adapters.out.repository.mapper.SaleEntityMapper;
import br.com.sale.application.core.domain.Sale;
import br.com.sale.application.ports.out.SaveSaleOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveSaleAdapter implements SaveSaleOutputPort {

    private final SaleRepository saleRepository;

    private final SaleEntityMapper saleEntityMapper;

    @Autowired
    public SaveSaleAdapter(SaleRepository saleRepository, SaleEntityMapper saleEntityMapper) {
        this.saleRepository = saleRepository;
        this.saleEntityMapper = saleEntityMapper;
    }

    @Override
    public Sale save(Sale sale) {
      var saleEntity = saleEntityMapper.toEntity(sale);
      var saleEntityResponse = saleRepository.save(saleEntity);
      return saleEntityMapper.toSale(saleEntityResponse);
    }
}
