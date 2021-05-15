package org.github.web.system.service.impl;

import lombok.NonNull;
import lombok.val;
import org.apache.shiro.authc.AuthenticationException;
import org.github.base.entity.SysUserEntity;
import org.github.base.service.ISysUserService;
import org.github.web.model.shiro.AuthorInfo;
import org.github.web.model.shiro.UserDTO;
import org.github.web.system.mapper.IShiroMapper;
import org.github.web.system.service.IShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.github.web.enums.Enable.disabled;
import static org.springframework.beans.BeanUtils.copyProperties;

@Service
public class ShiroServiceImpl implements IShiroService {
  @Autowired
  private ISysUserService sysUserService;
  @Autowired
  private IShiroMapper    shiroMapper;

  @Override
  public @NonNull List<AuthorInfo> queryAuthorInfo(@NonNull Long userId) {
    return shiroMapper.queryAuthorInfo(userId);
  }

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
