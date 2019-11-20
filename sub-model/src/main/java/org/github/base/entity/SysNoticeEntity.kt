package org.github.base.entity

import com.baomidou.mybatisplus.annotation.TableName
import com.baomidou.mybatisplus.annotation.IdType
import org.github.base.AbstractEntity
import com.baomidou.mybatisplus.annotation.TableId
import java.time.LocalDateTime

/**
 * <p>
 * 通知公告表
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-19
 */
@TableName("sys_notice")
class SysNoticeEntity: AbstractEntity() {

    /** 公告ID */
    @TableId(value = "notice_id", type = IdType.AUTO)
    var noticeId: Int? = null

    /** 公告标题 */
    var noticeTitle: String? = null

    /** 公告类型（1通知 2公告） */
    var noticeType: String? = null

    /** 公告内容 */
    var noticeContent: String? = null

    /** 公告状态（0正常 1关闭） */
    var status: String? = null

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
