package org.github.core.java;

import cn.hutool.core.lang.Pair;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.Test;
import static java.util.stream.Collectors.joining;

@Slf4j
public class StreamTests {
  @Test
  void testIterate() {
    val result = Stream
      .iterate(Pair.of(0L, 1L), v -> v.getKey() < 50, v -> Pair.of(v.getValue(), v.getKey() + v.getValue()))
      .map(v -> v.getKey().toString())
      .collect(joining(", "));

    log.info(result);
  }

  @Test
  void testIterateWithLimit() {
    val result = Stream
      .iterate(Pair.of(0L, 1L), v -> Pair.of(v.getValue(), v.getKey() + v.getValue()))
      .limit(10)
      .map(v -> v.getKey().toString())
      .collect(joining(", "));

    log.info(result);
  }
}
