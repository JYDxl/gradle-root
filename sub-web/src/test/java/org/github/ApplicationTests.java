package org.github;

import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.github.base.entity.TipLoginLogEntity;
import org.github.base.service.ISysCodeService;
import org.github.base.service.ITipLoginLogService;
import org.github.common.mapper.ICommonMapper;
import org.github.ops.ObjectOpsKt;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

@RunWith(SpringRunner.class)
@ActiveProfiles({"dev"})
@SpringBootTest
@Slf4j
public class ApplicationTests {
  @Autowired
  private ICommonMapper       commonMapper;
  @Autowired
  private ITipLoginLogService tipLoginLogService;
  @Autowired
  private ISysCodeService     sysCodeService;
  @Autowired
  private AmqpTemplate        amqpTemplate;

  @Test
  public void contextLoads() {
    val now   = commonMapper.now();
    val query = tipLoginLogService.lambdaQuery();
    query
      .eq(TipLoginLogEntity::getLogUser, "hanjian")
      .le(TipLoginLogEntity::getLogTime, LocalDateTime.now());
    val page = query.page(new Page<>(2, 10));
    log.info(ObjectOpsKt.getJson(now));
    log.info(ObjectOpsKt.getJson(page));
    log.info(String.valueOf(page.getTotal()));
  }

  @Test
  public void fibonacciSequence() {
    val list = Stream.iterate(ImmutablePair.of(1, 1), (v) -> ImmutablePair.of(v.right, v.left + v.right)).limit(10).map(ImmutablePair::getLeft).collect(Collectors.toList());
    log.info(ObjectOpsKt.getJson(list));
  }

  @Test
  public void page() {
    val page = commonMapper.page(new Page());
    log.info(ObjectOpsKt.getJson(page));
    val list = sysCodeService.list();
    log.info(ObjectOpsKt.getJson(list));
  }

  @Test
  public void testAmqp() {
    amqpTemplate.convertAndSend("app.queue", new User("admin", "admin"));
  }

  @Test
  public void webAppCtx() {
    val ctx = ObjectOpsKt.getWebAppCtx();
    log.info(ctx.getDisplayName());
  }
}
