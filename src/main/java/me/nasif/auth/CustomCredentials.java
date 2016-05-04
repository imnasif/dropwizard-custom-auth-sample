package me.nasif.auth;

public class CustomCredentials {

    private final String token;

    public CustomCredentials(String key) {
        this.token = key;
    }

    public String getToken() {
        return token;
    }
}
