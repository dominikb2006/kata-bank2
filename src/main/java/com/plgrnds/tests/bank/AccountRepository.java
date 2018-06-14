package com.plgrnds.tests.bank;

import java.util.Set;

public interface AccountRepository {

    void addAccount(Account accountToAdd);

    Set<Account> getAccountsForCustomer(Customer customer);
}
