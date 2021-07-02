package org.github.mysql.leadnews.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.time.LocalDateTime
import org.github.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 搜索热词表
 *
 * @author JYD_XL
 */
@TableName("ap_hot_words")
@ApiModel(value = "ApHotWordsEntity对象", description = "搜索热词表")
open class ApHotWordsEntity : Entity() {

    @TableId(value = "id", type = IdType.AUTO)
    open var id: Int? = null

    /** 热词 */
    @ApiModelProperty(value = "热词")
    @TableField("hot_words")
    open var hotWords: String? = null

    /** 0:热,1:荐,2:新,3:火,4:精,5:亮 */
    @ApiModelProperty(value = "0:热,1:荐,2:新,3:火,4:精,5:亮")
    open var type: Int? = null

    /** 热词日期 */
    @ApiModelProperty(value = "热词日期")
    @TableField("hot_date")
    open var hotDate: String? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("created_time")
    open var createdTime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val HOT_WORDS : String = "hot_words"

        const val TYPE : String = "type"

        const val HOT_DATE : String = "hot_date"

        const val CREATED_TIME : String = "created_time"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "ApHotWordsEntity{" +
        "id=" + id +
        ", hotWords=" + hotWords +
        ", type=" + type +
        ", hotDate=" + hotDate +
        ", createdTime=" + createdTime +
        "}"
    }

}
