package org.github.shiro.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import lombok.NonNull;
import org.apache.ibatis.annotations.Param;
import org.github.mybatis.MyBatisMapper;
import org.github.shiro.AuthorInfo;

import java.util.List;

@MyBatisMapper
public interface IShiroMapper {
  @InterceptorIgnore(illegalSql = "true")
  @NonNull List<AuthorInfo> queryAuthorInfo(@NonNull @Param("userId") Long userId);
}
