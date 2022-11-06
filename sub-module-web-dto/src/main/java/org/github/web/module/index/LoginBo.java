package org.github.web.module.index;

import lombok.*;
import org.github.base.IParam;

@Data
public class LoginBo implements IParam {
  private String username;

  private String password;
}
