package com.plgrnds.tests.bank;

import java.util.Objects;
import java.util.UUID;

public class Account {

    private final UUID id;
    private final Customer owner;

    public Account(Customer owner) {
        id = UUID.randomUUID();
        this.owner = owner;
    }

    public Customer getOwner() {
        return owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

}
