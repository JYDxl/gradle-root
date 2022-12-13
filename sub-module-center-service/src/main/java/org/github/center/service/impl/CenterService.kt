package org.github.center.service.impl

import cn.dev33.satoken.stp.StpUtil.getTokenValue
import cn.dev33.satoken.stp.StpUtil.login
import cn.hutool.crypto.SecureUtil.generateKey
import cn.hutool.crypto.symmetric.SymmetricAlgorithm.AES
import cn.hutool.crypto.symmetric.SymmetricCrypto
import javax.annotation.Resource
import org.github.center.bo.LoginBo
import org.github.center.service.ICenterService
import org.github.core.exception.ClientException
import org.github.core.spring.restful.json.JSONDataReturn
import org.github.core.spring.restful.json.JSONReturn
import org.github.mysql.center.entity.SysUserMbpPo
import org.github.mysql.center.service.ISysUserMbpService
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated

@Validated
@Service
class CenterService: ICenterService {
  @Resource
  private lateinit var sysUserMbpService: ISysUserMbpService

  override fun register(bo: LoginBo): JSONReturn {
    val key = generateKey(AES.value).encoded!!
    val aes = SymmetricCrypto(AES, key)
    val password = aes.encryptHex(bo.password)!!

    val entity = SysUserMbpPo().apply {
      userName = bo.username
      userPwd = password
      secretKey = key.decodeToString()
    }

    sysUserMbpService.save(entity)
    return JSONReturn.ok()
  }

  override fun login(bo: LoginBo): JSONDataReturn<String> {
    val msg = "用户名或密码错误"
    val user = sysUserMbpService.ktQuery().eq(SysUserMbpPo::userName, bo.username).one() ?: throw ClientException(msg)
    val crypto = SymmetricCrypto(AES, user.secretKey!!.encodeToByteArray())
    val password = crypto.encryptHex(bo.password)!!
    if (password != user.userPwd) throw ClientException(msg)

    login(user.userName)
    val token = getTokenValue()!!
    return JSONDataReturn.of(token)
  }

  override fun refresh(): JSONDataReturn<String> {
    TODO("Not yet implemented")
  }
}
