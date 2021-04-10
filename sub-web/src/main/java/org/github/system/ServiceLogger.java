package org.github.system;

import lombok.extern.slf4j.*;
import lombok.*;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import static java.util.Arrays.*;

@Component
@Aspect
@Slf4j
public class ServiceLogger {
  @AfterReturning(value = "pointcut()", returning = "value")
  public void afterReturning(JoinPoint point, Object value) {
    val name = point.getSignature().toShortString();
    log.info("返回结果: {} ====> {}", name, value);
  }

  @AfterThrowing(value = "pointcut()", throwing = "e")
  public void afterThrowing(JoinPoint point, Exception e) {
    val name = point.getSignature().toShortString();
    log.error("抛出异常: {} ====> {}", name, e.getMessage());
  }

  @Before("pointcut()")
  public void before(JoinPoint point) {
    val name = point.getSignature().toShortString();
    val args = point.getArgs();
    log.info("执行方法: {}", name);
    log.info("接收参数: {} ====> {}", name, asList(args));
  }

  @Pointcut("execution(* org.github..*ServiceImpl.*(..))")
  public void pointcut() {}
}
