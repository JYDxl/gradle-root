package org.github.auth.shiro.service.impl;

import lombok.NonNull;
import lombok.val;
import org.apache.shiro.authc.AuthenticationException;
import org.github.auth.shiro.mapper.IShiroMapper;
import org.github.auth.shiro.model.UserDTO;
import org.github.shiro.AuthorInfo;
import org.github.service.IShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Long.valueOf;
import static org.github.mysql.web.base.enums.Deleted.deleted;
import static org.github.mysql.web.base.enums.Enable.disabled;

@Primary
@Service
public class AuthShiroServiceImpl implements IShiroService {
  @Autowired
  private IShiroMapper shiroMapper;

  @Override
  public @NonNull List<AuthorInfo> queryAuthorInfo(@NonNull String userId) {
    return shiroMapper.queryAuthorInfo(valueOf(userId));
  }

  @Override
  public @NonNull UserDTO queryUser(@NonNull String username) {
    val user = shiroMapper.queryUserInfo(username);
    if (user == null) throw new AuthenticationException("用户未注册");
    if (disabled.getCode().equals(user.getStatus())) throw new AuthenticationException("该用户已禁用");
    if (deleted.getCode().equals(user.getDeleted())) throw new AuthenticationException("该用户已注销");
    return user;
  }
}
