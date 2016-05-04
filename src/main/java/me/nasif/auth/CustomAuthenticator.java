package me.nasif.auth;

import com.google.common.base.Optional;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;

public class CustomAuthenticator implements Authenticator<CustomCredentials, CustomUser> {

    @Override
    public Optional<CustomUser> authenticate(CustomCredentials credentials) throws AuthenticationException {
        return getUserFromDb(credentials.getToken());
    }

    private Optional<CustomUser> getUserFromDb(String token) {
        // Get UserInfo (May be from DB) with this token
        if (token.equals("a")) { // Db has user with this token
            return Optional.fromNullable(new CustomUser("Custom User With token : ".concat(token)));
        } else {
            return Optional.absent();
        }

    }

}
