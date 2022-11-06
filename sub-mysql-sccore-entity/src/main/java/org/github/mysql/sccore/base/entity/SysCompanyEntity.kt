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
 * 企业信息管理
 *
 * @author JYD_XL
 */
@TableName("t_sys_company")
open class SysCompanyEntity : Entity() {

    /** 主键 */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Long? = null

    /** 应用名称 */
    @TableField("company_name")
    open var companyName: String? = null

    /** 应用描述 */
    @TableField("company_desc")
    open var companyDesc: String? = null

    /** 企业信用代码 */
    @TableField("company_code")
    open var companyCode: String? = null

    /** 企业所在地 */
    @TableField("company_org_id")
    open var companyOrgId: String? = null

    /** 企业详细地址 */
    @TableField("company_address")
    open var companyAddress: String? = null

    /** 联系人 */
    @TableField("company_person")
    open var companyPerson: String? = null

    /** 联系电话 */
    @TableField("company_tel")
    open var companyTel: String? = null

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

    /** 启用标志，1：可用，2：不可用 */
    @TableField("use_flag")
    open var useFlag: String? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val COMPANY_NAME : String = "company_name"

        const val COMPANY_DESC : String = "company_desc"

        const val COMPANY_CODE : String = "company_code"

        const val COMPANY_ORG_ID : String = "company_org_id"

        const val COMPANY_ADDRESS : String = "company_address"

        const val COMPANY_PERSON : String = "company_person"

        const val COMPANY_TEL : String = "company_tel"

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
        return "SysCompanyEntity{" +
        "id=" + id +
        ", companyName=" + companyName +
        ", companyDesc=" + companyDesc +
        ", companyCode=" + companyCode +
        ", companyOrgId=" + companyOrgId +
        ", companyAddress=" + companyAddress +
        ", companyPerson=" + companyPerson +
        ", companyTel=" + companyTel +
        ", userCreate=" + userCreate +
        ", createDatetime=" + createDatetime +
        ", userModify=" + userModify +
        ", modifyDatetime=" + modifyDatetime +
        ", useFlag=" + useFlag +
        "}"
    }

}
