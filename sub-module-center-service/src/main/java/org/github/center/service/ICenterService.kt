package org.github.center.service

import org.github.center.bo.LoginBo
import org.github.center.bo.RegisterBo
import org.github.core.spring.restful.json.JSONDataReturn
import org.github.core.spring.restful.json.JSONReturn
import javax.validation.Valid

interface ICenterService {
  fun register(bo: RegisterBo): JSONReturn

  fun token(@Valid bo: LoginBo): JSONDataReturn<String>
}
