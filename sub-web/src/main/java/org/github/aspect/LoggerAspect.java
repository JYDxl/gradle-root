package org.github.aspect;

import lombok.extern.slf4j.*;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import static com.google.common.base.Strings.*;
import static java.lang.System.*;
import static org.github.ops.LoggersKt.*;

@Component
@Aspect
@Slf4j
public class LoggerAspect {
  @Around("execution(* org.github..service.impl..*.*(..))")
  public Object recordTimeLog(ProceedingJoinPoint joinPoint) throws Throwable {
    info(log, null, () -> lenientFormat("==== 开始执行 %s.%s ====", joinPoint.getTarget().getClass(), joinPoint.getSignature().getName()));
    long   begin  = currentTimeMillis();
    Object result = joinPoint.proceed();
    long   end    = currentTimeMillis();
    long   time   = end - begin;
    info(log, null, () -> lenientFormat("==== 执行结束 %s.%s ====", joinPoint.getTarget().getClass(), joinPoint.getSignature().getName()));
    info(log, null, () -> lenientFormat("==== 执行方法 %s.%s 共花费%sms,结果为:[%s] ====", joinPoint.getTarget().getClass(), joinPoint.getSignature().getName(), time, result));
    return result;
  }
}
