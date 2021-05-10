package org.github.web.system.impl;

import lombok.*;
import org.github.base.entity.SysUserEntity;
import org.github.base.service.ISysUserService;
import org.github.web.model.shiro.UserDTO;
import org.github.web.system.IShiroService;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static org.github.web.enums.EnableEnum.*;
import static org.springframework.beans.BeanUtils.*;

@Service
public class ShiroServiceImpl implements IShiroService {
  @Autowired
  private ISysUserService sysUserService;

  @Override
  public @NonNull UserDTO queryUser(@NonNull String username) {
    val query = sysUserService.lambdaQuery();
    query.eq(SysUserEntity::getUsername, username);
    val entity = query.one();
    if (entity == null) throw new AuthenticationException("用户未注册");
    if (disabled.getCode().equals(entity.getStatus())) throw new AuthenticationException("该用户已禁用");
    val user = new UserDTO();
    copyProperties(entity, user);
    return user;
  }
}
