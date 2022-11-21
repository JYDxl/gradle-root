package org.github.sso.service

import com.alicp.jetcache.anno.Cached
import org.github.spring.restful.json.JSONDataReturn
import org.github.spring.restful.json.JSONReturn
import org.github.sso.bo.LoginBo
import org.github.sso.bo.RegisterBo
import javax.validation.Valid

interface ISsoService {
  fun register(bo: RegisterBo): JSONReturn

  @Cached(name = "ISsoService.login", expire = 30 * 60)
  fun login(@Valid bo: LoginBo): JSONReturn
  fun token(bo: LoginBo): JSONDataReturn<String>
}
