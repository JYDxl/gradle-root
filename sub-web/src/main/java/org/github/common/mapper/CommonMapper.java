package org.github.common.mapper;

import java.time.LocalDateTime;
import javax.annotation.Nonnull;
import org.github.base.entity.TipLoginLogEntity;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

@Repository
public interface CommonMapper {
  @Select("select now()")
  @Nonnull
  LocalDateTime now();

  @Select("select * from tip_login_log")
  @Nonnull
  Page<TipLoginLogEntity> page(Page page);
}
