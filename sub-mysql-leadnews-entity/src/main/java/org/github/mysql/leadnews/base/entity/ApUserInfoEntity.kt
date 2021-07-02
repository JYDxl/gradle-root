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
 * APP用户信息表
 *
 * @author JYD_XL
 */
@TableName("ap_user_info")
@ApiModel(value = "ApUserInfoEntity对象", description = "APP用户信息表")
open class ApUserInfoEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Int? = null

    @TableField("user_id")
    open var userId: Int? = null

    /** 真是姓名 */
    @ApiModelProperty(value = "真是姓名")
    open var name: String? = null

    /** 身份证号,aes加密 */
    @ApiModelProperty(value = "身份证号,aes加密")
    open var idno: String? = null

    /** 公司 */
    @ApiModelProperty(value = "公司")
    open var company: String? = null

    /** 职业 */
    @ApiModelProperty(value = "职业")
    open var occupation: String? = null

    /** 年龄 */
    @ApiModelProperty(value = "年龄")
    open var age: Int? = null

    open var birthday: LocalDateTime? = null

    /** 个人格言 */
    @ApiModelProperty(value = "个人格言")
    open var introduction: String? = null

    /** 归属地 */
    @ApiModelProperty(value = "归属地")
    open var location: String? = null

    /** 粉丝数量 */
    @ApiModelProperty(value = "粉丝数量")
    open var fans: Int? = null

    /** 关注数量 */
    @ApiModelProperty(value = "关注数量")
    open var follows: Int? = null

    /** 是否允许推荐我给好友 */
    @ApiModelProperty(value = "是否允许推荐我给好友")
    @TableField("is_recommend_me")
    open var isRecommendMe: Int? = null

    /** 是否允许给我推荐好友 */
    @ApiModelProperty(value = "是否允许给我推荐好友")
    @TableField("is_recommend_friend")
    open var isRecommendFriend: Int? = null

    /** 是否分享页面显示头像 */
    @ApiModelProperty(value = "是否分享页面显示头像")
    @TableField("is_display_image")
    open var isDisplayImage: Int? = null

    /** 更新时间 */
    @ApiModelProperty(value = "更新时间")
    @TableField("updated_time")
    open var updatedTime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val USER_ID : String = "user_id"

        const val NAME : String = "name"

        const val IDNO : String = "idno"

        const val COMPANY : String = "company"

        const val OCCUPATION : String = "occupation"

        const val AGE : String = "age"

        const val BIRTHDAY : String = "birthday"

        const val INTRODUCTION : String = "introduction"

        const val LOCATION : String = "location"

        const val FANS : String = "fans"

        const val FOLLOWS : String = "follows"

        const val IS_RECOMMEND_ME : String = "is_recommend_me"

        const val IS_RECOMMEND_FRIEND : String = "is_recommend_friend"

        const val IS_DISPLAY_IMAGE : String = "is_display_image"

        const val UPDATED_TIME : String = "updated_time"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "ApUserInfoEntity{" +
        "id=" + id +
        ", userId=" + userId +
        ", name=" + name +
        ", idno=" + idno +
        ", company=" + company +
        ", occupation=" + occupation +
        ", age=" + age +
        ", birthday=" + birthday +
        ", introduction=" + introduction +
        ", location=" + location +
        ", fans=" + fans +
        ", follows=" + follows +
        ", isRecommendMe=" + isRecommendMe +
        ", isRecommendFriend=" + isRecommendFriend +
        ", isDisplayImage=" + isDisplayImage +
        ", updatedTime=" + updatedTime +
        "}"
    }

}
