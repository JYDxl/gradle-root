package org.github.web.mapper;

import lombok.*;
import org.github.mybatis.MyBatisMapper;
import org.github.web.model.dto.UserInfoDTO;
import org.apache.ibatis.annotations.Param;

@MyBatisMapper
public interface ICustomUserMapper {
  UserInfoDTO queryUserInfo(@NonNull @Param("username") String username);
}
