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
 * APP用户粉丝信息表
 *
 * @author JYD_XL
 */
@TableName("ap_user_fan")
@ApiModel(value = "ApUserFanEntity对象", description = "APP用户粉丝信息表")
open class ApUserFanEntity : Entity() {

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
    @TableField("fans_id")
    open var fansId: Int? = null

    /** 粉丝昵称 */
    @ApiModelProperty(value = "粉丝昵称")
    @TableField("fans_name")
    open var fansName: String? = null

    /** 粉丝忠实度	            0 正常	            1 潜力股	            2 勇士	            3 铁杆	            4 老铁 */
    @ApiModelProperty(value = "粉丝忠实度	            0 正常	            1 潜力股	            2 勇士	            3 铁杆	            4 老铁")
    open var level: Int? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("created_time")
    open var createdTime: LocalDateTime? = null

    /** 是否可见我动态 */
    @ApiModelProperty(value = "是否可见我动态")
    @TableField("is_display")
    open var isDisplay: Int? = null

    /** 是否屏蔽私信 */
    @ApiModelProperty(value = "是否屏蔽私信")
    @TableField("is_shield_letter")
    open var isShieldLetter: Int? = null

    /** 是否屏蔽评论 */
    @ApiModelProperty(value = "是否屏蔽评论")
    @TableField("is_shield_comment")
    open var isShieldComment: Int? = null

    open var burst: String? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val USER_ID : String = "user_id"

        const val FANS_ID : String = "fans_id"

        const val FANS_NAME : String = "fans_name"

        const val LEVEL : String = "level"

        const val CREATED_TIME : String = "created_time"

        const val IS_DISPLAY : String = "is_display"

        const val IS_SHIELD_LETTER : String = "is_shield_letter"

        const val IS_SHIELD_COMMENT : String = "is_shield_comment"

        const val BURST : String = "burst"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "ApUserFanEntity{" +
        "id=" + id +
        ", userId=" + userId +
        ", fansId=" + fansId +
        ", fansName=" + fansName +
        ", level=" + level +
        ", createdTime=" + createdTime +
        ", isDisplay=" + isDisplay +
        ", isShieldLetter=" + isShieldLetter +
        ", isShieldComment=" + isShieldComment +
        ", burst=" + burst +
        "}"
    }

}
