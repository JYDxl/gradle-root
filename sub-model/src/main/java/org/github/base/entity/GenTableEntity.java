package org.github.base.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.github.base.AbstractEntity;

import java.time.LocalDateTime;

/**
 * <p>
 * 代码生成业务表
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-21
 */
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@TableName("gen_table")
public class GenTableEntity extends AbstractEntity {
    /** UID */
    private static final long serialVersionUID = 1L;

    /** 编号 */
    @TableId(value = "table_id", type = IdType.AUTO)
    private Long tableId;

    /** 表名称 */
    @TableField("table_name")
    private String tableName;

    /** 表描述 */
    @TableField("table_comment")
    private String tableComment;

    /** 实体类名称 */
    @TableField("class_name")
    private String className;

    /** 使用的模板（crud单表操作 tree树表操作） */
    @TableField("tpl_category")
    private String tplCategory;

    /** 生成包路径 */
    @TableField("package_name")
    private String packageName;

    /** 生成模块名 */
    @TableField("module_name")
    private String moduleName;

    /** 生成业务名 */
    @TableField("business_name")
    private String businessName;

    /** 生成功能名 */
    @TableField("function_name")
    private String functionName;

    /** 生成功能作者 */
    @TableField("function_author")
    private String functionAuthor;

    /** 其它生成选项 */
    @TableField("options")
    private String options;

    /** 创建者 */
    @TableField("create_by")
    private String createBy;

    /** 创建时间 */
    @TableField("create_time")
    private LocalDateTime createTime;

    /** 更新者 */
    @TableField("update_by")
    private String updateBy;

    /** 更新时间 */
    @TableField("update_time")
    private LocalDateTime updateTime;

    /** 备注 */
    @TableField("remark")
    private String remark;
}
