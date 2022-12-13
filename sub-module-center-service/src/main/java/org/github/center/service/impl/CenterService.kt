package org.github.center.service.impl

import cn.dev33.satoken.stp.StpUtil.getTokenValue
import cn.dev33.satoken.stp.StpUtil.login
import cn.hutool.crypto.SecureUtil.generateKey
import cn.hutool.crypto.symmetric.SymmetricAlgorithm.AES
import cn.hutool.crypto.symmetric.SymmetricCrypto
import org.github.center.bo.LoginBo
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
class CenterService : ICenterService {
    @Resource
    private lateinit var sysUserMbpService: ISysUserMbpService

    override fun register(bo: LoginBo): JSONReturn {
        val symmetricAlgorithm = AES
        val key = generateKey(symmetricAlgorithm.value).encoded!!
        val aes = SymmetricCrypto(symmetricAlgorithm, key)
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
        val user = sysUserMbpService.ktQuery().eq(SysUserMbpPo::userName, bo.username).one() ?: throw ClientException("用户名或密码错误")
        val symmetricAlgorithm = AES
        val crypto = SymmetricCrypto(symmetricAlgorithm, user.secretKey!!.encodeToByteArray())
        val password = crypto.encryptHex(bo.password)!!
        if (password != user.userPwd) {
            throw ClientException("用户名或密码错误")
        }
        login(user.userName)
        val token = getTokenValue()!!
        return JSONDataReturn.of(token)
    }

    override fun refresh(): JSONDataReturn<String> {
        TODO("Not yet implemented")
    }
}
