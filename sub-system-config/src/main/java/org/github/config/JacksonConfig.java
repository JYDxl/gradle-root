package org.github.config;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import static cn.hutool.core.date.DatePattern.*;
import static java.time.format.DateTimeFormatter.*;

@Configuration
public class JacksonConfig {
  @Bean
  public GuavaModule guavaModule() {
    return new GuavaModule();
  }

  @Bean
  public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
    return builder -> builder
      .serializerByType(Long.class, ToStringSerializer.instance)
      .serializerByType(Long.TYPE, ToStringSerializer.instance)
      .serializerByType(LocalDate.class, new LocalDateSerializer(ofPattern(NORM_DATE_PATTERN)))
      .serializerByType(LocalTime.class, new LocalTimeSerializer(ofPattern(NORM_TIME_PATTERN)))
      .serializerByType(LocalDateTime.class, new LocalDateTimeSerializer(ofPattern(NORM_DATETIME_PATTERN)))
      .deserializerByType(LocalDate.class, new LocalDateDeserializer(ofPattern(NORM_DATE_PATTERN)))
      .deserializerByType(LocalTime.class, new LocalTimeDeserializer(ofPattern(NORM_TIME_PATTERN)))
      .deserializerByType(LocalDateTime.class, new LocalDateTimeDeserializer(ofPattern(NORM_DATETIME_PATTERN)))
      ;
  }
}
