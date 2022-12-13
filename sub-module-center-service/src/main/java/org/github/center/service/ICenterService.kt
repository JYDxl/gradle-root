package org.github.center.service

import javax.validation.Valid
import org.github.center.bo.LoginBo
import org.github.core.spring.restful.json.JSONDataReturn
import org.github.core.spring.restful.json.JSONReturn

interface ICenterService {
  fun register(@Valid bo: LoginBo): JSONReturn

  fun login(@Valid bo: LoginBo): JSONDataReturn<String>

  fun refresh(): JSONDataReturn<String>
}
