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
 * 码值类型
 *
 * @author JYD_XL
 */
@TableName("t_sys_code_type")
open class SysCodeTypeEntity : Entity() {

    /** 主键 */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Long? = null

    /** 启用标志，1：可用，2：不可用 */
    @TableField("use_flag")
    open var useFlag: String? = null

    /** 类型编码 */
    @TableField("code_type_id")
    open var codeTypeId: String? = null

    /** 类型名称 */
    @TableField("code_type_name")
    open var codeTypeName: String? = null

    /** 上级码值类型ID */
    @TableField("parent_code_type_id")
    open var parentCodeTypeId: String? = null

    @TableField("company_id")
    open var companyId: Long? = null

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

        const val USE_FLAG : String = "use_flag"

        const val CODE_TYPE_ID : String = "code_type_id"

        const val CODE_TYPE_NAME : String = "code_type_name"

        const val PARENT_CODE_TYPE_ID : String = "parent_code_type_id"

        const val COMPANY_ID : String = "company_id"

        const val USER_CREATE : String = "user_create"

        const val CREATE_DATETIME : String = "create_datetime"

        const val USER_MODIFY : String = "user_modify"

        const val MODIFY_DATETIME : String = "modify_datetime"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return "SysCodeTypeEntity{" +
        "id=" + id +
        ", useFlag=" + useFlag +
        ", codeTypeId=" + codeTypeId +
        ", codeTypeName=" + codeTypeName +
        ", parentCodeTypeId=" + parentCodeTypeId +
        ", companyId=" + companyId +
        ", userCreate=" + userCreate +
        ", createDatetime=" + createDatetime +
        ", userModify=" + userModify +
        ", modifyDatetime=" + modifyDatetime +
        "}"
    }

}
