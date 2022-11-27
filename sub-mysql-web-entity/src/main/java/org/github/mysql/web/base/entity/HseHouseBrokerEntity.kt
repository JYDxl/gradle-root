@file:Suppress("UnusedImport", "unused")

package org.github.mysql.web.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import java.time.LocalDateTime
import org.github.base.Entity

/**
 * 房源经纪人
 *
 * @author JYD_XL
 */
@TableName("hse_house_broker")
open class HseHouseBrokerEntity : Entity() {

    /** id */
    @TableId(value = "id", type = IdType.AUTO)
    open var id: Long? = null

    /** 房源id */
    @TableField("house_id")
    open var houseId: Long? = null

    /** 经纪人id */
    @TableField("broker_id")
    open var brokerId: Long? = null

    /** 经纪人名称 */
    @TableField("broker_name")
    open var brokerName: String? = null

    /** 经纪人头像 */
    @TableField("broker_head_url")
    open var brokerHeadUrl: String? = null

    /** 创建时间 */
    @TableField("create_time")
    open var createTime: LocalDateTime? = null

    /** 更新时间 */
    @TableField("update_time")
    open var updateTime: LocalDateTime? = null

    /** 删除标记（0:不可用 1:可用） */
    @TableField("is_deleted")
    open var isDeleted: Byte? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val HOUSE_ID : String = "house_id"

        const val BROKER_ID : String = "broker_id"

        const val BROKER_NAME : String = "broker_name"

        const val BROKER_HEAD_URL : String = "broker_head_url"

        const val CREATE_TIME : String = "create_time"

        const val UPDATE_TIME : String = "update_time"

        const val IS_DELETED : String = "is_deleted"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return "HseHouseBrokerEntity{" +
        "id=" + id +
        ", houseId=" + houseId +
        ", brokerId=" + brokerId +
        ", brokerName=" + brokerName +
        ", brokerHeadUrl=" + brokerHeadUrl +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", isDeleted=" + isDeleted +
        "}"
    }

}
