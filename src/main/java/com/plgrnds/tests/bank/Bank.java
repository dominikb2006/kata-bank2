package com.plgrnds.tests.bank;

import java.util.Set;

public class Bank {

	private final AccountRepository accountRepository;

	public Bank(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	public Set<Account> getCustomerAccounts(Customer customer) {
		return accountRepository.getAccountsForCustomer(customer);
	}

}
