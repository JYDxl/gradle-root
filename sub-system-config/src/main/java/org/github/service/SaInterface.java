package org.github.service;

import java.util.List;
import cn.dev33.satoken.stp.StpInterface;

public interface SaInterface extends StpInterface {
  @Override
  List<String> getPermissionList(Object loginId, String loginType);

  @Override
  List<String> getRoleList(Object loginId, String loginType);
}
