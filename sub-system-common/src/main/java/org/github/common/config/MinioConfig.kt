package org.github.common.config

import io.minio.MinioClient
import okhttp3.OkHttpClient
import org.github.core.minio.MinioWrapper
import org.github.core.props.MinioProperties
import org.springframework.cloud.commons.httpclient.DefaultOkHttpClientFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MinioConfig {
    @Bean
    fun minioWrapper(props: MinioProperties): MinioWrapper {
        val httpClient = DefaultOkHttpClientFactory(OkHttpClient().newBuilder())
            .createBuilder(true)
            .retryOnConnectionFailure(true)
            .build()
        val minioClient = MinioClient.builder()
            .httpClient(httpClient)
            .endpoint(props.url)
            .credentials(props.accessKey, props.secretKey)
            .build()!!
        return MinioWrapper(minioClient)
    }
}
