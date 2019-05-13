package org.github.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import org.github.base.AbstractEntity;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统-菜单表
 * </p>
 *
 * @author JYD_XL
 * @since 2019-05-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_menu")
public class SysMenuEntity extends AbstractEntity {

    /** UID */
    private static final long serialVersionUID = 1L;

    /** 菜单ID */
    @TableId(value = "menu_id", type = IdType.UUID)
    private String menuId;

    /** 菜单名称 */
    private String menuName;

    /** 资源类型，菜单或按钮(menu，button) */
    private String menuType;

    /** 菜单地址 */
    private String menuUrl;

    /** 菜单编码 */
    private String menuCode;

    /** 父节点ID */
    private String pid;

    /** 子节点数目 */
    private Integer childNum;

    /** 显示顺序 */
    private Integer listOrder;

    /** 创建时间 */
    private LocalDateTime createdAt;

    /** 更新时间 */
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updatedAt;

    /** 删除标志 */
    @TableLogic
    private Integer deleted;

}
