package org.github.center.service

import com.alicp.jetcache.anno.Cached
import org.github.center.bo.LoginBo
import org.github.center.bo.RegisterBo
import org.github.spring.restful.json.JSONDataReturn
import org.github.spring.restful.json.JSONReturn
import javax.validation.Valid

interface ICenterService {
  fun register(bo: RegisterBo): JSONReturn

  @Cached(name = "ICenterService.login", expire = 30 * 60)
  fun login(@Valid bo: LoginBo): JSONReturn

  fun token(bo: LoginBo): JSONDataReturn<String>
}
