package org.github.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * sys_code_table
 * </p>
 *
 * @author JYD_XL
 * @since 2019-01-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_code")
public class SysCodeEntity implements Serializable {

    /** UID */
    private static final long serialVersionUID = 1L;

    /** ID */
    @TableId(value = "code_id", type = IdType.UUID)
    private String codeId;

    /** 名称 */
    @TableField("code_name")
    private String codeName;

    /** 码值 */
    @TableField("code_value")
    private String codeValue;

    /** 显示顺序 */
    @TableField("show_num")
    private Integer showNum;

    /** 码值类型 */
    @TableField("code_type_id")
    private String codeTypeId;

    /** 1:可用，2：不可用 */
    @TableField("use_type")
    private String useType;

    /** delete flag */
    @TableField("deleted")
    @TableLogic
    private Integer deleted;

    /** update version */
    @TableField("version")
    @Version
    private Integer version;

}
