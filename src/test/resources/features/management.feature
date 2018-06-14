Feature: Bank

  Background:
    Given there is a bank

  Scenario: list accounts
    Given a customer has two accounts open
    When he lists his accounts
    Then only those accounts are on the list

  Scenario: open account
    Given a customer wants to open an account
    When his account is created
    Then there is a new account on his account list
    And the balance on this account is 0

  Scenario: transfer money
    Given balance on account A is 100
    And balance on account B is 1000
    When 99.91 is transfered from account A to B
    Then balance on account A is 0.09
    And balance on account B is 1099.91

  Scenario: deposit money
    Given balance on the account is 100
    When customer deposits 10 to this account
    Then balance on the account is 110

  Scenario: withdrawn money
    Given balance on the account is 100
    When customer withdrawns 90 to this account
    Then balance on the account is 10
