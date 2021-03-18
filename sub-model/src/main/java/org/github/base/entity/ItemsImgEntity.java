package org.github.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import org.github.base.AbstractEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.*;

/**
 * <p>
 * 商品图片 
 * </p>
 *
 * @author JYD_XL
 * @since 2021-03-16
 */
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@TableName("items_img")
public class ItemsImgEntity extends AbstractEntity {
    /** UID */
    private static final long serialVersionUID = 1L;

    /** 图片主键 */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /** 商品外键id 商品外键id */
    @TableField("item_id")
    private String itemId;

    /** 图片地址 图片地址 */
    @TableField("url")
    private String url;

    /** 顺序 图片顺序，从小到大 */
    @TableField("sort")
    private Integer sort;

    /** 是否主图 是否主图，1：是，0：否 */
    @TableField("is_main")
    private Integer isMain;

    /** 创建时间 */
    @TableField("created_time")
    private LocalDateTime createdTime;

    /** 更新时间 */
    @TableField("updated_time")
    private LocalDateTime updatedTime;
}
