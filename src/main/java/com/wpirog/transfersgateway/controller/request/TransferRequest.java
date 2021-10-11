package com.wpirog.transfersgateway.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferRequest {
    private String senderAccount;
    private String recipientAccount;
    private String title;
    private BigDecimal amount;
}
