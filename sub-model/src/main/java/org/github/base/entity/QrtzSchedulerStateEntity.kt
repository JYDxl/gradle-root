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
@TableName("qrtz_scheduler_state")
class QrtzSchedulerStateEntity: AbstractEntity() {

    var schedName: String? = null

    var instanceName: String? = null

    var lastCheckinTime: Long? = null

    var checkinInterval: Long? = null

}
