package org.github.web.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.github.base.entity.UsersEntity;
import org.github.base.model.UserLoginReqModel;
import org.github.base.model.UserLoginResModel;
import org.github.base.model.UserRegisterModel;
import org.github.base.service.IUsersService;
import org.github.ops.spring.SpringOpsKt;
import org.github.spring.restful.Returnable;
import org.github.spring.restful.json.JSONBasic;
import org.github.spring.restful.json.JSONData;
import org.github.web.common.CookieUtils;
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

@Service
@Slf4j
public class UserServiceImpl implements IUserService {
  @Autowired
  private IUsersService usersService;

  @Transactional
  @Override
  public Returnable createUser(UserRegisterModel user) {
    user.setNickname(user.getUsername());
    user.setPassword(sha256().hashString(user.getPassword(), UTF_8).toString());
    user.setFace("");
    user.setCreatedTime(now());
    user.setUpdatedTime(now());
    usersService.save(user);
    UsersEntity entity = new UsersEntity();
    BeanUtils.copyProperties(user, entity);
    return new JSONData<>(entity);
  }

  @Override
  public Returnable login(UserLoginReqModel model) {
    model.setPassword(sha256().hashString(model.getPassword(), UTF_8).toString());
    LambdaQueryWrapper<UsersEntity> query = Wrappers.lambdaQuery();
    query
      .eq(UsersEntity::getUsername, model.getUsername())
      .eq(UsersEntity::getPassword, model.getPassword());
    UsersEntity one = usersService.getOne(query, true);
    if(one == null) {
      return JSONBasic.error().withResMsg("用户名或密码错误");
    }
    UserLoginResModel res = new UserLoginResModel();
    BeanUtils.copyProperties(one, res);
    CookieUtils.setCookie(SpringOpsKt.getReq(), SpringOpsKt.getResp(), "user", SpringOpsKt.json(res, null), true);
    return new JSONData<>(res);
  }

  @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
  @Override
  public Returnable queryUserNameIsExist(String userName) {
    LambdaQueryWrapper<UsersEntity> query = Wrappers.lambdaQuery();
    int                             count = usersService.count(query.eq(UsersEntity::getUsername, userName));
    return new JSONData<>(count > 0);
  }
}
