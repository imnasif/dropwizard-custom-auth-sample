package me.nasif.auth;

import com.google.common.base.Optional;
import io.dropwizard.auth.AuthFilter;
import io.dropwizard.auth.AuthenticationException;
import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.MultivaluedMap;

public class CustomAuthCredentialFilter<P extends Principal> extends AuthFilter<CustomCredentials, CustomUser> {

    @Override
    public void filter(ContainerRequestContext requestContext) {

        MultivaluedMap<String, String> queryParams = requestContext.getUriInfo().getQueryParameters();
        String key = queryParams.getFirst("key");

        final Optional<CustomUser> consumer;
        try {
            consumer = this.authenticator.authenticate(new CustomCredentials(key));
            if (!consumer.isPresent()) {
                throw new WebApplicationException(unauthorizedHandler.buildResponse("Custom", realm));
            }
        } catch (AuthenticationException ex) {
            Logger.getLogger(CustomAuthCredentialFilter.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static class Builder<P extends Principal> extends AuthFilterBuilder<CustomCredentials, CustomUser, CustomAuthCredentialFilter<P>> {

        @Override
        protected CustomAuthCredentialFilter<P> newInstance() {
            return new CustomAuthCredentialFilter<>();
        }
    }

}
