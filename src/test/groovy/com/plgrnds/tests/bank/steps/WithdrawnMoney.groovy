package com.plgrnds.tests.bank.steps

this.metaClass.mixin(cucumber.api.groovy.EN)


Given (~/^balance on the account is 100$/){->
    deposit = new Deposit(account, 100);
    bank.createDeposit(deposit);
    assertEquals(100 , deposit.getBalance(),0.001);
}
When (~/^customer withdrawns 90 to this account$/){->
    clientDeposits= bank.getClientDeposits(customer);
    assertEquals(1, customerDeposits.size());
    assertEquals(90 , clientDeposits.get(0).getBalance(),0.001);
}
Then (~/^balance on the account is 10$/){->
account.setBalance.isEqualTo(10)
}