package org.github.center.service

import javax.validation.Valid
import org.github.center.bo.LoginBo
import org.github.center.vo.LoginVo
import org.github.core.spring.restful.json.JSONArrayReturn
import org.github.core.spring.restful.json.JSONDataReturn
import org.github.core.spring.restful.json.JSONReturn
import org.springframework.web.multipart.MultipartFile

interface ICenterService {
  fun register(@Valid bo: LoginBo): JSONReturn

  fun login(@Valid bo: LoginBo): JSONDataReturn<LoginVo>

  fun refresh(): JSONDataReturn<String>

  fun upload(file: MultipartFile, repo: String): JSONDataReturn<String>
  fun menuList(): JSONArrayReturn<String>
}
