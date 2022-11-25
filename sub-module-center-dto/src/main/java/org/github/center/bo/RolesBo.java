package org.github.center.bo;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RolesBo extends PermissionsBo {
  private Object loginId;

  private String loginType;
}
