package org.github.common.service;

import cn.dev33.satoken.stp.StpInterface;
import com.alicp.jetcache.anno.Cached;
import java.util.List;
import static com.alicp.jetcache.anno.CacheType.BOTH;
import static org.github.core.ConstKt.CACHE_NAME_ROLE;
import static org.github.core.ConstKt.CACHE_TIMEOUT;

public interface ISaTokenInterface extends StpInterface {
  @Override
  List<String> getPermissionList(Object loginId, String loginType);

  @Cached(name = CACHE_NAME_ROLE, expire = CACHE_TIMEOUT, cacheType = BOTH)
  @Override
  List<String> getRoleList(Object loginId, String loginType);
}
