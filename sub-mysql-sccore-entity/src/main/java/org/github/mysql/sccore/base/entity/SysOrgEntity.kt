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
 * 区域表，行政数据
 *
 * @author JYD_XL
 */
@TableName("t_sys_org")
@ApiModel(value = "SysOrgEntity对象", description = "区域表，行政数据")
open class SysOrgEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Long? = null

    /** 父节点编码（为0时为父节点） */
    @ApiModelProperty(value = "父节点编码（为0时为父节点）")
    @TableField("parent_org_code")
    open var parentOrgCode: String? = null

    /** 行政区名称 */
    @ApiModelProperty(value = "行政区名称")
    @TableField("org_name")
    open var orgName: String? = null

    /** 行政区编码 */
    @ApiModelProperty(value = "行政区编码")
    @TableField("org_code")
    open var orgCode: String? = null

    /** 行政区类型,1:国家，2：省，3：市区，4：县 */
    @ApiModelProperty(value = "行政区类型,1:国家，2：省，3：市区，4：县")
    @TableField("org_type")
    open var orgType: String? = null

    /** 排序 */
    @ApiModelProperty(value = "排序")
    @TableField("org_order")
    open var orgOrder: Long? = null

    /** 启动标志，1：启动，2：禁止 */
    @ApiModelProperty(value = "启动标志，1：启动，2：禁止")
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

        const val PARENT_ORG_CODE : String = "parent_org_code"

        const val ORG_NAME : String = "org_name"

        const val ORG_CODE : String = "org_code"

        const val ORG_TYPE : String = "org_type"

        const val ORG_ORDER : String = "org_order"

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
        return "SysOrgEntity{" +
        "id=" + id +
        ", parentOrgCode=" + parentOrgCode +
        ", orgName=" + orgName +
        ", orgCode=" + orgCode +
        ", orgType=" + orgType +
        ", orgOrder=" + orgOrder +
        ", useFlag=" + useFlag +
        ", userCreate=" + userCreate +
        ", createDatetime=" + createDatetime +
        ", userModify=" + userModify +
        ", modifyDatetime=" + modifyDatetime +
        "}"
    }

}
