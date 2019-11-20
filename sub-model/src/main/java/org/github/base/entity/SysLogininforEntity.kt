package org.github.base.entity

import com.baomidou.mybatisplus.annotation.TableName
import com.baomidou.mybatisplus.annotation.IdType
import org.github.base.AbstractEntity
import com.baomidou.mybatisplus.annotation.TableId
import java.time.LocalDateTime

/**
 * <p>
 * 系统访问记录
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-19
 */
@TableName("sys_logininfor")
class SysLogininforEntity: AbstractEntity() {

    /** 访问ID */
    @TableId(value = "info_id", type = IdType.AUTO)
    var infoId: Long? = null

    /** 登录账号 */
    var loginName: String? = null

    /** 登录IP地址 */
    var ipaddr: String? = null

    /** 登录地点 */
    var loginLocation: String? = null

    /** 浏览器类型 */
    var browser: String? = null

    /** 操作系统 */
    var os: String? = null

    /** 登录状态（0成功 1失败） */
    var status: String? = null

    /** 提示消息 */
    var msg: String? = null

    /** 访问时间 */
    var loginTime: LocalDateTime? = null

}
