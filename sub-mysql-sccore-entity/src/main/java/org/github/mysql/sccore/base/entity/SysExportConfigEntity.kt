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
 * 导出配置表
 *
 * @author JYD_XL
 */
@TableName("t_sys_export_config")
open class SysExportConfigEntity : Entity() {

    /** ID */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Long? = null

    /** 客户端ID */
    @TableField("client_id")
    open var clientId: Long? = null

    /** 导出编码，唯一性 */
    @TableField("export_code")
    open var exportCode: String? = null

    /** 导出名称 */
    @TableField("export_name")
    open var exportName: String? = null

    /** 导出描述 */
    @TableField("export_desc")
    open var exportDesc: String? = null

    /** 导出类型，1：Excel，2：Word */
    @TableField("export_type")
    open var exportType: String? = null

    /** 模板格式 */
    @TableField("template_json")
    open var templateJson: String? = null

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

        const val CLIENT_ID : String = "client_id"

        const val EXPORT_CODE : String = "export_code"

        const val EXPORT_NAME : String = "export_name"

        const val EXPORT_DESC : String = "export_desc"

        const val EXPORT_TYPE : String = "export_type"

        const val TEMPLATE_JSON : String = "template_json"

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
