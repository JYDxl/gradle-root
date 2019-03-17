package org.github.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * sys_org_table
 * </p>
 *
 * @author JYD_XL
 * @since 2019-03-17
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
    private String orgCode;

    /** 组织名称 */
    private String orgName;

    /** 1:单位或公司，2：部门，3：岗位 */
    private String orgType;

    /** 体系描述 */
    private String remark;

    /** 父级ID */
    private String pid;

    /** create_time */
    private LocalDateTime createdAt;

    /** update_time */
    private LocalDateTime updatedAt;

    /** delete flag */
    @TableLogic
    private Integer deleted;

}
