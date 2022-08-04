package org.github.config

import io.swagger.annotations.ApiOperation
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors.any
import springfox.documentation.builders.RequestHandlerSelectors.basePackage
import springfox.documentation.builders.RequestHandlerSelectors.withMethodAnnotation
import springfox.documentation.builders.RequestParameterBuilder
import springfox.documentation.service.ParameterType.HEADER
import springfox.documentation.service.ParameterType.QUERY
import springfox.documentation.service.RequestParameter
import springfox.documentation.spi.DocumentationType.OAS_30
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SwaggerConfig {
  @Bean
  fun docket(): Docket {
    return Docket(OAS_30)
      .select()!!
      .apis(withMethodAnnotation(ApiOperation::class.java))!!
      .apis(basePackage("org.github"))!!
      .paths(any())!!
      .build()!!
      .globalRequestParameters(getGlobalRequestParameters())
  }

  fun getGlobalRequestParameters(): List<RequestParameter> = listOf(
    RequestParameterBuilder()
      .name("JWT")
      .description("JWT Token")
      .required(false)
      .`in`(HEADER)
      .build(),
    RequestParameterBuilder()
      .name("JSESSIONID")
      .description("WEB Token")
      .required(false)
      .`in`(QUERY)
      .build(),
  )
}
