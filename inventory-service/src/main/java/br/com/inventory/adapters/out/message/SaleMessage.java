package br.com.inventory.adapters.out.message;

import br.com.inventory.application.core.domain.Sale;
import br.com.inventory.application.core.domain.enums.SaleEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleMessage {

    private Sale sale;
    private SaleEvent event;
}
