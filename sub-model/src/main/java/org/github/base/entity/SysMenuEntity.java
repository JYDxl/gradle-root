package org.github.base.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.github.base.AbstractEntity;

import java.time.LocalDateTime;

/**
 * <p>
 * 菜单权限表
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-21
 */
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@TableName("sys_menu")
public class SysMenuEntity extends AbstractEntity {
    /** UID */
    private static final long serialVersionUID = 1L;

    /** 菜单ID */
    @TableId(value = "menu_id", type = IdType.AUTO)
    private Long menuId;

    /** 菜单名称 */
    @TableField("menu_name")
    private String menuName;

    /** 父菜单ID */
    @TableField("parent_id")
    private Long parentId;

    /** 显示顺序 */
    @TableField("order_num")
    private Integer orderNum;

    /** 请求地址 */
    @TableField("url")
    private String url;

    /** 打开方式（menuItem页签 menuBlank新窗口） */
    @TableField("target")
    private String target;

    /** 菜单类型（M目录 C菜单 F按钮） */
    @TableField("menu_type")
    private String menuType;

    /** 菜单状态（0显示 1隐藏） */
    @TableField("visible")
    private String visible;

    /** 权限标识 */
    @TableField("perms")
    private String perms;

    /** 菜单图标 */
    @TableField("icon")
    private String icon;

    /** 创建者 */
    @TableField("create_by")
    private String createBy;

    /** 创建时间 */
    @TableField("create_time")
    private LocalDateTime createTime;

    /** 更新者 */
    @TableField("update_by")
    private String updateBy;

    /** 更新时间 */
    @TableField("update_time")
    private LocalDateTime updateTime;

    /** 备注 */
    @TableField("remark")
    private String remark;
}
