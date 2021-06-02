package org.github.config

import io.swagger.annotations.ApiOperation
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.*
import springfox.documentation.schema.ScalarType
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
//            .apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation::class.java))
            .apis(RequestHandlerSelectors.basePackage("org.github"))
            .paths(PathSelectors.any())
            .build()
            .globalRequestParameters(getGlobalRequestParameters())
//            .globalResponses(HttpMethod.GET, getGlobalResonseMessage())
//            .globalResponses(HttpMethod.POST, getGlobalResonseMessage())
    }

//    //生成接口信息，包括标题、联系人等
//    private open fun apiInfo(): ApiInfo? {
//        return ApiInfoBuilder()
//            .title("Swagger3接口文档")
//            .description("如有疑问，请联系开发工程师老刘。")
//            .contact(Contact("刘宏缔", "https://www.cnblogs.com/architectforest/", "371125307@qq.com"))
//            .version("1.0")
//            .build()
//    }

    //生成全局通用参数
    fun getGlobalRequestParameters(): List<RequestParameter> = listOf(
            RequestParameterBuilder()
                .name("Token")
                .description("JWT Token")
                .required(false)
                .`in`(HEADER)
                .build(),
//            RequestParameterBuilder()
//                .name("token")
//                .description("WEB Token")
//                .required(false)
//                .`in`(QUERY)
//                .build(),
        )
//
//    //生成通用响应信息
//      fun getGlobalResonseMessage(): List<Response>? {
//        val responseList: MutableList<Response> = ArrayList<Response>()
//        responseList.add(ResponseBuilder().code("404").description("找不到资源").build())
//        return responseList
//    }
}
