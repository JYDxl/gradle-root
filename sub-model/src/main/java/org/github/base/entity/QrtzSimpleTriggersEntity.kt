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
@TableName("qrtz_simple_triggers")
class QrtzSimpleTriggersEntity: AbstractEntity() {

    var schedName: String? = null

    var triggerName: String? = null

    var triggerGroup: String? = null

    var repeatCount: Long? = null

    var repeatInterval: Long? = null

    var timesTriggered: Long? = null

}
