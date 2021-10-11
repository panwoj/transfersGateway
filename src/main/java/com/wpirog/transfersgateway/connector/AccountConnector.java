package com.wpirog.transfersgateway.connector;

import com.wpirog.transfersgateway.domain.AccountDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("accounts")
public interface AccountConnector {
    @GetMapping("v1/accounts")
    AccountDto getAccount(@RequestParam String nrb);
}
