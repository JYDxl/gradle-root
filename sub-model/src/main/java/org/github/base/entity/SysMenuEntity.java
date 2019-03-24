package org.github.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * sys_menu_table
 * </p>
 *
 * @author JYD_XL
 * @since 2019-03-24
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
    private String menuName;

    /** 资源类型，菜单或都按钮(menu,button) */
    private String menuType;

    /** menu_url */
    private String menuUrl;

    /** menu_code */
    private String menuCode;

    /** parent_id */
    private String pid;

    /** child_num */
    private Integer childNum;

    /** list_order */
    private Integer listOrder;

    /** create_time */
    private LocalDateTime createdAt;

    /** update_time */
    private LocalDateTime updatedAt;

    /** delete flag */
    @TableLogic
    private Integer deleted;

}
