package br.com.sale.adapters.in.controller.mapper;

import br.com.sale.adapters.in.controller.request.SaleRequest;
import br.com.sale.application.core.domain.Sale;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SaleRequestMapper {

    Sale toSale(SaleRequest saleRequest);

}
