package org.github.base.entity;

import org.github.base.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 轮播图 
 * </p>
 *
 * @author JYD_XL
 * @since 2021-04-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("carousel")
@ApiModel(value="CarouselEntity对象", description="轮播图 ")
public class CarouselEntity extends Model<CarouselEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  /** 主键 */
  @ApiModelProperty(value = "主键")
  @TableId(value = "id", type = IdType.ASSIGN_ID)
  private String id;

  /** 图片 图片地址 */
  @ApiModelProperty(value = "图片 图片地址")
  @TableField("image_url")
  private String imageUrl;

  /** 背景色 */
  @ApiModelProperty(value = "背景色")
  @TableField("background_color")
  private String backgroundColor;

  /** 商品id 商品id */
  @ApiModelProperty(value = "商品id 商品id")
  @TableField("item_id")
  private String itemId;

  /** 商品分类id 商品分类id */
  @ApiModelProperty(value = "商品分类id 商品分类id")
  @TableField("cat_id")
  private String catId;

  /** 轮播图类型 轮播图类型，用于判断，可以根据商品id或者分类进行页面跳转，1：商品 2：分类 */
  @ApiModelProperty(value = "轮播图类型 轮播图类型，用于判断，可以根据商品id或者分类进行页面跳转，1：商品 2：分类")
  @TableField("type")
  private Integer type;

  /** 轮播图展示顺序 */
  @ApiModelProperty(value = "轮播图展示顺序")
  @TableField("sort")
  private Integer sort;

  /** 是否展示 */
  @ApiModelProperty(value = "是否展示")
  @TableField("is_show")
  private Integer isShow;

  /** 创建时间 创建时间 */
  @ApiModelProperty(value = "创建时间 创建时间")
  @TableField("create_time")
  private LocalDateTime createTime;

  /** 更新时间 更新 */
  @ApiModelProperty(value = "更新时间 更新")
  @TableField("update_time")
  private LocalDateTime updateTime;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
