package org.github.mysql.leadnews.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import org.github.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 
 *
 * @author JYD_XL
 */
@TableName("admin_qrtz_paused_trigger_grps")
@ApiModel(value = "AdminQrtzPausedTriggerGrpsEntity对象", description = "")
open class AdminQrtzPausedTriggerGrpsEntity : Entity() {

    @TableId(value = "SCHED_NAME", type = IdType.ASSIGN_ID)
    open var schedName: String? = null

    @TableId(value = "TRIGGER_GROUP", type = IdType.ASSIGN_ID)
    open var triggerGroup: String? = null

    companion object {

        private const val serialVersionUID = 1L

        const val SCHED_NAME : String = "SCHED_NAME"

        const val TRIGGER_GROUP : String = "TRIGGER_GROUP"

    }

    override fun pkVal(): java.io.Serializable? {
        return triggerGroup
    }

    override fun toString(): String {
        return "AdminQrtzPausedTriggerGrpsEntity{" +
        "schedName=" + schedName +
        ", triggerGroup=" + triggerGroup +
        "}"
    }

}
