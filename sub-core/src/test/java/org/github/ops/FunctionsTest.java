package org.github.ops;

import java.util.ArrayList;
import java.util.List;
import lombok.*;
import lombok.extern.slf4j.*;
import org.junit.jupiter.api.Test;
import static java.util.stream.Collector.of;
import static java.util.stream.Collectors.*;
import static java.util.stream.Stream.of;
import static org.github.ops.Functions.*;

@Slf4j
class FunctionsTest {
  @Test
  void testOptional1() {
    val map = of(null, new User("first", "last"), new User(), new User("first", null), new User(null, "last")).collect(groupingBy(optional(User::getFirstName)));
    log.info(map.toString());
    // Functions.optional(map::get)
  }

  @Test
  void testOptional2() {
    val map = of(null, new User("first", "last"), new User(), new User("first", null), new User(null, "last")).collect(groupingBy(optional(User::getFirstName, "")));
    log.info(map.toString());
    // Functions.optional(map::get)
  }

  @Test
  void throwing() {
    val list = of("1", "2", "3").collect(of(ArrayList::new, List::add, Functions.<List<String>>throwing()));
    log.info(list.toString());
  }
}

@AllArgsConstructor
@NoArgsConstructor
@Data
class User {
  private String firstName;

  private String lastName;
}
