@file:Suppress("UnusedImport", "unused")

package org.github.mysql.sccore.base.entity

import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import java.time.LocalDateTime
import org.github.base.Entity

/**
 * 部门表
 *
 * @author JYD_XL
 */
@TableName("t_sys_department")
open class SysDepartmentEntity : Entity() {

    /** 主键 */
    @TableField("id")
    open var id: Long? = null

    /** 部门名称 */
    @TableField("dept_name")
    open var deptName: String? = null

    /** 部门描述 */
    @TableField("dept_desc")
    open var deptDesc: String? = null

    /** 上级部门id */
    @TableField("parent_dept_id")
    open var parentDeptId: Long? = null

    /** 所属组织编码 */
    @TableField("org_code")
    open var orgCode: String? = null

    /** 排序 */
    @TableField("org_order")
    open var orgOrder: Int? = null

    /** 启动标志 */
    @TableField("user_flag")
    open var userFlag: String? = null

    /** 创建人 */
    @TableField("user_create")
    open var userCreate: String? = null

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

        const val DEPT_NAME : String = "dept_name"

        const val DEPT_DESC : String = "dept_desc"

        const val PARENT_DEPT_ID : String = "parent_dept_id"

        const val ORG_CODE : String = "org_code"

        const val ORG_ORDER : String = "org_order"

        const val USER_FLAG : String = "user_flag"

        const val USER_CREATE : String = "user_create"

        const val CREATE_DATETIME : String = "create_datetime"

        const val USER_MODIFY : String = "user_modify"

        const val MODIFY_DATETIME : String = "modify_datetime"

    }

    override fun pkVal(): Serializable? {
        return null
    }

    override fun toString(): String {
        return get()
    }

}
