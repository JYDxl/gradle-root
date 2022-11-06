@file:Suppress("UnusedImport", "unused")

package org.github.mysql.sccore.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import java.time.LocalDate
import java.time.LocalDateTime
import org.github.base.Entity

/**
 * 用户管理
 *
 * @author JYD_XL
 */
@TableName("t_sys_user")
open class SysUserEntity : Entity() {

    /** 主键 */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Long? = null

    /** 登录用户名 */
    @TableField("user_name")
    open var userName: String? = null

    /** 登录密码 */
    @TableField("user_pwd")
    open var userPwd: String? = null

    /** 加密方式 */
    @TableField("algorithm")
    open var algorithm: String? = null

    /** 秘钥 */
    @TableField("secret_key")
    open var secretKey: ByteArray? = null

    /** 姓名 */
    @TableField("user_person")
    open var userPerson: String? = null

    /** 性别 */
    @TableField("user_sex")
    open var userSex: String? = null

    /** 出生日期 */
    @TableField("user_birthday")
    open var userBirthday: String? = null

    /** 职位ID */
    @TableField("user_title_id")
    open var userTitleId: String? = null

    /** 邮箱 */
    @TableField("user_email")
    open var userEmail: String? = null

    /** 用户地址 */
    @TableField("user_address")
    open var userAddress: String? = null

    /** 部门id */
    @TableField("dept_id")
    open var deptId: Long? = null

    /** 手机号 */
    @TableField("user_mobile")
    open var userMobile: String? = null

    /** 密码时效日期 */
    @TableField("user_expired_date")
    open var userExpiredDate: LocalDate? = null

    /** 上一次登录时间 */
    @TableField("last_login_datetime")
    open var lastLoginDatetime: LocalDateTime? = null

    /** 组织id */
    @TableField("company_id")
    open var companyId: Long? = null

    /** 用户锁定状态，1：是，2：否 */
    @TableField("user_lock_flag")
    open var userLockFlag: String? = null

    /** 用户启用标志，1：可用，2：不可用 */
    @TableField("use_flag")
    open var useFlag: String? = null

    /** 删除标志 */
    @TableField("del_flag")
    open var delFlag: String? = null

    /** 创建人 */
    @TableField("creator_name")
    open var creatorName: String? = null

    /** 创建时间 */
    @TableField("created_time")
    open var createdTime: LocalDateTime? = null

    /** 修改人 */
    @TableField("updater_name")
    open var updaterName: String? = null

    /** 修改时间 */
    @TableField("updated_time")
    open var updatedTime: LocalDateTime? = null

    /** 组织编码 */
    @TableField("org_code")
    open var orgCode: String? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val USER_NAME : String = "user_name"

        const val USER_PWD : String = "user_pwd"

        const val ALGORITHM : String = "algorithm"

        const val SECRET_KEY : String = "secret_key"

        const val USER_PERSON : String = "user_person"

        const val USER_SEX : String = "user_sex"

        const val USER_BIRTHDAY : String = "user_birthday"

        const val USER_TITLE_ID : String = "user_title_id"

        const val USER_EMAIL : String = "user_email"

        const val USER_ADDRESS : String = "user_address"

        const val DEPT_ID : String = "dept_id"

        const val USER_MOBILE : String = "user_mobile"

        const val USER_EXPIRED_DATE : String = "user_expired_date"

        const val LAST_LOGIN_DATETIME : String = "last_login_datetime"

        const val COMPANY_ID : String = "company_id"

        const val USER_LOCK_FLAG : String = "user_lock_flag"

        const val USE_FLAG : String = "use_flag"

        const val DEL_FLAG : String = "del_flag"

        const val CREATOR_NAME : String = "creator_name"

        const val CREATED_TIME : String = "created_time"

        const val UPDATER_NAME : String = "updater_name"

        const val UPDATED_TIME : String = "updated_time"

        const val ORG_CODE : String = "org_code"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return "SysUserEntity{" +
        "id=" + id +
        ", userName=" + userName +
        ", userPwd=" + userPwd +
        ", algorithm=" + algorithm +
        ", secretKey=" + secretKey +
        ", userPerson=" + userPerson +
        ", userSex=" + userSex +
        ", userBirthday=" + userBirthday +
        ", userTitleId=" + userTitleId +
        ", userEmail=" + userEmail +
        ", userAddress=" + userAddress +
        ", deptId=" + deptId +
        ", userMobile=" + userMobile +
        ", userExpiredDate=" + userExpiredDate +
        ", lastLoginDatetime=" + lastLoginDatetime +
        ", companyId=" + companyId +
        ", userLockFlag=" + userLockFlag +
        ", useFlag=" + useFlag +
        ", delFlag=" + delFlag +
        ", creatorName=" + creatorName +
        ", createdTime=" + createdTime +
        ", updaterName=" + updaterName +
        ", updatedTime=" + updatedTime +
        ", orgCode=" + orgCode +
        "}"
    }

}
