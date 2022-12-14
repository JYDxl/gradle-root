package org.github.common.config

import cn.hutool.core.date.DatePattern.NORM_DATETIME_PATTERN
import cn.hutool.core.date.DatePattern.NORM_DATE_PATTERN
import cn.hutool.core.date.DatePattern.NORM_TIME_PATTERN
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer.instance
import com.fasterxml.jackson.datatype.guava.GuavaModule
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer
import java.lang.Long.TYPE
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter.ofPattern
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder

@Configuration
class JacksonConfig {
    @Bean
    fun guavaModule(): GuavaModule {
        return GuavaModule()
    }

    @Bean
    fun jackson2ObjectMapperBuilderCustomizer(): Jackson2ObjectMapperBuilderCustomizer {
        return Jackson2ObjectMapperBuilderCustomizer { it: Jackson2ObjectMapperBuilder ->
            it
                .serializerByType(Long::class.java, instance)
                .serializerByType(TYPE, instance)
                .serializerByType(LocalDate::class.java, LocalDateSerializer(ofPattern(NORM_DATE_PATTERN)))
                .serializerByType(LocalTime::class.java, LocalTimeSerializer(ofPattern(NORM_TIME_PATTERN)))
                .serializerByType(LocalDateTime::class.java, LocalDateTimeSerializer(ofPattern(NORM_DATETIME_PATTERN)))
                .deserializerByType(LocalDate::class.java, LocalDateDeserializer(ofPattern(NORM_DATE_PATTERN)))
                .deserializerByType(LocalTime::class.java, LocalTimeDeserializer(ofPattern(NORM_TIME_PATTERN)))
                .deserializerByType(LocalDateTime::class.java, LocalDateTimeDeserializer(ofPattern(NORM_DATETIME_PATTERN)))
        }
    }
}
