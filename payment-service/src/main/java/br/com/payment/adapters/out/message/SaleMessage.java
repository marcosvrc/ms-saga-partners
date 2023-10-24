package br.com.payment.adapters.out.message;

import br.com.payment.application.core.domain.Sale;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import br.com.payment.application.core.domain.enums.SaleEvent;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleMessage {

    private Sale sale;
    private SaleEvent saleEvent;
}
