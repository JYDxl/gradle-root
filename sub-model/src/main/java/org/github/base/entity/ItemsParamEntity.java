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
 * 商品参数 
 * </p>
 *
 * @author JYD_XL
 * @since 2021-04-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("items_param")
@ApiModel(value="ItemsParamEntity对象", description="商品参数 ")
public class ItemsParamEntity extends Model<ItemsParamEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  /** 商品参数id */
  @ApiModelProperty(value = "商品参数id")
  @TableId(value = "id", type = IdType.ASSIGN_ID)
  private String id;

  /** 商品外键id */
  @ApiModelProperty(value = "商品外键id")
  @TableField("item_id")
  private String itemId;

  /** 产地 产地，例：中国江苏 */
  @ApiModelProperty(value = "产地 产地，例：中国江苏")
  @TableField("produc_place")
  private String producPlace;

  /** 保质期 保质期，例：180天 */
  @ApiModelProperty(value = "保质期 保质期，例：180天")
  @TableField("foot_period")
  private String footPeriod;

  /** 品牌名 品牌名，例：三只大灰狼 */
  @ApiModelProperty(value = "品牌名 品牌名，例：三只大灰狼")
  @TableField("brand")
  private String brand;

  /** 生产厂名 生产厂名，例：大灰狼工厂 */
  @ApiModelProperty(value = "生产厂名 生产厂名，例：大灰狼工厂")
  @TableField("factory_name")
  private String factoryName;

  /** 生产厂址 生产厂址，例：大灰狼生产基地 */
  @ApiModelProperty(value = "生产厂址 生产厂址，例：大灰狼生产基地")
  @TableField("factory_address")
  private String factoryAddress;

  /** 包装方式 包装方式，例：袋装 */
  @ApiModelProperty(value = "包装方式 包装方式，例：袋装")
  @TableField("packaging_method")
  private String packagingMethod;

  /** 规格重量 规格重量，例：35g */
  @ApiModelProperty(value = "规格重量 规格重量，例：35g")
  @TableField("weight")
  private String weight;

  /** 存储方法 存储方法，例：常温5~25° */
  @ApiModelProperty(value = "存储方法 存储方法，例：常温5~25°")
  @TableField("storage_method")
  private String storageMethod;

  /** 食用方式 食用方式，例：开袋即食 */
  @ApiModelProperty(value = "食用方式 食用方式，例：开袋即食")
  @TableField("eat_method")
  private String eatMethod;

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
