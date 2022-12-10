package org.github.web.module.index;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TokenVo {
  /** token名称 */
  private String token;

  /** token值 */
  private String value;
}
