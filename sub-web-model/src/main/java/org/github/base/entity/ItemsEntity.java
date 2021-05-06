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
 * 商品表 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表
 * </p>
 *
 * @author JYD_XL
 * @since 2021-04-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("items")
@ApiModel(value="ItemsEntity对象", description="商品表 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表")
public class ItemsEntity extends Model<ItemsEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  /** 商品主键id */
  @ApiModelProperty(value = "商品主键id")
  @TableId(value = "id", type = IdType.ASSIGN_ID)
  private String id;

  /** 商品名称 商品名称 */
  @ApiModelProperty(value = "商品名称 商品名称")
  @TableField("item_name")
  private String itemName;

  /** 分类外键id 分类id */
  @ApiModelProperty(value = "分类外键id 分类id")
  @TableField("cat_id")
  private Integer catId;

  /** 一级分类外键id */
  @ApiModelProperty(value = "一级分类外键id")
  @TableField("root_cat_id")
  private Integer rootCatId;

  /** 累计销售 累计销售 */
  @ApiModelProperty(value = "累计销售 累计销售")
  @TableField("sell_counts")
  private Integer sellCounts;

  /** 上下架状态 上下架状态,1:上架 2:下架 */
  @ApiModelProperty(value = "上下架状态 上下架状态,1:上架 2:下架")
  @TableField("on_off_status")
  private Integer onOffStatus;

  /** 商品内容 商品内容 */
  @ApiModelProperty(value = "商品内容 商品内容")
  @TableField("content")
  private String content;

  /** 创建时间 */
  @ApiModelProperty(value = "创建时间")
  @TableField("created_time")
  private LocalDateTime createdTime;

  /** 更新时间 */
  @ApiModelProperty(value = "更新时间")
  @TableField("updated_time")
  private LocalDateTime updatedTime;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}