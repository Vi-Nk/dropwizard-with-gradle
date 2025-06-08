package dev.vink.example.config;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.core.Configuration;
import jakarta.validation.constraints.NotNull;

public class AppConfig extends Configuration {
    @NotNull
    private String environment;

    private String apiVersion = "v1";

    @JsonProperty
    public String getEnvironment() {
        return environment;
    }

    @JsonProperty
    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    @JsonProperty
    public String getApiVersion() {
        return apiVersion;
    }

    @JsonProperty
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

}
