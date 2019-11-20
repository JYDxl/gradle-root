package org.github;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.github.ops.ObjectOpsKt;
import org.github.spring.redis.StringHashOps;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
public class ApplicationTests {
  @Autowired
  private AmqpTemplate        amqpTemplate;
  @Autowired
  private StringRedisTemplate stringRedisTemplate;
  @Autowired
  private StringHashOps       stringHashOps;

  @Test
  public void fibonacciSequence() {
    val list = Stream.iterate(ImmutablePair.of(1, 1), (v) -> ImmutablePair.of(v.right, v.left + v.right)).limit(10).map(ImmutablePair::getLeft).collect(Collectors.toList());
    log.info(ObjectOpsKt.json(list, null));
  }

  @Test
  public void testAmqp() {
    amqpTemplate.convertAndSend("app.queue", new User("admin", "admin"));
  }

  @Test
  public void testRedis() {
    // val opsForHash = stringRedisTemplate.<String, String>opsForHash();
    // opsForHash.delete("hash", 1,2,3,4);
    // opsForHash.get("hash",1);
    stringHashOps.put("hash", "1", "菜");
    val hvalue = stringHashOps.get("hash", 1);
    log.info(hvalue);
  }

  @Test
  public void webAppCtx() {
    val ctx = ObjectOpsKt.getWebAppCtx();
    log.info(ctx.getDisplayName());
  }
}
