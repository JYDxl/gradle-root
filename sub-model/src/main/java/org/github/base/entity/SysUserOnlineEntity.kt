package org.github.base.entity

import com.baomidou.mybatisplus.annotation.TableName
import org.github.base.AbstractEntity
import com.baomidou.mybatisplus.annotation.TableId
import java.time.LocalDateTime

/**
 * <p>
 * 在线用户记录
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-19
 */
@TableName("sys_user_online")
class SysUserOnlineEntity: AbstractEntity() {

    /** 用户会话id */
    @TableId("sessionId")
    var sessionId: String? = null

    /** 登录账号 */
    var loginName: String? = null

    /** 部门名称 */
    var deptName: String? = null

    /** 登录IP地址 */
    var ipaddr: String? = null

    /** 登录地点 */
    var loginLocation: String? = null

    /** 浏览器类型 */
    var browser: String? = null

    /** 操作系统 */
    var os: String? = null

    /** 在线状态on_line在线off_line离线 */
    var status: String? = null

    /** session创建时间 */
    var startTimestamp: LocalDateTime? = null

    /** session最后访问时间 */
    var lastAccessTime: LocalDateTime? = null

    /** 超时时间，单位为分钟 */
    var expireTime: Int? = null

}
