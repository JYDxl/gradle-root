package org.github.core.future;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import lombok.extern.slf4j.*;
import org.junit.jupiter.api.Test;
import static java.util.stream.Collectors.*;
import static java.util.stream.Stream.*;

@Slf4j
public class FutureTaskTest {
  @Test
  void fill() {
    List<String> collect = generate(() -> (String) null).limit(10).collect(toList());
    log.info("collect: {}", collect);
  }

  @Test
  void test() {
    FutureTask<String> task = new FutureTask<>(() -> {
      TimeUnit.SECONDS.sleep(5);
      log.info("Hello world");
      return "hello";
    });
    new Thread(task).start();
    try {
      task.get(1, TimeUnit.SECONDS);
    } catch (InterruptedException | ExecutionException | TimeoutException e) {
      //这里抛出的InterruptedException是get被中断的异常，ExecutionException是task执行产生的异常，TimeoutException是get超时的异常
      //抛出超时异常或者中断异常(程序自身)不会干扰到task的执行
      e.printStackTrace();
    }
  }
}
