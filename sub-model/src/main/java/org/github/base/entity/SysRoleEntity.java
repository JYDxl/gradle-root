package org.github.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * sys_role_table
 * </p>
 *
 * @author JYD_XL
 * @since 2019-01-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_role")
public class SysRoleEntity implements Serializable {

    /** UID */
    private static final long serialVersionUID = 1L;

    /** ID */
    @TableId(value = "role_id", type = IdType.UUID)
    private String roleId;

    /** role_name */
    @TableField("role_name")
    private String roleName;

    /** role_desc */
    @TableField("role_desc")
    private String roleDesc;

    /** enable */
    @TableField("enable")
    private Boolean enable;

    /** create_time */
    @TableField("created_at")
    private LocalDateTime createdAt;

    /** update_time */
    @TableField("updated_at")
    private LocalDateTime updatedAt;

    /** delete flag */
    @TableField("deleted")
    @TableLogic
    private Integer deleted;

    /** update version */
    @TableField("version")
    @Version
    private Integer version;

}
