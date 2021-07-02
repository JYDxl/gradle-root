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
 * 自媒体用户设备信息表
 *
 * @author JYD_XL
 */
@TableName("wm_user_equipment")
@ApiModel(value = "WmUserEquipmentEntity对象", description = "自媒体用户设备信息表")
open class WmUserEquipmentEntity : Entity() {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Int? = null

    /** 用户ID */
    @ApiModelProperty(value = "用户ID")
    @TableField("user_id")
    open var userId: Int? = null

    /** 0PC	            1ANDROID	            2IOS	            3PAD	            9 其他 */
    @ApiModelProperty(value = "0PC	            1ANDROID	            2IOS	            3PAD	            9 其他")
    open var type: Int? = null

    /** 设备版本 */
    @ApiModelProperty(value = "设备版本")
    open var version: String? = null

    /** 设备系统 */
    @ApiModelProperty(value = "设备系统")
    open var sys: String? = null

    /** 设备唯一号，MD5加密 */
    @ApiModelProperty(value = "设备唯一号，MD5加密")
    open var no: String? = null

    /** 登录时间 */
    @ApiModelProperty(value = "登录时间")
    @TableField("created_time")
    open var createdTime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val USER_ID : String = "user_id"

        const val TYPE : String = "type"

        const val VERSION : String = "version"

        const val SYS : String = "sys"

        const val NO : String = "no"

        const val CREATED_TIME : String = "created_time"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "WmUserEquipmentEntity{" +
        "id=" + id +
        ", userId=" + userId +
        ", type=" + type +
        ", version=" + version +
        ", sys=" + sys +
        ", no=" + no +
        ", createdTime=" + createdTime +
        "}"
    }

}
