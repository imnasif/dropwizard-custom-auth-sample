package me.nasif.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class AppConfig extends Configuration {

    @Valid
    @NotNull
    @JsonProperty
    private final MongoConfig mongo = new MongoConfig();

    public MongoConfig getMongoConfig() {
        return mongo;
    }

}
