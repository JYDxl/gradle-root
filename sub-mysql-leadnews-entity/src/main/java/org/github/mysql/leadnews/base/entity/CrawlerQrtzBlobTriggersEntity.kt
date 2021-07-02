package org.github.mysql.leadnews.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
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
@TableName("crawler_qrtz_blob_triggers")
@ApiModel(value = "CrawlerQrtzBlobTriggersEntity对象", description = "")
open class CrawlerQrtzBlobTriggersEntity : Entity() {

    @TableId(value = "SCHED_NAME", type = IdType.ASSIGN_ID)
    open var schedName: String? = null

    @TableId(value = "TRIGGER_NAME", type = IdType.ASSIGN_ID)
    open var triggerName: String? = null

    @TableId(value = "TRIGGER_GROUP", type = IdType.ASSIGN_ID)
    open var triggerGroup: String? = null

    @TableField("BLOB_DATA")
    open var blobData: Blob? = null

    companion object {

        private const val serialVersionUID = 1L

        const val SCHED_NAME : String = "SCHED_NAME"

        const val TRIGGER_NAME : String = "TRIGGER_NAME"

        const val TRIGGER_GROUP : String = "TRIGGER_GROUP"

        const val BLOB_DATA : String = "BLOB_DATA"

    }

    override fun pkVal(): java.io.Serializable? {
        return triggerGroup
    }

    override fun toString(): String {
        return "CrawlerQrtzBlobTriggersEntity{" +
        "schedName=" + schedName +
        ", triggerName=" + triggerName +
        ", triggerGroup=" + triggerGroup +
        ", blobData=" + blobData +
        "}"
    }

}
