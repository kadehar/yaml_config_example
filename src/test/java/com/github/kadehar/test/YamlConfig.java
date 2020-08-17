package com.github.kadehar.test;

import com.github.kadehar.config.model.Credentials;
import com.github.kadehar.config.model.Endpoint;
import com.github.kadehar.config.model.Repository;
import org.junit.jupiter.api.Test;

import static com.github.kadehar.config.YamlHelper.yaml;
import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class YamlConfig {
    private Credentials credentials;
    private Endpoint endpoint;
    private Repository repository;

    @Test
    public void readCredentialsFromConfig() {
        step("Get credentials from config file",
                () -> credentials = yaml().readConfig().getCredentials());

        parameter("Actual login", credentials.getLogin());
        parameter("Actual password", credentials.getPassword());

        String expectedLogin = "test";
        String expectedPassword = "test";
        step("Assert that login equals " + expectedLogin,
                () -> assertEquals(expectedLogin, credentials.getLogin()));
        step("Assert that password equals " + expectedPassword,
                () -> assertEquals(expectedPassword, credentials.getPassword()));
    }

    @Test
    public void readEndpointUrlFromConfig() {
        step("Get endpoint from config file",
                () -> endpoint = yaml().readConfig().getEndpoint());

        parameter("Actual endpoint", endpoint.getUrl());

        String expectedEndpoint = "https://github.com/";
        step("Assert that url equals " + expectedEndpoint,
                () -> assertEquals(expectedEndpoint, endpoint.getUrl()));
    }

    public void readRepositoryUrlFromConfig() {
        step("Get repository from config file",
                () -> repository = yaml().readConfig().getRepository());

        parameter("Actual repository", repository.getUrl());

        String expectedEndpoint = "https://github.com/kadehar/yaml_config_example";
        step("Assert that url equals " + expectedEndpoint,
                () -> assertEquals(expectedEndpoint, repository.getUrl()));
    }
}
