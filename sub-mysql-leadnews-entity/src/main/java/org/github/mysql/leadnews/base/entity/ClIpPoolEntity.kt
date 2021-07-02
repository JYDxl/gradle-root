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
 * 
 *
 * @author JYD_XL
 */
@TableName("cl_ip_pool")
@ApiModel(value = "ClIpPoolEntity对象", description = "")
open class ClIpPoolEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    open var id: Int? = null

    /** 供应商 */
    @ApiModelProperty(value = "供应商")
    open var supplier: String? = null

    /** ip地址 */
    @ApiModelProperty(value = "ip地址")
    open var ip: String? = null

    /** 端口号 */
    @ApiModelProperty(value = "端口号")
    open var port: Int? = null

    /** 用户名 */
    @ApiModelProperty(value = "用户名")
    open var username: String? = null

    /** 密码 */
    @ApiModelProperty(value = "密码")
    open var password: String? = null

    /** 状态码 */
    @ApiModelProperty(value = "状态码")
    open var code: Int? = null

    /** 访问耗时 */
    @ApiModelProperty(value = "访问耗时")
    open var duration: Int? = null

    /** 错误信息 */
    @ApiModelProperty(value = "错误信息")
    open var error: String? = null

    /** 是否启用 */
    @ApiModelProperty(value = "是否启用")
    @TableField("is_enable")
    open var isEnable: Boolean? = null

    /** 可用范围 */
    @ApiModelProperty(value = "可用范围")
    open var ranges: String? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("created_time")
    open var createdTime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val SUPPLIER : String = "supplier"

        const val IP : String = "ip"

        const val PORT : String = "port"

        const val USERNAME : String = "username"

        const val PASSWORD : String = "password"

        const val CODE : String = "code"

        const val DURATION : String = "duration"

        const val ERROR : String = "error"

        const val IS_ENABLE : String = "is_enable"

        const val RANGES : String = "ranges"

        const val CREATED_TIME : String = "created_time"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "ClIpPoolEntity{" +
        "id=" + id +
        ", supplier=" + supplier +
        ", ip=" + ip +
        ", port=" + port +
        ", username=" + username +
        ", password=" + password +
        ", code=" + code +
        ", duration=" + duration +
        ", error=" + error +
        ", isEnable=" + isEnable +
        ", ranges=" + ranges +
        ", createdTime=" + createdTime +
        "}"
    }

}
