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
 * 组织架构表
 *
 * @author JYD_XL
 */
@TableName("hse_dict")
open class HseDictEntity : Entity() {

    /** id */
    @TableId(value = "id", type = IdType.AUTO)
    open var id: Long? = null

    /** 上级id */
    @TableField("parent_id")
    open var parentId: Long? = null

    /** 名称 */
    @TableField("name")
    open var name: String? = null

    /** 编码 */
    @TableField("dict_code")
    open var dictCode: String? = null

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

        const val PARENT_ID : String = "parent_id"

        const val NAME : String = "name"

        const val DICT_CODE : String = "dict_code"

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
