package org.github.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import org.github.base.AbstractEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.*;

/**
 * <p>
 * 用户与岗位关联表
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-21
 */
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@TableName("sys_user_post")
public class SysUserPostEntity extends AbstractEntity {
    /** UID */
    private static final long serialVersionUID = 1L;

    /** 用户ID */
    @TableId("user_id")
    private Long userId;

    /** 岗位ID */
    @TableField("post_id")
    private Long postId;
}
