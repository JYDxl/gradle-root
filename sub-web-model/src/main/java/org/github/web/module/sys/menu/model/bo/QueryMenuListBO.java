package org.github.web.module.sys.menu.model.bo;

import javax.annotation.Nullable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.github.base.PageParam;
import com.fasterxml.jackson.annotation.JsonSetter;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@ApiModel(value = "QueryMenuListBO对象", description = "菜单分页查询参数")
public class QueryMenuListBO extends PageParam {
  @ApiModelProperty(value = "名称", example = " ")
  @JsonSetter("searchText")
  private @Nullable String name;
}
