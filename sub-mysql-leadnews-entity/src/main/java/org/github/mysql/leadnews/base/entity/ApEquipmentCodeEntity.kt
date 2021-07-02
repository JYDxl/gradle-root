package org.github.mysql.leadnews.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import org.github.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * APP设备码信息表
 *
 * @author JYD_XL
 */
@TableName("ap_equipment_code")
@ApiModel(value = "ApEquipmentCodeEntity对象", description = "APP设备码信息表")
open class ApEquipmentCodeEntity : Entity() {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Int? = null

    /** 用户ID */
    @ApiModelProperty(value = "用户ID")
    @TableField("equipment_id")
    open var equipmentId: Int? = null

    /** 设备码 */
    @ApiModelProperty(value = "设备码")
    open var code: String? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val EQUIPMENT_ID : String = "equipment_id"

        const val CODE : String = "code"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "ApEquipmentCodeEntity{" +
        "id=" + id +
        ", equipmentId=" + equipmentId +
        ", code=" + code +
        "}"
    }

}
