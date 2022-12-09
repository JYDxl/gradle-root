package org.github.center.service.impl

import cn.dev33.satoken.stp.StpUtil.getTokenValue
import cn.dev33.satoken.stp.StpUtil.login
import cn.hutool.crypto.SecureUtil.generateKey
import cn.hutool.crypto.symmetric.SymmetricAlgorithm
import cn.hutool.crypto.symmetric.SymmetricCrypto
import org.github.center.bo.LoginBo
import org.github.center.bo.RegisterBo
import org.github.center.service.ICenterService
import org.github.core.exception.ClientException
import org.github.core.spring.restful.json.JSONDataReturn
import org.github.core.spring.restful.json.JSONReturn
import org.github.mysql.center.entity.SysUserMbpPo
import org.github.mysql.center.service.ISysUserMbpService
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated
import javax.annotation.Resource

@Validated
@Service
class CenterService: ICenterService {
  @Resource
  private lateinit var sysUserMbpService: ISysUserMbpService

  override fun register(bo: RegisterBo): JSONReturn {
    val algorithm = bo.algorithm!!
    val symmetricAlgorithm = parseAlgorithm(algorithm)
    val key = generateKey(algorithm).encoded!!
    val aes = SymmetricCrypto(symmetricAlgorithm, key)
    val password = aes.encryptHex(bo.password)!!

    val entity = SysUserMbpPo().apply {
      userName = bo.username
      userPwd = password
      secretAlgorithm = algorithm
      secretKey = key
    }

    sysUserMbpService.save(entity)
    return JSONReturn.ok()
  }

  override fun token(bo: LoginBo): JSONDataReturn<String> {
    val user = sysUserMbpService.ktQuery().eq(SysUserMbpPo::userName, bo.username).one() ?: throw ClientException("用户名或密码错误")
    val symmetricAlgorithm = parseAlgorithm(user.secretAlgorithm!!)
    val crypto = SymmetricCrypto(symmetricAlgorithm, user.secretKey)
    val password = crypto.encryptHex(bo.password)!!
    if (password != user.userPwd) {
      throw ClientException("用户名或密码错误")
    }
    login(user.userName)
    val token = getTokenValue()!!
    return JSONDataReturn.of(token)
  }

  private fun parseAlgorithm(algorithm: String): SymmetricAlgorithm {
    try {
      return SymmetricAlgorithm.valueOf(algorithm)
    } catch (ignore: Exception) {
      throw ClientException("不受支持的加密方式：$algorithm")
    }
  }
}
