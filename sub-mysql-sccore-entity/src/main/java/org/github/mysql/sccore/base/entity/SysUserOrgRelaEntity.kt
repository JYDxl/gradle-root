@file:Suppress("UnusedImport", "unused")

package org.github.mysql.sccore.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import java.time.LocalDateTime
import org.github.base.Entity

/**
 * 用户与组织之间的数据关系
 *
 * @author JYD_XL
 */
@TableName("t_sys_user_org_rela")
open class SysUserOrgRelaEntity : Entity() {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Long? = null

    @TableField("company_id")
    open var companyId: Long? = null

    /** 用户ID */
    @TableField("user_code")
    open var userCode: String? = null

    @TableField("user_create")
    open var userCreate: String? = null

    @TableField("create_datetime")
    open var createDatetime: LocalDateTime? = null

    @TableField("user_modify")
    open var userModify: String? = null

    @TableField("modify_datetime")
    open var modifyDatetime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val COMPANY_ID : String = "company_id"

        const val USER_CODE : String = "user_code"

        const val USER_CREATE : String = "user_create"

        const val CREATE_DATETIME : String = "create_datetime"

        const val USER_MODIFY : String = "user_modify"

        const val MODIFY_DATETIME : String = "modify_datetime"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return get()
    }

}
