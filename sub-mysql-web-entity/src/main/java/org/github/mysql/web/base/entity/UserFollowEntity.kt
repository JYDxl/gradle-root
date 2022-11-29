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
 * 用户关注表
 *
 * @author JYD_XL
 */
@TableName("user_follow")
open class UserFollowEntity : Entity() {

    /** 编号 */
    @TableId(value = "id", type = IdType.AUTO)
    open var id: Long? = null

    /** 用户id */
    @TableField("user_id")
    open var userId: Long? = null

    /** 房源id */
    @TableField("house_id")
    open var houseId: Long? = null

    /** 创建时间 */
    @TableField("create_time")
    open var createTime: LocalDateTime? = null

    /** 更新时间 */
    @TableField("update_time")
    open var updateTime: LocalDateTime? = null

    /** 逻辑删除(1:已删除，0:未删除) */
    @TableField("is_deleted")
    open var isDeleted: Byte? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val USER_ID : String = "user_id"

        const val HOUSE_ID : String = "house_id"

        const val CREATE_TIME : String = "create_time"

        const val UPDATE_TIME : String = "update_time"

        const val IS_DELETED : String = "is_deleted"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return get()
    }

}
