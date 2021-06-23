package org.github.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "org.github.security")
@Data
public class SecurityProperties {
    private String hashAlgorithm = "SHA-256";

    private int hashIterations = 2;
}
