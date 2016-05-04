package me.nasif.auth;

import java.security.Principal;

public class CustomUser implements Principal {

    final String consumerName;

    public CustomUser(String userName) {
        this.consumerName = userName;
    }

    @Override
    public String getName() {
        return consumerName;
    }

}
