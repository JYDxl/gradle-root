package org.github.common.service;

import java.util.List;
import com.alicp.jetcache.anno.Cached;
import cn.dev33.satoken.stp.StpInterface;
import static com.alicp.jetcache.anno.CacheType.*;

public interface ISaTokenInterface extends StpInterface {
  @Override
  List<String> getPermissionList(Object loginId, String loginType);

  @Cached(name = org.github.core.ConstKt.CACHE_NAME_ROLE, expire = org.github.core.ConstKt.CACHE_TIMEOUT, cacheType = BOTH)
  @Override
  List<String> getRoleList(Object loginId, String loginType);
}
