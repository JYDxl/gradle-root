package org.github.center.service

import javax.validation.Valid
import org.github.center.bo.LoginBo
import org.github.center.vo.LoginVo
import org.github.core.spring.restful.json.JSONArray
import org.github.core.spring.restful.json.JSONBase
import org.github.core.spring.restful.json.JSONData
import org.springframework.web.multipart.MultipartFile

interface ICenterService {
  fun register(@Valid bo: LoginBo): JSONBase

  fun login(@Valid bo: LoginBo): JSONData<LoginVo>

  fun refresh(): JSONData<String>

  fun upload(file: MultipartFile, repo: String): JSONData<String>

  fun menuList(): JSONArray<String>
}
