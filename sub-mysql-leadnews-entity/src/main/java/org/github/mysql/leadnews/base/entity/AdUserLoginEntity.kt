package org.github.mysql.leadnews.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.math.BigDecimal
import java.time.LocalDateTime
import org.github.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 管理员登录行为信息表
 *
 * @author JYD_XL
 */
@TableName("ad_user_login")
@ApiModel(value = "AdUserLoginEntity对象", description = "管理员登录行为信息表")
open class AdUserLoginEntity : Entity() {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Int? = null

    /** 用户ID */
    @ApiModelProperty(value = "用户ID")
    @TableField("user_id")
    open var userId: Int? = null

    /** 登录设备ID */
    @ApiModelProperty(value = "登录设备ID")
    @TableField("equipment_id")
    open var equipmentId: Int? = null

    /** 登录IP */
    @ApiModelProperty(value = "登录IP")
    open var ip: String? = null

    /** 登录地址 */
    @ApiModelProperty(value = "登录地址")
    open var address: String? = null

    /** 经度 */
    @ApiModelProperty(value = "经度")
    open var longitude: BigDecimal? = null

    /** 纬度 */
    @ApiModelProperty(value = "纬度")
    open var latitude: BigDecimal? = null

    /** 登录时间 */
    @ApiModelProperty(value = "登录时间")
    @TableField("created_time")
    open var createdTime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val USER_ID : String = "user_id"

        const val EQUIPMENT_ID : String = "equipment_id"

        const val IP : String = "ip"

        const val ADDRESS : String = "address"

        const val LONGITUDE : String = "longitude"

        const val LATITUDE : String = "latitude"

        const val CREATED_TIME : String = "created_time"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "AdUserLoginEntity{" +
        "id=" + id +
        ", userId=" + userId +
        ", equipmentId=" + equipmentId +
        ", ip=" + ip +
        ", address=" + address +
        ", longitude=" + longitude +
        ", latitude=" + latitude +
        ", createdTime=" + createdTime +
        "}"
    }

}
