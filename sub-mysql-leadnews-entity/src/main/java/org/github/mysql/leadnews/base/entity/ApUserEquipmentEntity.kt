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
 * APP用户设备信息表
 *
 * @author JYD_XL
 */
@TableName("ap_user_equipment")
@ApiModel(value = "ApUserEquipmentEntity对象", description = "APP用户设备信息表")
open class ApUserEquipmentEntity : Entity() {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Int? = null

    /** 用户ID */
    @ApiModelProperty(value = "用户ID")
    @TableField("user_id")
    open var userId: Int? = null

    /** 设备ID */
    @ApiModelProperty(value = "设备ID")
    @TableField("equipment_id")
    open var equipmentId: Int? = null

    /** 上次使用时间 */
    @ApiModelProperty(value = "上次使用时间")
    @TableField("last_time")
    open var lastTime: LocalDateTime? = null

    /** 登录时间 */
    @ApiModelProperty(value = "登录时间")
    @TableField("created_time")
    open var createdTime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val USER_ID : String = "user_id"

        const val EQUIPMENT_ID : String = "equipment_id"

        const val LAST_TIME : String = "last_time"

        const val CREATED_TIME : String = "created_time"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "ApUserEquipmentEntity{" +
        "id=" + id +
        ", userId=" + userId +
        ", equipmentId=" + equipmentId +
        ", lastTime=" + lastTime +
        ", createdTime=" + createdTime +
        "}"
    }

}
