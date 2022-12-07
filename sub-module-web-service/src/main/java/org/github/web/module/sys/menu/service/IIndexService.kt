package org.github.web.module.sys.menu.service

import org.github.core.spring.restful.json.JSONDataReturn
import org.github.core.spring.restful.json.JSONReturn
import org.github.web.module.index.DemoVo
import org.github.web.module.index.LoginBo
import org.github.web.module.index.RegisterBo
import org.github.web.module.index.TokenVo

interface IIndexService {
  fun register(bo: RegisterBo): JSONReturn

  fun login(bo: LoginBo): JSONReturn
  fun token(bo: LoginBo): JSONDataReturn<TokenVo>
  fun demo(): JSONDataReturn<DemoVo>
}
