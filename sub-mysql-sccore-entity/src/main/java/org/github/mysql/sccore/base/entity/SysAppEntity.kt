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
 * 应用管理
 *
 * @author JYD_XL
 */
@TableName("t_sys_app")
@ApiModel(value = "SysAppEntity对象", description = "应用管理")
open class SysAppEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Long? = null

    /** 应用名称 */
    @ApiModelProperty(value = "应用名称")
    @TableField("app_name")
    open var appName: String? = null

    /** 应用编号 */
    @ApiModelProperty(value = "应用编号")
    @TableField("app_code")
    open var appCode: String? = null

    /** 应用类型 */
    @ApiModelProperty(value = "应用类型")
    @TableField("app_type")
    open var appType: String? = null

    /** 应用描述 */
    @ApiModelProperty(value = "应用描述")
    @TableField("app_desc")
    open var appDesc: String? = null

    /** 所属公司 */
    @ApiModelProperty(value = "所属公司")
    @TableField("company_id")
    open var companyId: Long? = null

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

    /** 启用标志，1：可用，2：不可用 */
    @ApiModelProperty(value = "启用标志，1：可用，2：不可用")
    @TableField("use_flag")
    open var useFlag: String? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val APP_NAME : String = "app_name"

        const val APP_CODE : String = "app_code"

        const val APP_TYPE : String = "app_type"

        const val APP_DESC : String = "app_desc"

        const val COMPANY_ID : String = "company_id"

        const val USER_CREATE : String = "user_create"

        const val CREATE_DATETIME : String = "create_datetime"

        const val USER_MODIFY : String = "user_modify"

        const val MODIFY_DATETIME : String = "modify_datetime"

        const val USE_FLAG : String = "use_flag"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return "SysAppEntity{" +
        "id=" + id +
        ", appName=" + appName +
        ", appCode=" + appCode +
        ", appType=" + appType +
        ", appDesc=" + appDesc +
        ", companyId=" + companyId +
        ", userCreate=" + userCreate +
        ", createDatetime=" + createDatetime +
        ", userModify=" + userModify +
        ", modifyDatetime=" + modifyDatetime +
        ", useFlag=" + useFlag +
        "}"
    }

}
