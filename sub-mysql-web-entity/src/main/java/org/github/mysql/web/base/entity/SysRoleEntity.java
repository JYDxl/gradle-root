package org.github.mysql.web.base.entity;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import org.github.base.IEntity;
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
 * @since 2021-05-21
 */
@SuppressWarnings("all")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_role")
@ApiModel(value="SysRoleEntity对象", description="角色")
public class SysRoleEntity extends IEntity {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "role_id", type = IdType.AUTO)
  private Long roleId;

  /** 角色名称 */
  @ApiModelProperty(value = "角色名称")
  @TableField("role_name")
  private String roleName;

  /** 角色编码 */
  @ApiModelProperty(value = "角色编码")
  @TableField("role_code")
  private String roleCode;

  /** 备注 */
  @ApiModelProperty(value = "备注")
  @TableField("remark")
  private String remark;

  /** 创建者ID */
  @ApiModelProperty(value = "创建者ID")
  @TableField("create_user_id")
  private Long createUserId;

  /** 创建时间 */
  @ApiModelProperty(value = "创建时间")
  @TableField("create_time")
  private LocalDateTime createTime;

}
