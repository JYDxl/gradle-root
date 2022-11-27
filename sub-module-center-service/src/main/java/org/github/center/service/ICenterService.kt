package org.github.center.service

import com.alicp.jetcache.anno.CacheType.BOTH
import com.alicp.jetcache.anno.Cached
import org.github.CACHE_NAME_TOKEN
import org.github.CACHE_TIMEOUT
import org.github.center.bo.LoginBo
import org.github.center.bo.RegisterBo
import org.github.spring.restful.json.JSONDataReturn
import org.github.spring.restful.json.JSONReturn
import javax.validation.Valid

interface ICenterService {
  fun register(bo: RegisterBo): JSONReturn

  @Cached(name = CACHE_NAME_TOKEN, expire = CACHE_TIMEOUT, cacheType = BOTH)
  fun token(@Valid bo: LoginBo): JSONDataReturn<String>
}
