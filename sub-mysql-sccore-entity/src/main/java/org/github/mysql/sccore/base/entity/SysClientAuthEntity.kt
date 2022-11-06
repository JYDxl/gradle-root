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
 * 客户端授权表，登录授权、API授权、文件服务授权、调度授权
 *
 * @author JYD_XL
 */
@TableName("t_sys_client_auth")
open class SysClientAuthEntity : Entity() {

    /** 主键 */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Long? = null

    /** 客户端ID */
    @TableField("client_id")
    open var clientId: Long? = null

    /** 登录授权 */
    @TableField("login_flag")
    open var loginFlag: String? = null

    /** 文件服务授权 */
    @TableField("fs_flag")
    open var fsFlag: String? = null

    /** 开发授权 */
    @TableField("fp_flag")
    open var fpFlag: String? = null

    /** 调度授权 */
    @TableField("ts_flag")
    open var tsFlag: String? = null

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

        const val LOGIN_FLAG : String = "login_flag"

        const val FS_FLAG : String = "fs_flag"

        const val FP_FLAG : String = "fp_flag"

        const val TS_FLAG : String = "ts_flag"

        const val USER_CREATE : String = "user_create"

        const val CREATE_DATETIME : String = "create_datetime"

        const val USER_MODIFY : String = "user_modify"

        const val MODIFY_DATETIME : String = "modify_datetime"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return "SysClientAuthEntity{" +
        "id=" + id +
        ", clientId=" + clientId +
        ", loginFlag=" + loginFlag +
        ", fsFlag=" + fsFlag +
        ", fpFlag=" + fpFlag +
        ", tsFlag=" + tsFlag +
        ", userCreate=" + userCreate +
        ", createDatetime=" + createDatetime +
        ", userModify=" + userModify +
        ", modifyDatetime=" + modifyDatetime +
        "}"
    }

}
