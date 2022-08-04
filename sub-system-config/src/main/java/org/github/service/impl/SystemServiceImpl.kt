package org.github.service.impl

import org.github.service.ISystemService
import org.github.spring.restful.json.JSONDataReturn
import org.github.spring.restful.json.JSONReturn
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
