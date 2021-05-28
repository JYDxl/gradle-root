package org.github.web.module.sys.menu.model.vo;

import javax.annotation.Nullable;
import lombok.*;
import org.github.mysql.web.base.entity.SysMenuMbpEntity;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class QueryMenuListVO extends SysMenuMbpEntity {
  private @Nullable String parentName;
}
