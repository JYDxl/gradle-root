package org.github.center.service

import org.github.center.bo.LoginBo
import org.github.core.spring.restful.json.JSONDataReturn
import org.github.core.spring.restful.json.JSONReturn
import javax.validation.Valid

interface ICenterService {
    fun register(@Valid bo: LoginBo): JSONReturn

    fun login(@Valid bo: LoginBo): JSONDataReturn<String>

    fun refresh(): JSONDataReturn<String>
}
