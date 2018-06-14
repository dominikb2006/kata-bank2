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

@Field firstAccount
@Field secondAccount
@Field Set<Account> customerAccounts

Given(~/^there is a bank$/) { ->
    accountRepository = new InMemoryAccountRepository()
    bank = new Bank(accountRepository)
}

Given(~/^a customer has two accounts open$/) { ->
    customer = new Customer()
    firstAccount = new Account(customer)
    secondAccount = new Account(customer)
    accountRepository.addAccount(firstAccount)
    accountRepository.addAccount(secondAccount)
}

When(~/^he lists his accounts$/) { ->
    customerAccounts = bank.getCustomerAccounts(customer)
}

Then(~/^only those accounts are on the list$/) { ->
    assertThat(customerAccounts).containsExactly(
            firstAccount, secondAccount
    )
}