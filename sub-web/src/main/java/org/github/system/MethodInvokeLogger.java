package org.github.system;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;
import java.util.function.Supplier;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;

@Aspect
@Slf4j
@Data
public class MethodInvokeLogger {
  private final boolean getMode;

  @AfterReturning(value = "pointcut()", returning = "value")
  public void afterReturning(JoinPoint point, Object value) {
    val name = point.getSignature().toShortString();
    val res = getMode && value instanceof Supplier ? ((Supplier<?>) value).get() : value;
    log.info("返回结果: {} ====> {}", name, res);
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
    val res = getMode ? stream(args).map(v -> v instanceof Supplier ? ((Supplier<?>) v).get() : v).map(String::valueOf).collect(joining(", ", "[", "]")) : Arrays.toString(args);
    log.info("执行方法: {} ====> {}", name, res);
  }

  @Pointcut("execution(* org.github..*Controller.*(..)) || execution(* org.github..*Service.*(..)) || execution(* org.github..*Mapper.*(..))")
  public void pointcut() {}
}
