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
 * 系统-组织表
 * </p>
 *
 * @author JYD_XL
 * @since 2019-04-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_org")
public class SysOrgEntity extends AbstractEntity {

    /** UID */
    private static final long serialVersionUID = 1L;

    /** 组织ID */
    @TableId(value = "org_id", type = IdType.UUID)
    private String orgId;

    /** 组织编码 */
    private String orgCode;

    /** 组织名称 */
    private String orgName;

    /** 1：单位或公司，2：部门，3：岗位 */
    private String orgType;

    /** 体系描述 */
    private String remark;

    /** 父节点ID */
    private String pid;

    /** 创建时间 */
    private LocalDateTime createdAt;

    /** 更新时间 */
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updatedAt;

    /** 删除标志 */
    @TableLogic
    private Integer deleted;

}
