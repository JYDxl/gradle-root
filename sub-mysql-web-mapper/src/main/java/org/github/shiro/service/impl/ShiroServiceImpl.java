package org.github.shiro.service.impl;

import lombok.NonNull;
import lombok.val;
import org.apache.shiro.authc.AuthenticationException;
import org.github.base.entity.SysUserEntity;
import org.github.base.service.ISysUserService;
import org.github.shiro.AuthorInfo;
import org.github.shiro.IShiroService;
import org.github.shiro.mapper.IShiroMapper;
import org.github.shiro.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.github.base.enums.Enable.disabled;
import static org.springframework.beans.BeanUtils.copyProperties;

@Service
public class ShiroServiceImpl implements IShiroService {
  @Autowired
  private ISysUserService sysUserService;
  @Autowired
  private IShiroMapper    shiroMapper;

  @Override
  public @NonNull List<AuthorInfo> queryAuthorInfo(@NonNull String userId){
    return shiroMapper.queryAuthorInfo(Long.valueOf(userId));
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
