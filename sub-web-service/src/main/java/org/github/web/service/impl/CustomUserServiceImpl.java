package org.github.web.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import lombok.*;
import org.github.base.entity.PermissionEntity;
import org.github.base.entity.RoleEntity;
import org.github.base.entity.RolePermissionEntity;
import org.github.base.entity.UserEntity;
import org.github.base.entity.UserRoleEntity;
import org.github.base.model.dto.UserInfoDTO;
import org.github.base.service.IPermissionService;
import org.github.base.service.IRolePermissionService;
import org.github.base.service.IRoleService;
import org.github.base.service.IUserRoleService;
import org.github.base.service.IUserService;
import org.github.web.mapper.ICustomUserMapper;
import org.github.web.service.ICustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static com.baomidou.mybatisplus.core.toolkit.Wrappers.*;
import static com.google.common.collect.ImmutableSet.*;
import static com.google.common.collect.Lists.*;

@Service
public class CustomUserServiceImpl implements ICustomUserService {
  @Autowired
  private IUserService           userService;
  @Autowired
  private IUserRoleService       userRoleService;
  @Autowired
  private IRoleService           roleService;
  @Autowired
  private IRolePermissionService rolePermissionService;
  @Autowired
  private IPermissionService     permissionService;
  @Autowired
  private ICustomUserMapper      userMapper;

  @Transactional
  @Override
  public @NonNull Set<String> queryPermissions(@NonNull Integer userId) {
    val roleIdList = queryRoleIds(userId);
    if (roleIdList.isEmpty()) return of();

    val rolePermissionQuery = rolePermissionService.lambdaQuery();
    rolePermissionQuery.in(RolePermissionEntity::getRoleId, roleIdList);
    rolePermissionQuery.select(RolePermissionEntity::getPermissionId);
    val rolePermissionList = rolePermissionQuery.list();
    val permissionIdList   = rolePermissionList.stream().map(RolePermissionEntity::getPermissionId).filter(Objects::nonNull).collect(toImmutableSet());
    if (permissionIdList.isEmpty()) return of();

    val permissionQuery = permissionService.lambdaQuery();
    permissionQuery.in(PermissionEntity::getId, permissionIdList);
    permissionQuery.select(PermissionEntity::getName);
    val permissionList = permissionQuery.list();
    return permissionList.stream().map(PermissionEntity::getName).filter(Objects::nonNull).collect(toImmutableSet());
  }

  @Transactional
  @Override
  public @NonNull Set<String> queryRoles(@NonNull Integer userId) {
    val roleIdList = queryRoleIds(userId);
    if (roleIdList.isEmpty()) return of();

    val roleQuery = roleService.lambdaQuery();
    roleQuery.in(RoleEntity::getId, roleIdList);
    roleQuery.select(RoleEntity::getName);
    val roleList = roleQuery.list();
    return roleList.stream().map(RoleEntity::getName).filter(Objects::nonNull).collect(toImmutableSet());
  }

  @Override
  public UserEntity queryUser(@NonNull String username) {
    val query = lambdaQuery(UserEntity.class);
    query.eq(UserEntity::getUsername, username);
    return userService.getOne(query, true);
  }

  @Override
  public @NonNull List<UserInfoDTO> queryUserInfo(@NonNull String username) {
    return userMapper.queryUserInfo(username);
  }

  private @NonNull List<Integer> queryRoleIds(@NonNull Integer userId) {
    val userRoleQuery = userRoleService.lambdaQuery();
    userRoleQuery.eq(UserRoleEntity::getUserId, userId);
    userRoleQuery.select(UserRoleEntity::getRoleId);
    val userRoleList = userRoleQuery.list();
    return transform(userRoleList, UserRoleEntity::getRoleId);
  }
}
