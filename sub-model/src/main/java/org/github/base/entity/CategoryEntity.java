package org.github.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import org.github.base.AbstractEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.*;

/**
 * <p>
 * 商品分类 
 * </p>
 *
 * @author JYD_XL
 * @since 2021-03-16
 */
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@TableName("category")
public class CategoryEntity extends AbstractEntity {
    /** UID */
    private static final long serialVersionUID = 1L;

    /** 主键 */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /** 分类名称 */
    @TableField("name")
    private String name;

    /** 分类类型 */
    @TableField("type")
    private Integer type;

    /** 父id */
    @TableField("father_id")
    private Integer fatherId;

    /** 图标 */
    @TableField("logo")
    private String logo;

    /** 口号 */
    @TableField("slogan")
    private String slogan;

    /** 分类图 */
    @TableField("cat_image")
    private String catImage;

    /** 背景颜色 */
    @TableField("bg_color")
    private String bgColor;
}
