package org.github.web.module.sys.menu.dto;

import javax.annotation.Nullable;
import lombok.*;
import org.github.mysql.mydb.base.entity.SysMenuEntity;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class QueryMenuListVO extends SysMenuEntity {
  private @Nullable String parentName;
}
