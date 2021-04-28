package org.github.web.service.impl;

import lombok.extern.slf4j.*;
import org.github.web.common.CookieUtils;
import org.github.base.entity.UsersEntity;
import org.github.web.model.UserLoginReqModel;
import org.github.web.model.UserRegisterReqModel;
import org.github.base.service.IUsersService;
import org.github.spring.restful.Returnable;
import org.github.spring.restful.json.JSONDataReturn;
import org.github.spring.restful.json.JSONReturn;
import org.github.web.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import static com.google.common.hash.Hashing.*;
import static java.nio.charset.StandardCharsets.*;
import static java.time.LocalDateTime.*;
import static org.github.ops.SpringsKt.*;

@Service
@Slf4j
public class UserServiceImplCustom implements IUserService {
  @Autowired
  private IUsersService usersService;

  @Transactional
  @Override
  public Returnable createUser(UserRegisterReqModel user) {
    user.setNickname(user.getUsername());
    user.setPassword(sha256().hashString(user.getPassword(), UTF_8).toString());
    user.setFace("");
    user.setCreatedTime(now());
    user.setUpdatedTime(now());
    usersService.save(user);
    UsersEntity entity = new UsersEntity();
    BeanUtils.copyProperties(user, entity);
    return new JSONDataReturn<>(entity);
  }

  @Override
  public Returnable login(UserLoginReqModel model) {
    model.setPassword(sha256().hashString(model.getPassword(), UTF_8).toString());
    LambdaQueryWrapper<UsersEntity> query = Wrappers.lambdaQuery();
    query
      .eq(UsersEntity::getUsername, model.getUsername())
      .eq(UsersEntity::getPassword, model.getPassword())
      .select(UsersEntity::getId, UsersEntity::getUsername, UsersEntity::getNickname, UsersEntity::getRealname, UsersEntity::getFace, UsersEntity::getSex);
    UsersEntity one = usersService.getOne(query, true);
    if (one == null) {
      return JSONReturn.error().withRetMsg("用户名或密码错误");
    }
    CookieUtils.setCookie(getReq(), getResp(), "user", json(one, null), true);
    return new JSONDataReturn<>(one);
  }

  @Override
  public Returnable logout(String userId) {
    CookieUtils.deleteCookie(getReq(), getResp(), "user");
    return new JSONReturn();
  }

  @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
  @Override
  public Returnable queryUserNameIsExist(String userName) {
    LambdaQueryWrapper<UsersEntity> query = Wrappers.lambdaQuery();
    int                             count = usersService.count(query.eq(UsersEntity::getUsername, userName));
    return new JSONDataReturn<>(count > 0);
  }
}
