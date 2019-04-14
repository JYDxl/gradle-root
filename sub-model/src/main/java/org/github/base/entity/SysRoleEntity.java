package org.github.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import org.github.base.AbstractEntity;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统-角色表
 * </p>
 *
 * @author JYD_XL
 * @since 2019-04-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_role")
public class SysRoleEntity extends AbstractEntity {

    /** UID */
    private static final long serialVersionUID = 1L;

    /** 角色ID */
    @TableId(value = "role_id", type = IdType.UUID)
    private String roleId;

    /** 角色名称 */
    private String roleName;

    /** 角色描述 */
    private String roleDesc;

    /** 启用状态 1：启用 2：禁用 */
    private Boolean enable;

    /** 创建时间 */
    private LocalDateTime createdAt;

    /** 更新时间 */
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updatedAt;

    /** 删除标志 */
    @TableLogic
    private Integer deleted;

}
