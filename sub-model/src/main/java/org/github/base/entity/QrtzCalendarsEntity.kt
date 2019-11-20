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
@TableName("qrtz_calendars")
class QrtzCalendarsEntity: AbstractEntity() {

    var schedName: String? = null

    var calendarName: String? = null

    var calendar: Blob? = null

}
