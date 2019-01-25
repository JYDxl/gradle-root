package org.github.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * sys_menu_table
 * </p>
 *
 * @author JYD_XL
 * @since 2019-01-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_menu")
public class SysMenuEntity implements Serializable {

    /** UID */
    private static final long serialVersionUID = 1L;

    /** ID */
    @TableId(value = "menu_id", type = IdType.UUID)
    private String menuId;

    /** menu_name */
    @TableField("menu_name")
    private String menuName;

    /** 资源类型，菜单或都按钮(menu,button) */
    @TableField("menu_type")
    private String menuType;

    /** menu_url */
    @TableField("menu_url")
    private String menuUrl;

    /** menu_code */
    @TableField("menu_code")
    private String menuCode;

    /** parent_id */
    @TableField("pid")
    private String pid;

    /** child_num */
    @TableField("child_num")
    private Integer childNum;

    /** list_order */
    @TableField("list_order")
    private Integer listOrder;

    /** create_time */
    @TableField("created_at")
    private LocalDateTime createdAt;

    /** update_time */
    @TableField("updated_at")
    private LocalDateTime updatedAt;

    /** delete flag */
    @TableField("deleted")
    @TableLogic
    private Integer deleted;

    /** update version */
    @TableField("version")
    @Version
    private Integer version;

}
