@file:Suppress("UnusedImport", "unused", "KotlinConstantConditions")

package org.github.mysql.center.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import java.time.LocalDateTime
import org.github.core.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 文件
 *
 * @author JYD_XL
 */
@TableName("file")
@ApiModel("文件")
open class FileMbpPo : Entity() {

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: String? = null

    @ApiModelProperty("相对路径")
    @TableField("path")
    open var path: String? = null

    @ApiModelProperty("文件名")
    @TableField("name")
    open var name: String? = null

    @ApiModelProperty("后缀")
    @TableField("suffix")
    open var suffix: String? = null

    @ApiModelProperty("大小|字节B")
    @TableField("size")
    open var size: Int? = null

    @ApiModelProperty("用途|枚举[FileUseEnum]：COURSE(\"C\", \"讲师\"), TEACHER(\"T\", \"课程\")")
    @TableField("use")
    open var use: String? = null

    @ApiModelProperty("创建时间")
    @TableField("created_at")
    open var createdAt: LocalDateTime? = null

    @ApiModelProperty("修改时间")
    @TableField("updated_at")
    open var updatedAt: LocalDateTime? = null

    @ApiModelProperty("已上传分片")
    @TableField("shard_index")
    open var shardIndex: Int? = null

    @ApiModelProperty("分片大小|B")
    @TableField("shard_size")
    open var shardSize: Int? = null

    @ApiModelProperty("分片总数")
    @TableField("shard_total")
    open var shardTotal: Int? = null

    @ApiModelProperty("文件标识")
    @TableField("key")
    open var key: String? = null

    @ApiModelProperty("vod|阿里云vod")
    @TableField("vod")
    open var vod: String? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val PATH : String = "path"

        const val NAME : String = "name"

        const val SUFFIX : String = "suffix"

        const val SIZE : String = "size"

        const val USE : String = "use"

        const val CREATED_AT : String = "created_at"

        const val UPDATED_AT : String = "updated_at"

        const val SHARD_INDEX : String = "shard_index"

        const val SHARD_SIZE : String = "shard_size"

        const val SHARD_TOTAL : String = "shard_total"

        const val KEY : String = "key"

        const val VOD : String = "vod"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return get()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is FileMbpPo) return false
        if (id != other.id) return false
        if (path != other.path) return false
        if (name != other.name) return false
        if (suffix != other.suffix) return false
        if (size != other.size) return false
        if (use != other.use) return false
        if (createdAt != other.createdAt) return false
        if (updatedAt != other.updatedAt) return false
        if (shardIndex != other.shardIndex) return false
        if (shardSize != other.shardSize) return false
        if (shardTotal != other.shardTotal) return false
        if (key != other.key) return false
        if (vod != other.vod) return false
        return true
    }

    override fun hashCode(): Int {
        var result = 0
        result = 31 * result + (id?.hashCode() ?: 0)
        result = 31 * result + (path?.hashCode() ?: 0)
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (suffix?.hashCode() ?: 0)
        result = 31 * result + (size?.hashCode() ?: 0)
        result = 31 * result + (use?.hashCode() ?: 0)
        result = 31 * result + (createdAt?.hashCode() ?: 0)
        result = 31 * result + (updatedAt?.hashCode() ?: 0)
        result = 31 * result + (shardIndex?.hashCode() ?: 0)
        result = 31 * result + (shardSize?.hashCode() ?: 0)
        result = 31 * result + (shardTotal?.hashCode() ?: 0)
        result = 31 * result + (key?.hashCode() ?: 0)
        result = 31 * result + (vod?.hashCode() ?: 0)
        return result
    }

}
