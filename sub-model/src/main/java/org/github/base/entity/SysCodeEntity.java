package org.github.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * sys_code_table
 * </p>
 *
 * @author JYD_XL
 * @since 2019-03-07
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
    private String codeName;

    /** 码值 */
    private String codeValue;

    /** 显示顺序 */
    private Integer showNum;

    /** 码值类型 */
    private String codeTypeId;

    /** 1:可用，2：不可用 */
    private String useType;

    /** delete flag */
    @TableLogic
    private Integer deleted;

    /** update version */
    @Version
    private Integer version;

}
