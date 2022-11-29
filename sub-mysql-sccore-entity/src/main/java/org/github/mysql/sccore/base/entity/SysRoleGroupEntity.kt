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
 * 角色组管理
 *
 * @author JYD_XL
 */
@TableName("t_sys_role_group")
open class SysRoleGroupEntity : Entity() {

    /** 主键 */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Long? = null

    /** 角色名称 */
    @TableField("role_name")
    open var roleName: Long? = null

    /** 角色编号 */
    @TableField("role_code")
    open var roleCode: String? = null

    /** 创建人 */
    @TableField("user_create")
    open var userCreate: String? = null

    /** 启用标志，1：可用，2：不可用 */
    @TableField("use_flag")
    open var useFlag: String? = null

    /** 组织ID */
    @TableField("company_id")
    open var companyId: Long? = null

    /** 创建时间 */
    @TableField("create_datetime")
    open var createDatetime: LocalDateTime? = null

    /** 修改人 */
    @TableField("user_modify")
    open var userModify: String? = null

    /** 修改时间 */
    @TableField("modify_datetime")
    open var modifyDatetime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val ROLE_NAME : String = "role_name"

        const val ROLE_CODE : String = "role_code"

        const val USER_CREATE : String = "user_create"

        const val USE_FLAG : String = "use_flag"

        const val COMPANY_ID : String = "company_id"

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
