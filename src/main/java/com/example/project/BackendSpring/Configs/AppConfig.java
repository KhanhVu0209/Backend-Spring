package com.example.project.BackendSpring.Configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app")
public class AppConfig {
    private String secretKey;
    private String expirationInMs;

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getExpirationInMs() {
        return expirationInMs;
    }

    public void setExpirationInMs(String expirationInMs) {
        this.expirationInMs = expirationInMs;
    }
}
