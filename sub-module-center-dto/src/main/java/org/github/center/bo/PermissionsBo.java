package org.github.center.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.github.core.base.IBo;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PermissionsBo implements IBo {
  private Object loginId;

  private String loginType;
}
