package org.github.web.mapper;

import java.util.List;
import lombok.*;
import org.github.base.model.dto.UserInfoDTO;
import org.github.mybatis.MyBatisMapper;
import org.apache.ibatis.annotations.Param;

@MyBatisMapper
public interface ICustomUserMapper {
  @NonNull List<UserInfoDTO> queryUserInfo(@NonNull @Param("username") String username);
}
