package org.github.base.entity

import com.baomidou.mybatisplus.annotation.TableName
import org.github.base.AbstractEntity
import java.sql.Blob

/**
 * <p>
 * 
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-19
 */
@TableName("qrtz_triggers")
class QrtzTriggersEntity: AbstractEntity() {

    var schedName: String? = null

    var triggerName: String? = null

    var triggerGroup: String? = null

    var jobName: String? = null

    var jobGroup: String? = null

    var description: String? = null

    var nextFireTime: Long? = null

    var prevFireTime: Long? = null

    var priority: Int? = null

    var triggerState: String? = null

    var triggerType: String? = null

    var startTime: Long? = null

    var endTime: Long? = null

    var calendarName: String? = null

    var misfireInstr: Int? = null

    var jobData: Blob? = null

}
