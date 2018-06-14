package com.plgrnds.tests.bank.steps

this.metaClass.mixin(cucumber.api.groovy.EN)

Given(~/^balance on the account is 100$/) { ->
    account.balance(100)

}
When(~/^customer deposits 10 to this account$/) { ->
    account.depositMoney(10)

}
Then(~/^balance on the account is 110$/) { ->
    account.balance.isEqualTo(110)

}