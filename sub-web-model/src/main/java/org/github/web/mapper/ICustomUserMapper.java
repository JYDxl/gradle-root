package org.github.web.mapper;

import lombok.*;
import org.github.mybatis.MyBatisMapper;
import org.github.web.model.dto.UserInfoDTO;
import org.apache.ibatis.annotations.Param;
import javax.annotation.Nullable;

@MyBatisMapper
public interface ICustomUserMapper {
  @Nullable UserInfoDTO queryUserInfo(@NonNull @Param("username") String username);
}
