package org.github.mysql.leadnews.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.sql.Blob
import org.github.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 
 *
 * @author JYD_XL
 */
@TableName("admin_qrtz_calendars")
@ApiModel(value = "AdminQrtzCalendarsEntity对象", description = "")
open class AdminQrtzCalendarsEntity : Entity() {

    @TableId(value = "SCHED_NAME", type = IdType.ASSIGN_ID)
    open var schedName: String? = null

    @TableId(value = "CALENDAR_NAME", type = IdType.ASSIGN_ID)
    open var calendarName: String? = null

    open var calendar: Blob? = null

    companion object {

        private const val serialVersionUID = 1L

        const val SCHED_NAME : String = "SCHED_NAME"

        const val CALENDAR_NAME : String = "CALENDAR_NAME"

        const val CALENDAR : String = "CALENDAR"

    }

    override fun pkVal(): java.io.Serializable? {
        return calendarName
    }

    override fun toString(): String {
        return "AdminQrtzCalendarsEntity{" +
        "schedName=" + schedName +
        ", calendarName=" + calendarName +
        ", calendar=" + calendar +
        "}"
    }

}
