package com.wpirog.transfersgateway.controller;

import com.wpirog.transfersgateway.controller.request.TransferRequest;
import com.wpirog.transfersgateway.domain.AccountDto;
import com.wpirog.transfersgateway.mapper.TransferMapper;
import com.wpirog.transfersgateway.service.ProductService;
import com.wpirog.transfersgateway.service.TransferProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1/transfers")
@RequiredArgsConstructor
public class TransferController {

    @Autowired
    private TransferProducer transferProducer;

    @Autowired
    private ProductService productService;

    @Autowired
    private TransferMapper mapper;

    @PostMapping
    public void saveTransfer(@RequestBody TransferRequest request) {
        log.info("Received transfer request {}", request);
        log.info("Checking available funds");
        AccountDto account
                = productService.findCustomersAccount(request.getSenderAccount());
        if (account.getAvailableFunds().compareTo(request.getAmount()) >= 0) {
            log.info("Available funds checked");
            var transfer = mapper.mapToTransfer(request);
            transferProducer.sendTransfer(transfer);
        } else {
            throw new IllegalArgumentException(String.format("Available funds on account %s are less than request amount", request.getSenderAccount()));
        }
    }
}
