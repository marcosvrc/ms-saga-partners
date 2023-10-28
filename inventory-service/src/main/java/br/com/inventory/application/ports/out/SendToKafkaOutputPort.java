package br.com.inventory.application.ports.out;

import br.com.inventory.application.core.domain.Sale;
import br.com.inventory.application.core.domain.enums.SaleEvent;

public interface SendToKafkaOutputPort {

    void send(Sale sale, SaleEvent event);
}
