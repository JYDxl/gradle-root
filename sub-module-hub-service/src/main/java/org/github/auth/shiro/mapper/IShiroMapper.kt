package org.github.auth.shiro.mapper;

import java.util.List;
import javax.annotation.Nullable;
import lombok.*;
import org.github.auth.shiro.model.UserDTO;
import org.github.mybatis.MyBatisMapper;
import org.github.shiro.AuthorInfo;

@MyBatisMapper
public interface IShiroMapper {
  @NonNull List<AuthorInfo> queryAuthorInfo(Long userId);

  @Nullable UserDTO queryUserInfo(String username);
}
