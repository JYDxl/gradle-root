package org.github.common.service.impl

import org.github.common.service.ISystemService
import org.github.core.spring.restful.json.JSONDataReturn
import org.github.core.spring.restful.json.JSONReturn
import org.springframework.stereotype.Service

@Service
class SystemServiceImpl: ISystemService {
  override fun login(): JSONDataReturn<String?> {
    TODO("Not yet implemented")
  }

  override fun jsessionid(): JSONDataReturn<String?> {
    TODO("Not yet implemented")
  }

  override fun jwt(): JSONDataReturn<String> {
    TODO("Not yet implemented")
  }

  override fun logout(): JSONReturn {
    TODO("Not yet implemented")
  }
}
