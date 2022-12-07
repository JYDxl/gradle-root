package org.github.center.bo;

import lombok.*;
import org.github.core.base.IParam;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PermissionsBo implements IParam {
  private Object loginId;

  private String loginType;
}
