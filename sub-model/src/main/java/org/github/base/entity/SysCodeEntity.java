package org.github.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * sys_code_table
 * </p>
 *
 * @author JYD_XL
 * @since 2019-01-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_code")
public class SysCodeEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "code_id", type = IdType.ID_WORKER_STR)
    private String codeId;

    /**
     * 名称
     */
    private String codeName;

    /**
     * 码值
     */
    private String codeValue;

    /**
     * 显示顺序
     */
    private Integer showNum;

    /**
     * 码值类型
     */
    private String codeTypeId;

    /**
     * 1:可用，2：不可用
     */
    private String useType;


}
