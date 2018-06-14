package com.plgrnds.tests.bank.steps

import com.plgrnds.tests.bank.Account
import com.plgrnds.tests.bank.AccountRepository
import com.plgrnds.tests.bank.Bank
import com.plgrnds.tests.bank.Customer
import com.plgrnds.tests.bank.InMemoryAccountRepository
import groovy.transform.Field

import static org.assertj.core.api.Assertions.assertThat

this.metaClass.mixin(cucumber.api.groovy.EN)

@Field AccountRepository accountRepository
@Field Customer customer
@Field Bank bank

@Field AccountA
@Field AccountB
@Field Transfer
@Field Set<Account> customerAccounts

Given(~/^there is a bank$/) { ->
    accountRepository = new InMemoryAccountRepository()
    bank = new Bank(accountRepository)
}

Given(~/^balance on account A is 100 and balance on account B is 1000$/) { ->
    accountA = new Account(customer1);
    bank.createAccount(accountA);
    bank.deposit(accountA, 100);

    accountB = new Account(customer2);
    bank.createAccount(accountB);
    bank.deposit(accountB, 1000$);
 }


When(~/^99.91 is transfered from account A to B$/) { ->
    amount=99.91
    bank.transfer(accountA, accountB, amount);
}

Then(~/^balance on account A is 0.09 And balance on account B is 1099.91$/) { ->
    AccountA.balance -= Transfer
    AccountB.balance += Transfer
}