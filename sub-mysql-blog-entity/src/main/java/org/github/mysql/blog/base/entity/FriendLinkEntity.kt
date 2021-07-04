package org.github.mysql.blog.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.time.LocalDateTime
import org.github.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 
 *
 * @author JYD_XL
 */
@TableName("tb_friend_link")
@ApiModel(value = "FriendLinkEntity对象", description = "")
open class FriendLinkEntity : Entity() {

    @TableId(value = "id", type = IdType.AUTO)
    open var id: Int? = null

    /** 链接名 */
    @ApiModelProperty(value = "链接名")
    @TableField("link_name")
    open var linkName: String? = null

    /** 链接头像 */
    @ApiModelProperty(value = "链接头像")
    @TableField("link_avatar")
    open var linkAvatar: String? = null

    /** 链接地址 */
    @ApiModelProperty(value = "链接地址")
    @TableField("link_address")
    open var linkAddress: String? = null

    /** 链接介绍 */
    @ApiModelProperty(value = "链接介绍")
    @TableField("link_intro")
    open var linkIntro: String? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    open var createTime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val LINK_NAME : String = "link_name"

        const val LINK_AVATAR : String = "link_avatar"

        const val LINK_ADDRESS : String = "link_address"

        const val LINK_INTRO : String = "link_intro"

        const val CREATE_TIME : String = "create_time"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "FriendLinkEntity{" +
        "id=" + id +
        ", linkName=" + linkName +
        ", linkAvatar=" + linkAvatar +
        ", linkAddress=" + linkAddress +
        ", linkIntro=" + linkIntro +
        ", createTime=" + createTime +
        "}"
    }

}
