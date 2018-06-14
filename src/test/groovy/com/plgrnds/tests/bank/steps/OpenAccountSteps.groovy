package com.plgrnds.tests.bank.steps

import com.plgrnds.tests.bank.Account
import com.plgrnds.tests.bank.AccountRepository
import com.plgrnds.tests.bank.Bank
import com.plgrnds.tests.bank.Customer
import com.plgrnds.tests.bank.InMemoryAccountRepository
import groovy.transform.Field

import static org.assertj.core.api.Assertions.*

this.metaClass.mixin(cucumber.api.groovy.EN)

@Field AccountRepository accountRepository
@Field Customer customer
@Field Bank bank

@Field newAccount
@Field Set<Account> customerAccounts

Given(~/^there is a bank$/) { ->
    accountRepository = new InMemoryAccountRepository()
    bank = new Bank(accountRepository)
}

Given(~/^a customer wants to open an account$/) { ->
    customer = new Customer("Imie","Nazwisko")
    newCustomerAccount=new Account(customer)

}

When(~/^his account is created$/) { ->
    accountRepository = new HashSet<>();
    bank = new Bank(accountRepository);
    bank.createAccount(newCustomertAccount);
}

Then(~/^there is a new account on his account list$/) { ->
    customerAccounts = bank.getCustomerAccounts(customer);
    assertEquals(1, customerAccounts.size());
}
And(~/^the balance on this account is 0$/){->
    newAccount.balance.isEqualTo(0)
    assertEquals(balance, customerAccounts.get(0).getBalance(), 0.001);
}