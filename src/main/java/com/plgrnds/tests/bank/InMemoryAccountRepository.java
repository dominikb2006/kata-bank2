package com.plgrnds.tests.bank;

import com.google.common.collect.Sets;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static java.util.Collections.emptySet;

public class InMemoryAccountRepository implements AccountRepository {

    private Map<Customer, Set<Account>> accountsByCustomer = new HashMap<>();

    @Override
    public void addAccount(Account accountToAdd) {
        accountsByCustomer.merge(accountToAdd.getOwner(), Collections.singleton(accountToAdd), Sets::union);
    }

    @Override
    public Set<Account> getAccountsForCustomer(Customer customer) {
        return accountsByCustomer.getOrDefault(customer, emptySet());
    }

}
