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
 * 岗位信息表
 * </p>
 *
 * @author JYD_XL
 * @since 2019-12-12
 */
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@TableName("sys_post")
public class SysPostEntity extends AbstractEntity {
    /** UID */
    private static final long serialVersionUID = 1L;

    /** 岗位ID */
    @TableId(value = "post_id", type = IdType.AUTO)
    private Long postId;

    /** 岗位编码 */
    @TableField("post_code")
    private String postCode;

    /** 岗位名称 */
    @TableField("post_name")
    private String postName;

    /** 显示顺序 */
    @TableField("post_sort")
    private Integer postSort;

    /** 状态（0正常 1停用） */
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
