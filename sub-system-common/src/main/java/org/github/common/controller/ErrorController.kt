package org.github.common.controller

import javax.servlet.http.HttpServletRequest
import lombok.Getter
import lombok.extern.slf4j.Slf4j
import org.github.core.spring.restful.json.JSONReturn
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.web.ErrorProperties
import org.springframework.boot.autoconfigure.web.ErrorProperties.IncludeAttribute.ALWAYS
import org.springframework.boot.autoconfigure.web.ErrorProperties.IncludeAttribute.ON_PARAM
import org.springframework.boot.autoconfigure.web.ServerProperties
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController
import org.springframework.boot.web.error.ErrorAttributeOptions
import org.springframework.boot.web.servlet.error.ErrorAttributes
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Getter
@Slf4j
@RequestMapping("/error")
class ErrorController @Autowired constructor(errorAttributes: ErrorAttributes, serverProperties: ServerProperties) : AbstractErrorController(errorAttributes) {
    private val errorProperties: ErrorProperties

    init {
        errorProperties = serverProperties.error
    }

    @RequestMapping
    fun error(request: HttpServletRequest): JSONReturn {
        // Map<String,Object> body  = getErrorAttributes(request, getErrorAttributeOptions(request));
        // Object             trace = body.get("trace");
        // if (trace != null) {
        //   return ex(trace);
        // } else {
        //   HttpStatus status = getStatus(request);
        //   return JSONReturn.of(status, null);
        // }
        val status = getStatus(request)!!
        return JSONReturn.of(status, null)
    }

    @Suppress("unused")
    protected fun getErrorAttributeOptions(request: HttpServletRequest): ErrorAttributeOptions {
        var options = ErrorAttributeOptions.defaults()
        if (errorProperties.isIncludeException) {
            options = options.including(ErrorAttributeOptions.Include.EXCEPTION)
        }
        if (isIncludeStackTrace(request)) {
            options = options.including(ErrorAttributeOptions.Include.STACK_TRACE)
        }
        if (isIncludeMessage(request)) {
            options = options.including(ErrorAttributeOptions.Include.MESSAGE)
        }
        if (isIncludeBindingErrors(request)) {
            options = options.including(ErrorAttributeOptions.Include.BINDING_ERRORS)
        }
        return options
    }

    // @NotNull
    // private JSONReturn ex(Object trace) {
    //   String info = trace.toString().lines().findFirst().orElse("");
    //   if (isNotBlank(info)) {
    //     String[] split = info.split(":", 2);
    //     String   ex    = split[0];
    //     String   msg   = split[1];
    //     if (Objects.equals("cn.dev33.satoken.exception.NotLoginException", ex)) {
    //       return JSONReturn.of(UNAUTHORIZED, msg);
    //     }
    //   }
    //   return JSONReturn.of(INTERNAL_SERVER_ERROR, null);
    // }
    protected fun isIncludeStackTrace(request: HttpServletRequest): Boolean {
        return when (errorProperties.includeStacktrace) {
            ALWAYS -> true
            ON_PARAM -> getTraceParameter(request)
            else -> false
        }
    }

    protected fun isIncludeMessage(request: HttpServletRequest): Boolean {
        return when (errorProperties.includeMessage) {
            ALWAYS -> true
            ON_PARAM -> getMessageParameter(request)
            else -> false
        }
    }

    protected fun isIncludeBindingErrors(request: HttpServletRequest): Boolean {
        return when (errorProperties.includeBindingErrors) {
            ALWAYS -> true
            ON_PARAM -> getErrorsParameter(request)
            else -> false
        }
    }
}
