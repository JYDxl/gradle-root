package org.github.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import org.github.base.AbstractEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.*;

/**
 * <p>
 * 通知公告表
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-20
 */
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@TableName("sys_notice")
public class SysNoticeEntity extends AbstractEntity {
    /** UID */
    private static final long serialVersionUID = 1L;

    /** 公告ID */
    @TableId(value = "notice_id", type = IdType.AUTO)
    private Integer noticeId;

    /** 公告标题 */
    @TableField("notice_title")
    private String noticeTitle;

    /** 公告类型（1通知 2公告） */
    @TableField("notice_type")
    private String noticeType;

    /** 公告内容 */
    @TableField("notice_content")
    private String noticeContent;

    /** 公告状态（0正常 1关闭） */
    @TableField("status")
    private String status;

    /** 创建者 */
    @TableField("create_by")
    private String createBy;

    /** 创建时间 */
    @TableField("create_time")
    private LocalDateTime createTime;

    /** 更新者 */
    @TableField("update_by")
    private String updateBy;

    /** 更新时间 */
    @TableField("update_time")
    private LocalDateTime updateTime;

    /** 备注 */
    @TableField("remark")
    private String remark;
}
