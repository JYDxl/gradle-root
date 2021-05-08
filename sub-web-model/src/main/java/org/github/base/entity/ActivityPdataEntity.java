package org.github.base.entity;

import org.github.base.Model;
import com.baomidou.mybatisplus.annotation.*;
import java.io.Serializable;
import javax.annotation.Nullable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-08
 */
@SuppressWarnings("all")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("activity_pdata")
@ApiModel(value="ActivityPdataEntity对象", description="")
public class ActivityPdataEntity extends Model<ActivityPdataEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Long id;

  @TableField("activity_id")
  private @Nullable Long activityId;

  @TableField("member_id")
  private @Nullable Long memberId;

  @TableField("name")
  private @Nullable String name;

  @TableField("mobile")
  private @Nullable String mobile;

  @TableField("province")
  private @Nullable Integer province;

  @TableField("province_name")
  private @Nullable String provinceName;

  @TableField("city")
  private @Nullable Integer city;

  @TableField("city_name")
  private @Nullable String cityName;

  @TableField("remark")
  private @Nullable String remark;

  @TableField("extend_data")
  private @Nullable String extendData;

  @TableField("create_time")
  private @Nullable Long createTime;

  @TableField("brand_id")
  private @Nullable Integer brandId;

  @TableField("brand_name")
  private @Nullable String brandName;

  @TableField("make_id")
  private @Nullable Integer makeId;

  @TableField("make_name")
  private @Nullable String makeName;

  @TableField("model_id")
  private @Nullable Integer modelId;

  @TableField("model_name")
  private @Nullable String modelName;

  @TableField("car_id")
  private @Nullable Integer carId;

  @TableField("car_name")
  private @Nullable String carName;

  @TableField("dealer_id")
  private @Nullable Integer dealerId;

  @TableField("channel_id")
  private @Nullable Integer channelId;

  /** 0：待处理	            1：跟进中	            2：战败	            3：无效	            4：成交 */
  @ApiModelProperty(value = "0：待处理	            1：跟进中	            2：战败	            3：无效	            4：成交")
  @TableField("state")
  private @Nullable Integer state;

  @TableField("state_update_uid")
  private @Nullable Integer stateUpdateUid;

  @TableField("state_update_time")
  private @Nullable Long stateUpdateTime;

  @TableField("visitor_guid")
  private @Nullable String visitorGuid;

  @TableField("visit_ip")
  private @Nullable String visitIp;

  @TableField("dealer_name")
  private @Nullable String dealerName;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
