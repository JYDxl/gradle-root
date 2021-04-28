package org.github.ops;

import java.util.ArrayList;
import java.util.List;
import lombok.*;
import lombok.extern.slf4j.*;
import org.github.util.FuncUtil;
import org.junit.jupiter.api.Test;
import static com.google.common.collect.ImmutableListMultimap.*;
import static java.util.function.Function.*;
import static java.util.stream.Collector.of;
import static java.util.stream.Stream.of;
import static org.github.util.FuncUtil.*;

@Slf4j
class FuncUtilTest {
  @Test
  void testOptional1() {
    val map = of(null, new User("first", "last"), new User(), new User("first", null), new User(null, "last")).collect(toImmutableListMultimap(optional(User::getFirstName), optional(identity())));
    log.info(map.toString());
    // Functions.optional(map::get)
  }

  @Test
  void testOptional2() {
    val map = of(null, new User("first", "last"), new User(), new User("first", null), new User(null, "last")).collect(toImmutableListMultimap(optional(User::getFirstName, ""), optional(identity())));
    log.info(map.toString());
    // Functions.optional(map::get)
  }

  @Test
  void throwing() {
    val list = of("1", "2", "3").collect(of(ArrayList::new, List::add, FuncUtil.<List<String>>throwing()));
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
