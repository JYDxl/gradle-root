package org.github.sso.bo;

import lombok.*;
import org.github.base.IParam;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PermissionsBo implements IParam {
  private Object loginId;

  private String loginType;
}