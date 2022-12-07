@file:Suppress("UnusedImport", "unused")

package org.github.mysql.center.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import java.time.LocalDateTime
import org.github.core.base.Entity

/**
 * 文件
 *
 * @author JYD_XL
 */
@TableName("file")
open class FileMbpEntity : Entity() {

    /** id */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: String? = null

    /** 相对路径 */
    @TableField("path")
    open var path: String? = null

    /** 文件名 */
    @TableField("name")
    open var name: String? = null

    /** 后缀 */
    @TableField("suffix")
    open var suffix: String? = null

    /** 大小|字节B */
    @TableField("size")
    open var size: Int? = null

    /** 用途|枚举[FileUseEnum]：COURSE("C", "讲师"), TEACHER("T", "课程") */
    @TableField("use")
    open var use: String? = null

    /** 创建时间 */
    @TableField("created_at")
    open var createdAt: LocalDateTime? = null

    /** 修改时间 */
    @TableField("updated_at")
    open var updatedAt: LocalDateTime? = null

    /** 已上传分片 */
    @TableField("shard_index")
    open var shardIndex: Int? = null

    /** 分片大小|B */
    @TableField("shard_size")
    open var shardSize: Int? = null

    /** 分片总数 */
    @TableField("shard_total")
    open var shardTotal: Int? = null

    /** 文件标识 */
    @TableField("key")
    open var key: String? = null

    /** vod|阿里云vod */
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

}
