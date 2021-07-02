package org.github.mysql.leadnews.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.time.LocalDateTime
import org.github.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * APP用户信息表
 *
 * @author JYD_XL
 */
@TableName("ap_user")
@ApiModel(value = "ApUserEntity对象", description = "APP用户信息表")
open class ApUserEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    open var id: Int? = null

    /** 密码、通信等加密盐 */
    @ApiModelProperty(value = "密码、通信等加密盐")
    open var salt: String? = null

    /** 用户名 */
    @ApiModelProperty(value = "用户名")
    open var name: String? = null

    /** 密码,md5加密 */
    @ApiModelProperty(value = "密码,md5加密")
    open var password: String? = null

    /** 手机号 */
    @ApiModelProperty(value = "手机号")
    open var phone: String? = null

    /** 头像 */
    @ApiModelProperty(value = "头像")
    open var image: String? = null

    /** 0 男	            1 女	            2 未知 */
    @ApiModelProperty(value = "0 男	            1 女	            2 未知")
    open var sex: Int? = null

    /** 0 未	            1 是 */
    @ApiModelProperty(value = "0 未	            1 是")
    @TableField("is_certification")
    open var isCertification: Int? = null

    /** 是否身份认证 */
    @ApiModelProperty(value = "是否身份认证")
    @TableField("is_identity_authentication")
    open var isIdentityAuthentication: Boolean? = null

    /** 0正常	            1锁定 */
    @ApiModelProperty(value = "0正常	            1锁定")
    open var status: Int? = null

    /** 0 普通用户	            1 自媒体人	            2 大V */
    @ApiModelProperty(value = "0 普通用户	            1 自媒体人	            2 大V")
    open var flag: Int? = null

    /** 注册时间 */
    @ApiModelProperty(value = "注册时间")
    @TableField("created_time")
    open var createdTime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val SALT : String = "salt"

        const val NAME : String = "name"

        const val PASSWORD : String = "password"

        const val PHONE : String = "phone"

        const val IMAGE : String = "image"

        const val SEX : String = "sex"

        const val IS_CERTIFICATION : String = "is_certification"

        const val IS_IDENTITY_AUTHENTICATION : String = "is_identity_authentication"

        const val STATUS : String = "status"

        const val FLAG : String = "flag"

        const val CREATED_TIME : String = "created_time"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "ApUserEntity{" +
        "id=" + id +
        ", salt=" + salt +
        ", name=" + name +
        ", password=" + password +
        ", phone=" + phone +
        ", image=" + image +
        ", sex=" + sex +
        ", isCertification=" + isCertification +
        ", isIdentityAuthentication=" + isIdentityAuthentication +
        ", status=" + status +
        ", flag=" + flag +
        ", createdTime=" + createdTime +
        "}"
    }

}
