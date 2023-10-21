package br.com.sales.adapters.in.controller.mapper;

import br.com.sales.adapters.in.controller.request.SaleRequest;
import br.com.sales.application.core.domain.Sale;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SaleRequestMapper {

    Sale toSale(SaleRequest saleRequest);

}
