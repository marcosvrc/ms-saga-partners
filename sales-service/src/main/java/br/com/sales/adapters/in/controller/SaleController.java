package br.com.sales.adapters.in.controller;

import br.com.sales.adapters.in.controller.mapper.SaleRequestMapper;
import br.com.sales.adapters.in.controller.request.SaleRequest;
import br.com.sales.application.ports.in.CreateSaleInputPort;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1/sales")
public class SaleController {

    private CreateSaleInputPort createSaleInputPort;

    private SaleRequestMapper saleRequestMapper;

    @Autowired
    public SaleController(CreateSaleInputPort createSaleInputPort, SaleRequestMapper saleRequestMapper) {
        this.createSaleInputPort = createSaleInputPort;
        this.saleRequestMapper = saleRequestMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createSale(@Valid @RequestBody SaleRequest saleRequest) {
        log.info("Criando a venda ...");
        createSaleInputPort.create(saleRequestMapper.toSale(saleRequest));
        log.info("Venda criada com sucesso!");
    }
}
