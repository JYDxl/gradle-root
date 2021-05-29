package org.github.mysql.web.base.entity;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import org.github.base.IEntity;
import javax.annotation.Nullable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-29
 */
@SuppressWarnings("all")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_role")
@ApiModel(value="SysRoleMbpEntity对象", description="角色")
public class SysRoleMbpEntity extends IEntity {

    /** UID */
    private static final long serialVersionUID = 1L;

    @TableId(value = "role_id", type = IdType.AUTO)
    private @Nullable Long roleId;

    /** 角色名称 */
    @ApiModelProperty(value = "角色名称")
    @TableField("role_name")
    private @Nullable String roleName;

    /** 角色编码 */
    @ApiModelProperty(value = "角色编码")
    @TableField("role_code")
    private @Nullable String roleCode;

    /** 备注 */
    @ApiModelProperty(value = "备注")
    @TableField("remark")
    private @Nullable String remark;

    /** 创建者ID */
    @ApiModelProperty(value = "创建者ID")
    @TableField("create_user_id")
    private @Nullable Long createUserId;

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private @Nullable LocalDateTime createTime;

}
