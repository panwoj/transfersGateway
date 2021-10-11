package com.wpirog.transfersgateway.mapper;

import com.wpirog.commons.Transfer;
import com.wpirog.transfersgateway.controller.request.TransferRequest;
import org.springframework.stereotype.Component;

@Component
public class TransferMapper {
    public Transfer mapToTransfer(TransferRequest request) {
        var transfer = new Transfer();
        transfer.setAmount(request.getAmount());
        transfer.setTitle(request.getTitle());
        transfer.setRecipientAccount(request.getRecipientAccount());
        transfer.setSenderAccount(request.getSenderAccount());
        return transfer;
    }
}
