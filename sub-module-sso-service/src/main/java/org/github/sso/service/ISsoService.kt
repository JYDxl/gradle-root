package org.github.sso.service

import org.github.spring.restful.json.JSONDataReturn
import org.github.spring.restful.json.JSONReturn
import org.github.sso.bo.LoginBo
import org.github.sso.bo.RegisterBo
import javax.validation.Valid

interface ISsoService {
  fun register(bo: RegisterBo): JSONReturn
  fun login(@Valid bo: LoginBo): JSONReturn
  fun token(bo: LoginBo): JSONDataReturn<String>
}
