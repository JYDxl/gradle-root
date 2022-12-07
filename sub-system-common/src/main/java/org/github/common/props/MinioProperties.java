package org.github.common.props;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("minio")
@Component
@Data
public class MinioProperties {
    private String url;
    private String accessKey;
    private String secretKey;
}
