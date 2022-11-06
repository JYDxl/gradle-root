package org.github.web.module.sys.menu.service.impl

import org.github.spring.restful.json.JSONReturn
import org.github.web.module.index.LoginBo
import org.github.web.module.index.RegisterBo
import org.github.web.module.sys.menu.service.IIndexService
import org.springframework.stereotype.Service

@Service
class IndexServiceImpl: IIndexService {
  override fun register(bo: RegisterBo): JSONReturn {
    TODO("Not yet implemented")
  }

  override fun login(bo: LoginBo): JSONReturn {
    TODO("Not yet implemented")
  }
}
