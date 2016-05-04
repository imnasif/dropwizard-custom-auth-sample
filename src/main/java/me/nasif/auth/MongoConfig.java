package me.nasif.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

public class MongoConfig {

    @NotEmpty
    @JsonProperty
    private String url;

    @NotEmpty
    @JsonProperty
    private String db;

    public String getDbUrl() {
        return url;
    }

    public String getDbName() {
        return db;
    }

}
