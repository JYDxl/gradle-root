@file:Suppress("UnusedImport", "unused")

package org.github.mysql.sccore.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import java.time.LocalDateTime
import org.github.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 数据字典表
 *
 * @author JYD_XL
 */
@TableName("t_sys_code_name")
@ApiModel(value = "SysCodeNameEntity对象", description = "数据字典表")
open class SysCodeNameEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Long? = null

    /** 码值类型ID */
    @ApiModelProperty(value = "码值类型ID")
    @TableField("code_id")
    open var codeId: Long? = null

    /** 国际化语言,en,zh_cn等等 */
    @ApiModelProperty(value = "国际化语言,en,zh_cn等等")
    @TableField("code_language")
    open var codeLanguage: String? = null

    /** 码值名称 */
    @ApiModelProperty(value = "码值名称")
    @TableField("code_name")
    open var codeName: String? = null

    /** 创建人 */
    @ApiModelProperty(value = "创建人")
    @TableField("user_create")
    open var userCreate: String? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("create_datetime")
    open var createDatetime: LocalDateTime? = null

    /** 修改人 */
    @ApiModelProperty(value = "修改人")
    @TableField("user_modify")
    open var userModify: String? = null

    /** 修改时间 */
    @ApiModelProperty(value = "修改时间")
    @TableField("modify_datetime")
    open var modifyDatetime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val CODE_ID : String = "code_id"

        const val CODE_LANGUAGE : String = "code_language"

        const val CODE_NAME : String = "code_name"

        const val USER_CREATE : String = "user_create"

        const val CREATE_DATETIME : String = "create_datetime"

        const val USER_MODIFY : String = "user_modify"

        const val MODIFY_DATETIME : String = "modify_datetime"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return "SysCodeNameEntity{" +
        "id=" + id +
        ", codeId=" + codeId +
        ", codeLanguage=" + codeLanguage +
        ", codeName=" + codeName +
        ", userCreate=" + userCreate +
        ", createDatetime=" + createDatetime +
        ", userModify=" + userModify +
        ", modifyDatetime=" + modifyDatetime +
        "}"
    }

}
