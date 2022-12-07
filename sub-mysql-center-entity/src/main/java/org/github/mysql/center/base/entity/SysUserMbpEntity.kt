@file:Suppress("UnusedImport", "unused")

package org.github.mysql.center.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import java.time.LocalDateTime
import org.github.core.base.Entity

/**
 * 用户
 *
 * @author JYD_XL
 */
@TableName("t_sys_user")
open class SysUserMbpEntity : Entity() {

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
    @TableField("secret_algorithm")
    open var secretAlgorithm: String? = null

    /** 秘钥 */
    @TableField("secret_key")
    open var secretKey: ByteArray? = null

    /** 昵称 */
    @TableField("nice_name")
    open var niceName: String? = null

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

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val USER_NAME : String = "user_name"

        const val USER_PWD : String = "user_pwd"

        const val SECRET_ALGORITHM : String = "secret_algorithm"

        const val SECRET_KEY : String = "secret_key"

        const val NICE_NAME : String = "nice_name"

        const val CREATOR_NAME : String = "creator_name"

        const val CREATED_TIME : String = "created_time"

        const val UPDATER_NAME : String = "updater_name"

        const val UPDATED_TIME : String = "updated_time"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return get()
    }

}
