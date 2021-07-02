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
 * APP文章作者信息表
 *
 * @author JYD_XL
 */
@TableName("ap_author")
@ApiModel(value = "ApAuthorEntity对象", description = "APP文章作者信息表")
open class ApAuthorEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    open var id: Int? = null

    /** 作者名称 */
    @ApiModelProperty(value = "作者名称")
    open var name: String? = null

    /** 0 爬取数据	            1 签约合作商	            2 平台自媒体人	             */
    @ApiModelProperty(value = "0 爬取数据	            1 签约合作商	            2 平台自媒体人	            ")
    open var type: Int? = null

    /** 社交账号ID */
    @ApiModelProperty(value = "社交账号ID")
    @TableField("user_id")
    open var userId: Int? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("created_time")
    open var createdTime: LocalDateTime? = null

    /** 自媒体账号 */
    @ApiModelProperty(value = "自媒体账号")
    @TableField("wm_user_id")
    open var wmUserId: Int? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val NAME : String = "name"

        const val TYPE : String = "type"

        const val USER_ID : String = "user_id"

        const val CREATED_TIME : String = "created_time"

        const val WM_USER_ID : String = "wm_user_id"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "ApAuthorEntity{" +
        "id=" + id +
        ", name=" + name +
        ", type=" + type +
        ", userId=" + userId +
        ", createdTime=" + createdTime +
        ", wmUserId=" + wmUserId +
        "}"
    }

}
