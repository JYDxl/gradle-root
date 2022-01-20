package org.github.base;

import lombok.extern.slf4j.*;
import lombok.*;
import org.junit.jupiter.api.Test;
import static java.util.stream.IntStream.*;

@Slf4j
public class StreamTests {
  // @Test
  // void testMapMulti() {
  //   val stream = Stream.of("1", "2", "3", "4", "5");
  //   val result = stream.mapMultiToInt((str, intConsumer) -> {
  //     intConsumer.accept(Integer.parseInt(str));
  //   }).sum();
  //   log.info("result: {}", result);
  // }

  @Test
  void dropWhile() {
    val stream = range(0, 5);
    val result = stream.dropWhile(num -> num < 3).toArray();
    log.info("result: {}", result);
  }

  @Test
  void takeWhile() {
    val stream = range(0, 5);
    val result = stream.takeWhile(num -> num < 3).toArray();
    log.info("result: {}", result);
  }
}
