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
@TableName("crawler_qrtz_locks")
@ApiModel(value = "CrawlerQrtzLocksEntity对象", description = "")
open class CrawlerQrtzLocksEntity : Entity() {

    @TableId(value = "SCHED_NAME", type = IdType.ASSIGN_ID)
    open var schedName: String? = null

    @TableId(value = "LOCK_NAME", type = IdType.ASSIGN_ID)
    open var lockName: String? = null

    companion object {

        private const val serialVersionUID = 1L

        const val SCHED_NAME : String = "SCHED_NAME"

        const val LOCK_NAME : String = "LOCK_NAME"

    }

    override fun pkVal(): java.io.Serializable? {
        return lockName
    }

    override fun toString(): String {
        return "CrawlerQrtzLocksEntity{" +
        "schedName=" + schedName +
        ", lockName=" + lockName +
        "}"
    }

}
