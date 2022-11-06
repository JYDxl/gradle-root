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
 * 资源接口管理
 *
 * @author JYD_XL
 */
@TableName("t_sys_resource")
@ApiModel(value = "SysResourceEntity对象", description = "资源接口管理")
open class SysResourceEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Long? = null

    /** 资源名称 */
    @ApiModelProperty(value = "资源名称")
    @TableField("resource_name")
    open var resourceName: String? = null

    /** 资源编码 */
    @ApiModelProperty(value = "资源编码")
    @TableField("resource_code")
    open var resourceCode: String? = null

    /** 资源类型 */
    @ApiModelProperty(value = "资源类型")
    @TableField("resource_type")
    open var resourceType: String? = null

    /** 应用ID */
    @ApiModelProperty(value = "应用ID")
    @TableField("app_id")
    open var appId: Long? = null

    /** 资源描述 */
    @ApiModelProperty(value = "资源描述")
    @TableField("resource_desc")
    open var resourceDesc: String? = null

    /** 资源地址 */
    @ApiModelProperty(value = "资源地址")
    @TableField("resource_uri")
    open var resourceUri: String? = null

    /** POST、GET、PUT等 */
    @ApiModelProperty(value = "POST、GET、PUT等")
    @TableField("resource_method")
    open var resourceMethod: String? = null

    /** 启用标志，1：启用，2：禁用 */
    @ApiModelProperty(value = "启用标志，1：启用，2：禁用")
    @TableField("use_flag")
    open var useFlag: String? = null

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

        const val RESOURCE_NAME : String = "resource_name"

        const val RESOURCE_CODE : String = "resource_code"

        const val RESOURCE_TYPE : String = "resource_type"

        const val APP_ID : String = "app_id"

        const val RESOURCE_DESC : String = "resource_desc"

        const val RESOURCE_URI : String = "resource_uri"

        const val RESOURCE_METHOD : String = "resource_method"

        const val USE_FLAG : String = "use_flag"

        const val USER_CREATE : String = "user_create"

        const val CREATE_DATETIME : String = "create_datetime"

        const val USER_MODIFY : String = "user_modify"

        const val MODIFY_DATETIME : String = "modify_datetime"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return "SysResourceEntity{" +
        "id=" + id +
        ", resourceName=" + resourceName +
        ", resourceCode=" + resourceCode +
        ", resourceType=" + resourceType +
        ", appId=" + appId +
        ", resourceDesc=" + resourceDesc +
        ", resourceUri=" + resourceUri +
        ", resourceMethod=" + resourceMethod +
        ", useFlag=" + useFlag +
        ", userCreate=" + userCreate +
        ", createDatetime=" + createDatetime +
        ", userModify=" + userModify +
        ", modifyDatetime=" + modifyDatetime +
        "}"
    }

}
