package org.github.core.logger;

import java.util.Arrays;
import javax.annotation.Nullable;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
@Slf4j
public class MethodInvokeLogger {
  @AfterReturning(value = "pointcut()", returning = "value")
  public void afterReturning(JoinPoint point, @Nullable Object value) {
    val name = point.getSignature().toShortString();
    log.debug("返回结果: {} ====> {}", name, value);
  }

  @AfterThrowing(value = "pointcut()", throwing = "e")
  public void afterThrowing(JoinPoint point, Exception e) {
    val name = point.getSignature().toShortString();
    log.debug("抛出异常: {} ====> {}", name, e.getMessage());
  }

  @Before("pointcut()")
  public void before(JoinPoint point) {
    val name = point.getSignature().toShortString();
    val args = point.getArgs();
    log.debug("执行方法: {} ====> {}", name, Arrays.toString(args));
  }

  @Pointcut("execution(* org.github..*Controller.*(..)) || execution(* org.github..*Service.*(..)) || execution(* org.github..*Mapper.*(..))")
  public void pointcut() {}
}
