package org.github.web.system.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import lombok.NonNull;
import org.apache.ibatis.annotations.Param;
import org.github.mybatis.MyBatisMapper;
import org.github.web.model.shiro.AuthorInfo;

import java.util.List;

@MyBatisMapper
public interface IShiroMapper {
    @InterceptorIgnore(illegalSql = "true")
    @NonNull List<AuthorInfo> queryAuthorInfo(@NonNull @Param("userId") Long userId);
}
