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
@TableName("qrtz_fired_triggers")
class QrtzFiredTriggersEntity: AbstractEntity() {

    var schedName: String? = null

    var entryId: String? = null

    var triggerName: String? = null

    var triggerGroup: String? = null

    var instanceName: String? = null

    var firedTime: Long? = null

    var schedTime: Long? = null

    var priority: Int? = null

    var state: String? = null

    var jobName: String? = null

    var jobGroup: String? = null

    var isNonconcurrent: String? = null

    var requestsRecovery: String? = null

}
