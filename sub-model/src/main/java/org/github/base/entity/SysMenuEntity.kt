package org.github.base.entity

import com.baomidou.mybatisplus.annotation.TableName
import com.baomidou.mybatisplus.annotation.IdType
import org.github.base.AbstractEntity
import com.baomidou.mybatisplus.annotation.TableId
import java.time.LocalDateTime

/**
 * <p>
 * 菜单权限表
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-19
 */
@TableName("sys_menu")
class SysMenuEntity: AbstractEntity() {

    /** 菜单ID */
    @TableId(value = "menu_id", type = IdType.AUTO)
    var menuId: Long? = null

    /** 菜单名称 */
    var menuName: String? = null

    /** 父菜单ID */
    var parentId: Long? = null

    /** 显示顺序 */
    var orderNum: Int? = null

    /** 请求地址 */
    var url: String? = null

    /** 打开方式（menuItem页签 menuBlank新窗口） */
    var target: String? = null

    /** 菜单类型（M目录 C菜单 F按钮） */
    var menuType: String? = null

    /** 菜单状态（0显示 1隐藏） */
    var visible: String? = null

    /** 权限标识 */
    var perms: String? = null

    /** 菜单图标 */
    var icon: String? = null

    /** 创建者 */
    var createBy: String? = null

    /** 创建时间 */
    var createTime: LocalDateTime? = null

    /** 更新者 */
    var updateBy: String? = null

    /** 更新时间 */
    var updateTime: LocalDateTime? = null

    /** 备注 */
    var remark: String? = null

}
