@file:Suppress("UnusedImport", "unused")

package org.github.mysql.sccore.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import java.time.LocalDateTime
import org.github.base.Entity

/**
 * 菜单管理
 *
 * @author JYD_XL
 */
@TableName("t_sys_menu")
open class SysMenuEntity : Entity() {

    /** 主键 */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Long? = null

    /** 父节点ID（为0时为父节点） */
    @TableField("parent_id")
    open var parentId: Long? = null

    /** 菜单名称 */
    @TableField("menu_name")
    open var menuName: String? = null

    /** 菜单编码 */
    @TableField("menu_code")
    open var menuCode: String? = null

    /** 应用ID */
    @TableField("app_id")
    open var appId: Long? = null

    /** 菜单描述 */
    @TableField("menu_desc")
    open var menuDesc: String? = null

    /** 菜单地址 */
    @TableField("menu_uri")
    open var menuUri: String? = null

    /** 菜单排序 */
    @TableField("menu_order")
    open var menuOrder: Int? = null

    /** 菜单类型，1：菜单，2：页面，3：按钮 */
    @TableField("menu_type")
    open var menuType: String? = null

    /** icon名称 */
    @TableField("icon_name")
    open var iconName: String? = null

    /** 菜单打开方式，1：与框架一致，2：新页面 */
    @TableField("menu_open_flag")
    open var menuOpenFlag: String? = null

    /** 启动标志，1：启动，2：禁止 */
    @TableField("use_flag")
    open var useFlag: String? = null

    /** 创建人 */
    @TableField("user_create")
    open var userCreate: String? = null

    /** 创建时间 */
    @TableField("create_datetime")
    open var createDatetime: LocalDateTime? = null

    /** 修改人 */
    @TableField("user_modify")
    open var userModify: String? = null

    /** 修改时间 */
    @TableField("modify_datetime")
    open var modifyDatetime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val PARENT_ID : String = "parent_id"

        const val MENU_NAME : String = "menu_name"

        const val MENU_CODE : String = "menu_code"

        const val APP_ID : String = "app_id"

        const val MENU_DESC : String = "menu_desc"

        const val MENU_URI : String = "menu_uri"

        const val MENU_ORDER : String = "menu_order"

        const val MENU_TYPE : String = "menu_type"

        const val ICON_NAME : String = "icon_name"

        const val MENU_OPEN_FLAG : String = "menu_open_flag"

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
        return get()
    }

}
