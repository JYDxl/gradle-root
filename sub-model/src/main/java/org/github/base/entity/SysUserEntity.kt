package org.github.base.entity

import com.baomidou.mybatisplus.annotation.TableName
import com.baomidou.mybatisplus.annotation.IdType
import org.github.base.AbstractEntity
import com.baomidou.mybatisplus.annotation.TableId
import java.time.LocalDateTime

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-19
 */
@TableName("sys_user")
class SysUserEntity: AbstractEntity() {

    /** 用户ID */
    @TableId(value = "user_id", type = IdType.AUTO)
    var userId: Long? = null

    /** 部门ID */
    var deptId: Long? = null

    /** 登录账号 */
    var loginName: String? = null

    /** 用户昵称 */
    var userName: String? = null

    /** 用户类型（00系统用户） */
    var userType: String? = null

    /** 用户邮箱 */
    var email: String? = null

    /** 手机号码 */
    var phonenumber: String? = null

    /** 用户性别（0男 1女 2未知） */
    var sex: String? = null

    /** 头像路径 */
    var avatar: String? = null

    /** 密码 */
    var password: String? = null

    /** 盐加密 */
    var salt: String? = null

    /** 帐号状态（0正常 1停用） */
    var status: String? = null

    /** 删除标志（0代表存在 2代表删除） */
    var delFlag: String? = null

    /** 最后登陆IP */
    var loginIp: String? = null

    /** 最后登陆时间 */
    var loginDate: LocalDateTime? = null

    /** 创建者 */
    var createBy: String? = null

    /** 创建时间 */
    var createTime: LocalDateTime? = null

    /** 更新者 */
    var updateBy: String? = null

    /** 更新时间 */
    var updateTime: LocalDateTime? = null

    /** 备注 */
    var remark: String? = null

}
