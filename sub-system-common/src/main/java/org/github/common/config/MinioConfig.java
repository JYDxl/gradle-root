package org.github.common.config;

import io.minio.MinioClient;
import okhttp3.OkHttpClient;
import org.github.common.props.MinioProperties;
import org.github.core.minio.MinioWrapper;
import org.springframework.cloud.commons.httpclient.DefaultOkHttpClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinioConfig {
    @Bean
    public MinioWrapper minioWrapper(MinioProperties props) {
        OkHttpClient httpClient = new DefaultOkHttpClientFactory(new OkHttpClient().newBuilder())
                .createBuilder(true)
                .retryOnConnectionFailure(true)
                .build();

        MinioClient minioClient = MinioClient
                .builder().httpClient(httpClient)
                .endpoint(props.getUrl())
                .credentials(props.getAccessKey(), props.getSecretKey())
                .build();

        return new MinioWrapper(minioClient);
    }
}
