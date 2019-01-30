package org.github.common.mapper;

import java.time.LocalDateTime;
import javax.annotation.Nonnull;
import org.github.base.entity.TipLoginLogEntity;
import org.github.mybatis.MyBatisMapper;
import org.apache.ibatis.annotations.Select;
import com.baomidou.mybatisplus.core.metadata.IPage;

@MyBatisMapper
public interface CommonMapper {
  @Select("select now()")
  @Nonnull
  LocalDateTime now();

  @Nonnull
  IPage<TipLoginLogEntity> page(IPage page);
}
