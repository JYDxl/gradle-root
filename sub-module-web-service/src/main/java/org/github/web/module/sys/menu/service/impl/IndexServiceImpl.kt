package org.github.web.module.sys.menu.service.impl

import cn.dev33.satoken.stp.StpUtil.getTokenValue
import cn.dev33.satoken.stp.StpUtil.login
import cn.hutool.crypto.SecureUtil.generateKey
import cn.hutool.crypto.symmetric.SymmetricAlgorithm
import cn.hutool.crypto.symmetric.SymmetricCrypto
import org.github.exception.ExternalException
import org.github.mysql.sccore.base.entity.SysUserEntity
import org.github.mysql.sccore.base.service.ISysUserService
import org.github.spring.restful.json.JSONDataReturn
import org.github.spring.restful.json.JSONReturn
import org.github.web.module.index.DemoVo
import org.github.web.module.index.LoginBo
import org.github.web.module.index.RegisterBo
import org.github.web.module.sys.menu.service.IIndexService
import org.springframework.stereotype.Service
import javax.annotation.Resource

@Service
class IndexServiceImpl: IIndexService {
  @Resource
  private lateinit var sysUserService: ISysUserService

  override fun register(bo: RegisterBo): JSONReturn {
    val algorithm = bo.algorithm!!
    val symmetricAlgorithm = parseAlgorithm(algorithm)
    val key = generateKey(algorithm).encoded!!
    val aes = SymmetricCrypto(symmetricAlgorithm, key)
    val password = aes.encryptHex(bo.password)!!

    val entity = SysUserEntity().apply {
      userName = bo.username
      userPwd = password
      secretAlgorithm = algorithm
      secretKey = key
    }

    sysUserService.save(entity)
    return JSONReturn.ok()
  }

  override fun login(bo: LoginBo): JSONReturn {
    val user = sysUserService.ktQuery().eq(SysUserEntity::userName, bo.username).one() ?: throw ExternalException("用户名或密码错误")
    val symmetricAlgorithm = parseAlgorithm(user.secretAlgorithm!!)
    val crypto = SymmetricCrypto(symmetricAlgorithm, user.secretKey)
    val password = crypto.encryptHex(bo.password)!!
    if (password != user.userPwd) {
      throw ExternalException("用户名或密码错误")
    }
    login(user.userName)
    return JSONReturn.ok()
  }

  override fun token(bo: LoginBo): JSONDataReturn<String> {
    login(bo)
    return JSONDataReturn.of(getTokenValue())
  }

  override fun demo(): JSONDataReturn<DemoVo> {
    return JSONDataReturn.of(DemoVo("demo", "demo"))
  }

  private fun parseAlgorithm(algorithm: String): SymmetricAlgorithm {
    try {
      return SymmetricAlgorithm.valueOf(algorithm)
    } catch (ignore: Exception) {
      throw ExternalException("不受支持的加密方式：$algorithm")
    }
  }
}
