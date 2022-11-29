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
 * 导入出配置表
 *
 * @author JYD_XL
 */
@TableName("t_sys_import_config")
open class SysImportConfigEntity : Entity() {

    /** ID */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Long? = null

    /** 客户端ID */
    @TableField("client_id")
    open var clientId: Long? = null

    /** 导入出编码，唯一性 */
    @TableField("import_code")
    open var importCode: String? = null

    /** 导入名称 */
    @TableField("import_name")
    open var importName: String? = null

    /** 导入描述 */
    @TableField("import_desc")
    open var importDesc: String? = null

    /** 导入类型，1：Excel */
    @TableField("import_type")
    open var importType: String? = null

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

        const val IMPORT_CODE : String = "import_code"

        const val IMPORT_NAME : String = "import_name"

        const val IMPORT_DESC : String = "import_desc"

        const val IMPORT_TYPE : String = "import_type"

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
