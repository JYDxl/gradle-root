package org.github.java;

import java.util.stream.Stream;
import lombok.extern.slf4j.*;
import lombok.*;
import org.junit.jupiter.api.Test;
import cn.hutool.core.lang.Pair;
import static java.util.stream.Collectors.*;

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
