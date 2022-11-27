package org.github.service;

import java.util.List;
import com.alicp.jetcache.anno.Cached;
import cn.dev33.satoken.stp.StpInterface;
import static com.alicp.jetcache.anno.CacheType.*;
import static org.github.ConstKt.*;

public interface SaInterface extends StpInterface {
  @Cached(name = CACHE_NAME_PERMISSION, expire = CACHE_TIMEOUT, cacheType = BOTH)
  @Override
  List<String> getPermissionList(Object loginId, String loginType);

  @Cached(name = CACHE_NAME_ROLE, expire = CACHE_TIMEOUT, cacheType = BOTH)
  @Override
  List<String> getRoleList(Object loginId, String loginType);
}
