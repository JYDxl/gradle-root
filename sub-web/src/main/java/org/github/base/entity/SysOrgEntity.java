package org.github.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * sys_org_table
 * </p>
 *
 * @author JYD_XL
 * @since 2018-12-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_org")
public class SysOrgEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "org_id", type = IdType.ID_WORKER_STR)
    private String orgId;

    /**
     * 组织ID
     */
    private String orgCode;

    /**
     * 组织名称
     */
    private String orgName;

    /**
     * 1:单位或公司，2：部门，3：岗位
     */
    private String orgType;

    /**
     * 体系描述
     */
    private String remark;

    /**
     * 父级ID
     */
    private String pid;

    /**
     * create_time
     */
    private LocalDateTime createdAt;

    /**
     * update_time
     */
    private LocalDateTime updatedAt;


}
