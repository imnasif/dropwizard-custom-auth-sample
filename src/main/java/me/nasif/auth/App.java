package me.nasif.auth;

import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.setup.Environment;

public class App extends Application<AppConfig> {

    public static void main(final String[] args) throws Exception {
        new App().run(args);
    }

    @Override
    public String getName() {
        return "custom-auth-sample";
    }

    @Override
    public void run(AppConfig config, Environment env) throws Exception {
        env.jersey().register(new AuthDynamicFeature(new CustomAuthCredentialFilter.Builder<>().setAuthenticator(new CustomAuthenticator()).buildAuthFilter()));
        env.jersey().register(new CustomResource());

    }

}
