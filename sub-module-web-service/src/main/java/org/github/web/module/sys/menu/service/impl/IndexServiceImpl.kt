package org.github.web.module.sys.menu.service.impl

import cn.dev33.satoken.stp.StpUtil.login
import cn.hutool.crypto.SecureUtil.generateKey
import cn.hutool.crypto.symmetric.SymmetricAlgorithm.AES
import cn.hutool.crypto.symmetric.SymmetricCrypto
import org.github.exception.ClientException
import org.github.mysql.sccore.base.entity.SysUserEntity
import org.github.mysql.sccore.base.service.ISysUserService
import org.github.spring.restful.json.JSONReturn
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
    val algorithm = AES.value!!
    val key = generateKey(algorithm).encoded!!
    val aes = SymmetricCrypto(AES, key)
    val password = aes.encryptHex(bo.password)!!

    val entity = SysUserEntity().apply {
      this.userName = bo.username
      this.userPwd = password
      this.algorithm = algorithm
      this.secretKey = key
    }

    sysUserService.save(entity)
    return JSONReturn.ok()
  }

  override fun login(bo: LoginBo): JSONReturn {
    val user = sysUserService.ktQuery().eq(SysUserEntity::userName, bo.username).one() ?: throw ClientException("用户名或密码错误")
    val crypto = SymmetricCrypto(AES, user.secretKey)
    val password = crypto.encryptHex(bo.password)!!
    if (password != user.userPwd) {
      throw ClientException("用户名或密码错误")
    }
    login(user.userName)
    return JSONReturn.ok()
  }
}
