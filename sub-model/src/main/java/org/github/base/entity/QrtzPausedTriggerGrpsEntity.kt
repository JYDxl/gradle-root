package org.github.base.entity

import com.baomidou.mybatisplus.annotation.TableName
import org.github.base.AbstractEntity

/**
 * <p>
 * 
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-19
 */
@TableName("qrtz_paused_trigger_grps")
class QrtzPausedTriggerGrpsEntity: AbstractEntity() {

    var schedName: String? = null

    var triggerGroup: String? = null

}
