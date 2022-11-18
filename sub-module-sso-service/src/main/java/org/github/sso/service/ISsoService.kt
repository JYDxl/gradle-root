package org.github.sso.service

import org.github.spring.restful.json.JSONDataReturn
import org.github.spring.restful.json.JSONReturn
import org.github.sso.bo.LoginBo
import org.github.sso.bo.RegisterBo

interface ISsoService {
  fun register(bo: RegisterBo): JSONReturn
  fun login(bo: LoginBo): JSONReturn
  fun token(bo: LoginBo): JSONDataReturn<String>
}
