package com.wpirog.transfersgateway.provider;


import com.wpirog.transfersgateway.connector.AccountConnector;
import com.wpirog.transfersgateway.domain.AccountDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountsProvider {
    private final AccountConnector connector;

    public AccountDto getCustomerAccounts(String nrb) {
        return connector.getAccount(nrb);
    }
}
