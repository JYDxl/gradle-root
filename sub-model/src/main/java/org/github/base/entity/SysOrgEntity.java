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
 * sys_org_table
 * </p>
 *
 * @author JYD_XL
 * @since 2019-01-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_org")
public class SysOrgEntity implements Serializable {

    /** UID */
    private static final long serialVersionUID = 1L;

    /** ID */
    @TableId(value = "org_id", type = IdType.UUID)
    private String orgId;

    /** 组织ID */
    @TableField("org_code")
    private String orgCode;

    /** 组织名称 */
    @TableField("org_name")
    private String orgName;

    /** 1:单位或公司，2：部门，3：岗位 */
    @TableField("org_type")
    private String orgType;

    /** 体系描述 */
    @TableField("remark")
    private String remark;

    /** 父级ID */
    @TableField("pid")
    private String pid;

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
