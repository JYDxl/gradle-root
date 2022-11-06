@file:Suppress("UnusedImport", "unused")

package org.github.mysql.sccore.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import java.time.LocalDateTime
import org.github.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 客户端的文件存储方式和空间大小限制，1：文件服务，3：数据库
 *
 * @author JYD_XL
 */
@TableName("t_sys_client_fs_relation")
@ApiModel(value = "SysClientFsRelationEntity对象", description = "客户端的文件存储方式和空间大小限制，1：文件服务，3：数据库")
open class SysClientFsRelationEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Long? = null

    /** 客户端ID */
    @ApiModelProperty(value = "客户端ID")
    @TableField("company_id")
    open var companyId: Long? = null

    /** 存储方式 */
    @ApiModelProperty(value = "存储方式")
    @TableField("file_store_type")
    open var fileStoreType: String? = null

    /** 存储空间大小，-1表示无限制 */
    @ApiModelProperty(value = "存储空间大小，-1表示无限制")
    @TableField("file_store_size")
    open var fileStoreSize: Long? = null

    /** 当空间存储不够时，自动根据文件上传的时间正序删除，最先上传的数据删除 */
    @ApiModelProperty(value = "当空间存储不够时，自动根据文件上传的时间正序删除，最先上传的数据删除")
    @TableField("auto_delete_flag")
    open var autoDeleteFlag: String? = null

    /** 启动标志，1：启动，2：禁止 */
    @ApiModelProperty(value = "启动标志，1：启动，2：禁止")
    @TableField("use_flag")
    open var useFlag: String? = null

    /** 创建人 */
    @ApiModelProperty(value = "创建人")
    @TableField("user_create")
    open var userCreate: String? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("create_datetime")
    open var createDatetime: LocalDateTime? = null

    /** 修改人 */
    @ApiModelProperty(value = "修改人")
    @TableField("user_modify")
    open var userModify: String? = null

    /** 修改时间 */
    @ApiModelProperty(value = "修改时间")
    @TableField("modify_datetime")
    open var modifyDatetime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val COMPANY_ID : String = "company_id"

        const val FILE_STORE_TYPE : String = "file_store_type"

        const val FILE_STORE_SIZE : String = "file_store_size"

        const val AUTO_DELETE_FLAG : String = "auto_delete_flag"

        const val USE_FLAG : String = "use_flag"

        const val USER_CREATE : String = "user_create"

        const val CREATE_DATETIME : String = "create_datetime"

        const val USER_MODIFY : String = "user_modify"

        const val MODIFY_DATETIME : String = "modify_datetime"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return "SysClientFsRelationEntity{" +
        "id=" + id +
        ", companyId=" + companyId +
        ", fileStoreType=" + fileStoreType +
        ", fileStoreSize=" + fileStoreSize +
        ", autoDeleteFlag=" + autoDeleteFlag +
        ", useFlag=" + useFlag +
        ", userCreate=" + userCreate +
        ", createDatetime=" + createDatetime +
        ", userModify=" + userModify +
        ", modifyDatetime=" + modifyDatetime +
        "}"
    }

}
