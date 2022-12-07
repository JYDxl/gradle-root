package org.github.core.base;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Stream;
import lombok.extern.slf4j.*;
import lombok.*;
import org.junit.jupiter.api.Test;
import static cn.hutool.core.lang.UUID.*;
import static java.lang.Integer.*;
import static java.lang.Runtime.*;
import static java.util.Comparator.*;
import static java.util.stream.Collector.Characteristics.*;
import static java.util.stream.Collectors.*;
import static java.util.stream.IntStream.*;

@Slf4j
public class StreamTests {
  @Test
  void dropWhile() {
    val stream = range(0, 5);
    val result = stream.dropWhile(num -> num < 3).toArray();
    log.info("result: {}", result);
  }

  @Test
  void parallel() {
    val stream = Stream.of("1", "2", "3", "4", "5");
    val result = stream.parallel().sorted(reverseOrder()).collect(() -> {
      log.info("supplier");
      val list = new ArrayList<String>();
      log.info("list: {}", list);
      return list;
    }, (a, e) -> {
      log.info("accumulator");
      log.info("a: {} e:{}", a, e);
      a.add(e);
    }, (c1, c2) -> {
      log.info("combiner");
      log.info("c1: {} c2: {}", c1, c2);
      c1.addAll(c2);
    });
    log.info("result: {}", result);
  }

  @SuppressWarnings("ResultOfMethodCallIgnored")
  @Test
  void sort() {
    List<String> list = range(0, 400_0000).mapToObj(v -> randomUUID().toString()).toList();
    log.info(Instant.now().toString());
    list.stream().sorted().collect(toList());
    log.info(Instant.now().toString());
    list.stream().parallel().sorted().collect(toList());
    log.info(Instant.now().toString());
  }

  @Test
  void takeWhile() {
    val stream = range(0, 5);
    val result = stream.takeWhile(num -> num < 3).toArray();
    log.info("result: {}", result);
  }

  @Test
  void testMapMulti() {
    val stream = Stream.of("1", "2", "3", "4", "5");
    val result = stream.mapMultiToInt((str, consumer) -> consumer.accept(Integer.parseInt(str))).sum();
    log.info("result: {}", result);
  }

  @Test
  void toConcurrentMapTest() {
    val stream = Stream.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13");
    val result = stream.parallel().collect(Collector.of(() -> {
        log.info("supplier");
        return new ConcurrentHashMap<>();
      }, (map12, str) -> {
        log.info("accumulator");
        map12.put(str, str);
      }, (map1, map2) -> {
        log.info("combiner");
        map1.putAll(map2);
        return map1;
      }, (Function<Map<String,String>,Map<String,String>>) map -> {
        log.info("finisher");
        return map;
      },
      CONCURRENT, UNORDERED));
    log.info("map: {}", result);
  }

  @Test
  void toListTest() {
    log.info(String.valueOf(getRuntime().availableProcessors()));
    val stream = Stream.iterate("1", s -> String.valueOf(parseInt(s) + 1)).limit(100);
    val result = stream.parallel().collect(Collector.of(() -> {
      log.info("supplier");
      return new ArrayList<>();
    }, (list, str) -> {
      log.info("accumulator list: {}\tstr: {}", list, str);
      list.add(str);
    }, (list1, list2) -> {
      log.info("combiner list1: {}\tlist2: {}", list1, list2);
      list1.addAll(list2);
      return list1;
    }, (Function<List<String>,List<String>>) list -> {
      log.info("finisher");
      return list;
    }));
    log.info("list: {}", result);
  }
}
