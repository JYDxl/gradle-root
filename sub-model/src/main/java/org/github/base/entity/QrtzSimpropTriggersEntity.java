package org.github.base.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import org.github.base.AbstractEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.*;

/**
 * <p>
 * 
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-21
 */
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@TableName("qrtz_simprop_triggers")
public class QrtzSimpropTriggersEntity extends AbstractEntity {
    /** UID */
    private static final long serialVersionUID = 1L;

    @TableId("sched_name")
    private String schedName;

    @TableField("trigger_name")
    private String triggerName;

    @TableField("trigger_group")
    private String triggerGroup;

    @TableField("str_prop_1")
    private String strProp1;

    @TableField("str_prop_2")
    private String strProp2;

    @TableField("str_prop_3")
    private String strProp3;

    @TableField("int_prop_1")
    private Integer intProp1;

    @TableField("int_prop_2")
    private Integer intProp2;

    @TableField("long_prop_1")
    private Long longProp1;

    @TableField("long_prop_2")
    private Long longProp2;

    @TableField("dec_prop_1")
    private BigDecimal decProp1;

    @TableField("dec_prop_2")
    private BigDecimal decProp2;

    @TableField("bool_prop_1")
    private String boolProp1;

    @TableField("bool_prop_2")
    private String boolProp2;
}
