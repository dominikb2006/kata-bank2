package com.plgrnds.tests.bank

import spock.lang.Specification

import static org.assertj.core.api.Assertions.*

class InMemoryAccountRepositoryTest extends Specification {

    private final InMemoryAccountRepository repository = new InMemoryAccountRepository()

    def "empty set if no account held for customer"() {
        expect:
        assertThat(repository.getAccountsForCustomer(customer)).isEmpty()

        where:
        customer = new Customer()
    }

    def "account can be stored and retrieved from repository"() {
        when:
        repository.addAccount(account)

        then:
        assertThat(repository.getAccountsForCustomer(customer)).containsExactly(account)

        where:
        customer = new Customer()
        account = new Account(customer)
    }

    def "two accounts can be stored and both accounts are returned from repository"() {
        when:
        repository.addAccount(firstAccount)
        repository.addAccount(secondAccount)

        then:
        assertThat(repository.getAccountsForCustomer(customer)).containsExactly(firstAccount, secondAccount)

        where:
        customer = new Customer()
        firstAccount = new Account(customer)
        secondAccount = new Account(customer)
    }

}
