package org.github.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * sys_role_menu_table
 * </p>
 *
 * @author JYD_XL
 * @since 2019-02-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_role_menu")
public class SysRoleMenuEntity implements Serializable {

    /** UID */
    private static final long serialVersionUID = 1L;

    /** ID */
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /** role_id */
    private String roleId;

    /** menu_id */
    private String menuId;

    /** delete flag */
    @TableLogic
    private Integer deleted;

    /** update version */
    @Version
    private Integer version;

}
