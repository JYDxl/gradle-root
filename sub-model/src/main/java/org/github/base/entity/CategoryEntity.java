package org.github.base.entity;

import org.github.base.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 商品分类 
 * </p>
 *
 * @author JYD_XL
 * @since 2021-04-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("category")
@ApiModel(value="CategoryEntity对象", description="商品分类 ")
public class CategoryEntity extends Model<CategoryEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  /** 主键 */
  @ApiModelProperty(value = "主键")
  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;

  /** 分类名称 */
  @ApiModelProperty(value = "分类名称")
  @TableField("name")
  private String name;

  /** 分类类型 */
  @ApiModelProperty(value = "分类类型")
  @TableField("type")
  private Integer type;

  /** 父id */
  @ApiModelProperty(value = "父id")
  @TableField("father_id")
  private Integer fatherId;

  /** 图标 */
  @ApiModelProperty(value = "图标")
  @TableField("logo")
  private String logo;

  /** 口号 */
  @ApiModelProperty(value = "口号")
  @TableField("slogan")
  private String slogan;

  /** 分类图 */
  @ApiModelProperty(value = "分类图")
  @TableField("cat_image")
  private String catImage;

  /** 背景颜色 */
  @ApiModelProperty(value = "背景颜色")
  @TableField("bg_color")
  private String bgColor;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
