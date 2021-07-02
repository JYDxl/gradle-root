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
 * APP用户关注信息表
 *
 * @author JYD_XL
 */
@TableName("ap_user_follow")
@ApiModel(value = "ApUserFollowEntity对象", description = "APP用户关注信息表")
open class ApUserFollowEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    open var id: Int? = null

    /** 用户ID */
    @ApiModelProperty(value = "用户ID")
    @TableField("user_id")
    open var userId: Int? = null

    /** 粉丝ID */
    @ApiModelProperty(value = "粉丝ID")
    @TableField("follow_id")
    open var followId: Int? = null

    /** 粉丝昵称 */
    @ApiModelProperty(value = "粉丝昵称")
    @TableField("follow_name")
    open var followName: String? = null

    /** 关注度	            0 偶尔感兴趣	            1 一般	            2 经常	            3 高度 */
    @ApiModelProperty(value = "关注度	            0 偶尔感兴趣	            1 一般	            2 经常	            3 高度")
    open var level: Int? = null

    /** 是否动态通知 */
    @ApiModelProperty(value = "是否动态通知")
    @TableField("is_notice")
    open var isNotice: Int? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("created_time")
    open var createdTime: LocalDateTime? = null

    open var burst: String? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val USER_ID : String = "user_id"

        const val FOLLOW_ID : String = "follow_id"

        const val FOLLOW_NAME : String = "follow_name"

        const val LEVEL : String = "level"

        const val IS_NOTICE : String = "is_notice"

        const val CREATED_TIME : String = "created_time"

        const val BURST : String = "burst"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "ApUserFollowEntity{" +
        "id=" + id +
        ", userId=" + userId +
        ", followId=" + followId +
        ", followName=" + followName +
        ", level=" + level +
        ", isNotice=" + isNotice +
        ", createdTime=" + createdTime +
        ", burst=" + burst +
        "}"
    }

}
