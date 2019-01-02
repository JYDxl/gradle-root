package org.github.config;

import java.time.LocalDateTime;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.autoconfigure.jackson.JacksonProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import static java.time.format.DateTimeFormatter.ofPattern;

@Configuration
public class JacksonConfig {
  @Bean
  public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer(LocalDateTimeSerializer serializer) {
    return builder -> builder.serializerByType(LocalDateTime.class, serializer);
  }

  @Bean
  public LocalDateTimeSerializer localDateTimeSerializer(JacksonProperties prop) {
    return new LocalDateTimeSerializer(ofPattern(prop.getDateFormat()));
  }
}
