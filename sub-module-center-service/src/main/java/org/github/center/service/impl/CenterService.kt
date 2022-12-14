package org.github.center.service.impl

import cn.dev33.satoken.stp.StpUtil.getRoleList
import cn.dev33.satoken.stp.StpUtil.getTokenInfo
import cn.dev33.satoken.stp.StpUtil.getTokenValue
import cn.dev33.satoken.stp.StpUtil.login
import cn.hutool.core.util.HexUtil.decodeHex
import cn.hutool.core.util.HexUtil.encodeHexStr
import cn.hutool.crypto.SecureUtil.generateKey
import cn.hutool.crypto.symmetric.SymmetricAlgorithm.AES
import cn.hutool.crypto.symmetric.SymmetricCrypto
import javax.annotation.Resource
import org.github.center.bo.LoginBo
import org.github.center.mapper.SaTokenMapper
import org.github.center.service.ICenterService
import org.github.core.DEVICE_TYPE_PC
import org.github.core.exception.ClientException
import org.github.core.minio.MinioUploadBo
import org.github.core.minio.MinioWrapper
import org.github.core.spring.restful.json.JSONArrayReturn
import org.github.core.spring.restful.json.JSONDataReturn
import org.github.core.spring.restful.json.JSONReturn
import org.github.mysql.center.entity.SysUserMbpPo
import org.github.mysql.center.service.ISysUserMbpService
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated
import org.springframework.web.multipart.MultipartFile

@Validated
@Service
class CenterService : ICenterService {
    @Resource
    private lateinit var sysUserMbpService: ISysUserMbpService

    @Resource
    private lateinit var minioWrapper: MinioWrapper

    @Resource
    private lateinit var saTokenMapper: SaTokenMapper

    override fun register(bo: LoginBo): JSONReturn {
        val key = generateKey(AES.value).encoded!!
        val aes = SymmetricCrypto(AES, key)
        val password = aes.encryptHex(bo.password)!!

        val entity = SysUserMbpPo().apply {
            userName = bo.username
            niceName = userName
            secretKey = encodeHexStr(key)
            userPwd = password
        }

        sysUserMbpService.save(entity)
        return JSONReturn.ok()
    }

    override fun login(bo: LoginBo): JSONDataReturn<String> {
        val msg = "用户名或密码错误"
        val user = sysUserMbpService.ktQuery().eq(SysUserMbpPo::userName, bo.username).one() ?: throw ClientException(msg)
        val crypto = SymmetricCrypto(AES, decodeHex(user.secretKey))
        val password = crypto.encryptHex(bo.password)!!
        if (password != user.userPwd) throw ClientException(msg)

        login(user.userName, DEVICE_TYPE_PC)
        val token = getTokenValue()!!
        return JSONDataReturn.of(token)
    }

    override fun refresh(): JSONDataReturn<String> {
        val tokenInfo = getTokenInfo()!!
        login(tokenInfo.loginId, tokenInfo.loginDevice)
        val token = getTokenValue()!!
        return JSONDataReturn.of(token)
    }

    override fun upload(file: MultipartFile, repo: String): JSONDataReturn<String> {
        val bo = MinioUploadBo().apply {
            bucket = repo
            name = file.originalFilename
            input = file.inputStream
            objSize = file.size
        }

        minioWrapper.upload(bo)
        val url = minioWrapper.getUrl(bo)!!
        return JSONDataReturn.of(url)
    }

    override fun menuList(): JSONArrayReturn<String> {
        val roleList: MutableList<String> = getRoleList()
        if (roleList.isEmpty()) return JSONArrayReturn.of()
        val menuList = saTokenMapper.getMenuList(roleList)
        return JSONArrayReturn.of(menuList)
    }
}
