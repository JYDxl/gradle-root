package org.github.core.base;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.Objects;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import static com.google.common.collect.ImmutableList.toImmutableList;
import static com.google.common.collect.Lists.newArrayList;

@EqualsAndHashCode(callSuper = true)
@ApiModel("分页参数")
@Data
public class PageBo extends Sort {
  @ApiModelProperty(value = "当前页", example = "1")
  @Min(value = 1, message = "当前页至少为第1页")
  private int pageNum = 1;

  @ApiModelProperty(value = "页大小", example = "10")
  @Max(value = 100, message = "页大小最多为100")
  @Min(value = 10, message = "页大小最少为10")
  private int pageSize = 10;

  @ApiModelProperty(value = "搜索总条数", example = "true")
  private boolean searchCount = true;

  @ApiModelProperty(value = "多重排序")
  @NotNull
  private List<Sort> sortList = newArrayList();

  @Override
  public String toString() {
    return get();
  }

  @Override
  public void trim() {
    super.trim();
    sortList.forEach(Sort::trim);
  }

  public <T> Page<T> page() {
    return new Page<>(this);
  }

  @NonNull
  protected List<OrderItem> sortList() {
    return sortList.stream().map(Sort::sort).filter(Objects::nonNull).collect(toImmutableList());
  }
}
