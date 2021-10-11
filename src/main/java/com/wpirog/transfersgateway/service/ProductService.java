package com.wpirog.transfersgateway.service;

import com.wpirog.transfersgateway.domain.AccountDto;
import com.wpirog.transfersgateway.provider.AccountsProvider;
import feign.FeignException;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {
    private static final String CIRCUIT_BREAKER_INSTANCE_NAME = "productService";

    private final AccountsProvider accountsProvider;

    @CircuitBreaker(name = CIRCUIT_BREAKER_INSTANCE_NAME, fallbackMethod = "findCustomersAccountfallback")
    public AccountDto findCustomersAccount(String nrb) {
        return accountsProvider.getCustomerAccounts(nrb);
    }

    private AccountDto findCustomersAccountfallback(String nrb, FeignException ex) {
        log.warn("Can not get accounts for nrb {}", nrb);
        return new AccountDto();
    }

    private AccountDto findCustomersAccountfallback(String nrb, CallNotPermittedException ex) {
        log.warn(ex.getMessage());
        return new AccountDto();
    }
}
