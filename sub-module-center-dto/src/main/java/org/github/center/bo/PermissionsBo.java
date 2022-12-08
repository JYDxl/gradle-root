package org.github.center.bo;

import lombok.*;
import org.github.core.base.IBo;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PermissionsBo implements IBo {
  private Object loginId;

  private String loginType;
}
