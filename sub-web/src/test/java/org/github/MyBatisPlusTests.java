package org.github;

import lombok.extern.slf4j.*;
import lombok.*;
import org.github.base.entity.TbUserEntity;
import org.github.base.mapper.ITbUserMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
public class MyBatisPlusTests {
  @Autowired
  private ITbUserMapper userMapper;

  @Test
  public void testInsert() {
    val user = new TbUserEntity();
    user.setUserName("coco");
    user.setPassword("123456");
    user.setName("曹操");
    user.setAge(30);
    user.setEmail("1@itcast.cn");
    user.insert();
    log.info(user.json());
  }

  @Test
  public void testSelectList() {
    val entityList = userMapper.selectList(null);
    entityList.forEach((entity) -> log.info(entity.json()));
  }

  @Test
  public void testUpdate() {
    val user = new TbUserEntity();
    user.setAge(20);
    user.setPassword("66666666");
    val updateWrapper = Wrappers.<TbUserEntity>lambdaUpdate();
    updateWrapper.eq(TbUserEntity::getUserName, "zhangsan");
    user.update(updateWrapper);
    log.info(user.json());
  }

  @Test
  public void testUpdateById() {
    val user = new TbUserEntity();
    user.setId(1L);
    user.setAge(19);
    user.updateById();
    log.info(user.json());
  }
}
