package org.github.web.module.index;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DemoVo {
  /** 用户名 */
  private String username;

  /** 密码 */
  private String password;
}
