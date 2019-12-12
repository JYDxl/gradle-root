package org.github.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import org.github.base.AbstractEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.*;

/**
 * <p>
 * 用户和角色关联表
 * </p>
 *
 * @author JYD_XL
 * @since 2019-12-12
 */
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@TableName("sys_user_role")
public class SysUserRoleEntity extends AbstractEntity {
    /** UID */
    private static final long serialVersionUID = 1L;

    /** 用户ID */
    @TableId(value = "user_id", type = IdType.ASSIGN_UUID)
    private Long userId;

    /** 角色ID */
    @TableField("role_id")
    private Long roleId;
}
