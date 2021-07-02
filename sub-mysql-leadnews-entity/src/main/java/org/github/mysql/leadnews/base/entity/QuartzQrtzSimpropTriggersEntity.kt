package org.github.mysql.leadnews.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.math.BigDecimal
import org.github.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 
 *
 * @author JYD_XL
 */
@TableName("quartz_qrtz_simprop_triggers")
@ApiModel(value = "QuartzQrtzSimpropTriggersEntity对象", description = "")
open class QuartzQrtzSimpropTriggersEntity : Entity() {

    @TableId(value = "SCHED_NAME", type = IdType.ASSIGN_ID)
    open var schedName: String? = null

    @TableId(value = "TRIGGER_NAME", type = IdType.ASSIGN_ID)
    open var triggerName: String? = null

    @TableId(value = "TRIGGER_GROUP", type = IdType.ASSIGN_ID)
    open var triggerGroup: String? = null

    @TableField("STR_PROP_1")
    open var strProp1: String? = null

    @TableField("STR_PROP_2")
    open var strProp2: String? = null

    @TableField("STR_PROP_3")
    open var strProp3: String? = null

    @TableField("INT_PROP_1")
    open var intProp1: Int? = null

    @TableField("INT_PROP_2")
    open var intProp2: Int? = null

    @TableField("LONG_PROP_1")
    open var longProp1: Long? = null

    @TableField("LONG_PROP_2")
    open var longProp2: Long? = null

    @TableField("DEC_PROP_1")
    open var decProp1: BigDecimal? = null

    @TableField("DEC_PROP_2")
    open var decProp2: BigDecimal? = null

    @TableField("BOOL_PROP_1")
    open var boolProp1: String? = null

    @TableField("BOOL_PROP_2")
    open var boolProp2: String? = null

    companion object {

        private const val serialVersionUID = 1L

        const val SCHED_NAME : String = "SCHED_NAME"

        const val TRIGGER_NAME : String = "TRIGGER_NAME"

        const val TRIGGER_GROUP : String = "TRIGGER_GROUP"

        const val STR_PROP_1 : String = "STR_PROP_1"

        const val STR_PROP_2 : String = "STR_PROP_2"

        const val STR_PROP_3 : String = "STR_PROP_3"

        const val INT_PROP_1 : String = "INT_PROP_1"

        const val INT_PROP_2 : String = "INT_PROP_2"

        const val LONG_PROP_1 : String = "LONG_PROP_1"

        const val LONG_PROP_2 : String = "LONG_PROP_2"

        const val DEC_PROP_1 : String = "DEC_PROP_1"

        const val DEC_PROP_2 : String = "DEC_PROP_2"

        const val BOOL_PROP_1 : String = "BOOL_PROP_1"

        const val BOOL_PROP_2 : String = "BOOL_PROP_2"

    }

    override fun pkVal(): java.io.Serializable? {
        return triggerGroup
    }

    override fun toString(): String {
        return "QuartzQrtzSimpropTriggersEntity{" +
        "schedName=" + schedName +
        ", triggerName=" + triggerName +
        ", triggerGroup=" + triggerGroup +
        ", strProp1=" + strProp1 +
        ", strProp2=" + strProp2 +
        ", strProp3=" + strProp3 +
        ", intProp1=" + intProp1 +
        ", intProp2=" + intProp2 +
        ", longProp1=" + longProp1 +
        ", longProp2=" + longProp2 +
        ", decProp1=" + decProp1 +
        ", decProp2=" + decProp2 +
        ", boolProp1=" + boolProp1 +
        ", boolProp2=" + boolProp2 +
        "}"
    }

}
