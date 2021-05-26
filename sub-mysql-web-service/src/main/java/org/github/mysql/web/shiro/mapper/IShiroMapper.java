package org.github.mysql.web.shiro.mapper;

import lombok.NonNull;
import org.apache.ibatis.annotations.Param;
import org.github.mybatis.MyBatisMapper;
import org.github.mysql.web.shiro.model.UserDTO;
import org.github.shiro.AuthorInfo;

import javax.annotation.Nullable;
import java.util.List;

@MyBatisMapper
public interface IShiroMapper {
  @NonNull List<AuthorInfo> queryAuthorInfo(@NonNull @Param("userId") Long userId);

  @Nullable UserDTO queryUserInfo(@NonNull @Param("username") String username);
}