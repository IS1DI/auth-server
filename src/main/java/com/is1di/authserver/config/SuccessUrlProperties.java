package com.is1di.authserver.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "spring.security")
@Component
@Data
public class SuccessUrlProperties {
    private String successUrl;
}
