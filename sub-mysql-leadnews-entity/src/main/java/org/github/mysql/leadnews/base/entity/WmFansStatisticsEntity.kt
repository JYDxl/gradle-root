package org.github.mysql.leadnews.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.time.LocalDate
import org.github.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 自媒体粉丝数据统计表
 *
 * @author JYD_XL
 */
@TableName("wm_fans_statistics")
@ApiModel(value = "WmFansStatisticsEntity对象", description = "自媒体粉丝数据统计表")
open class WmFansStatisticsEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    open var id: Int? = null

    /** 主账号ID */
    @ApiModelProperty(value = "主账号ID")
    @TableField("user_id")
    open var userId: Int? = null

    /** 子账号ID */
    @ApiModelProperty(value = "子账号ID")
    open var article: Int? = null

    @TableField("read_count")
    open var readCount: Int? = null

    open var comment: Int? = null

    open var follow: Int? = null

    open var collection: Int? = null

    open var forward: Int? = null

    open var likes: Int? = null

    open var unlikes: Int? = null

    open var unfollow: Int? = null

    open var burst: String? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("created_time")
    open var createdTime: LocalDate? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val USER_ID : String = "user_id"

        const val ARTICLE : String = "article"

        const val READ_COUNT : String = "read_count"

        const val COMMENT : String = "comment"

        const val FOLLOW : String = "follow"

        const val COLLECTION : String = "collection"

        const val FORWARD : String = "forward"

        const val LIKES : String = "likes"

        const val UNLIKES : String = "unlikes"

        const val UNFOLLOW : String = "unfollow"

        const val BURST : String = "burst"

        const val CREATED_TIME : String = "created_time"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "WmFansStatisticsEntity{" +
        "id=" + id +
        ", userId=" + userId +
        ", article=" + article +
        ", readCount=" + readCount +
        ", comment=" + comment +
        ", follow=" + follow +
        ", collection=" + collection +
        ", forward=" + forward +
        ", likes=" + likes +
        ", unlikes=" + unlikes +
        ", unfollow=" + unfollow +
        ", burst=" + burst +
        ", createdTime=" + createdTime +
        "}"
    }

}
