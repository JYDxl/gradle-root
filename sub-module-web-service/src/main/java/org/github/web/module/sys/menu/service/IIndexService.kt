package org.github.web.module.sys.menu.service

import org.github.spring.restful.json.JSONReturn
import org.github.web.module.index.LoginBo
import org.github.web.module.index.RegisterBo

interface IIndexService {
  fun register(bo: RegisterBo): JSONReturn

  fun login(bo: LoginBo): JSONReturn
}
