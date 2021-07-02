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
 * 频道信息表
 *
 * @author JYD_XL
 */
@TableName("ad_channel")
@ApiModel(value = "AdChannelEntity对象", description = "频道信息表")
open class AdChannelEntity : Entity() {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Int? = null

    /** 频道名称 */
    @ApiModelProperty(value = "频道名称")
    open var name: String? = null

    /** 频道描述 */
    @ApiModelProperty(value = "频道描述")
    open var description: String? = null

    /** 是否默认频道 */
    @ApiModelProperty(value = "是否默认频道")
    @TableField("is_default")
    open var isDefault: Int? = null

    open var status: Int? = null

    /** 默认排序 */
    @ApiModelProperty(value = "默认排序")
    open var ord: Int? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("created_time")
    open var createdTime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val NAME : String = "name"

        const val DESCRIPTION : String = "description"

        const val IS_DEFAULT : String = "is_default"

        const val STATUS : String = "status"

        const val ORD : String = "ord"

        const val CREATED_TIME : String = "created_time"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "AdChannelEntity{" +
        "id=" + id +
        ", name=" + name +
        ", description=" + description +
        ", isDefault=" + isDefault +
        ", status=" + status +
        ", ord=" + ord +
        ", createdTime=" + createdTime +
        "}"
    }

}
