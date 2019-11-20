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
@TableName("qrtz_cron_triggers")
class QrtzCronTriggersEntity: AbstractEntity() {

    var schedName: String? = null

    var triggerName: String? = null

    var triggerGroup: String? = null

    var cronExpression: String? = null

    var timeZoneId: String? = null

}
