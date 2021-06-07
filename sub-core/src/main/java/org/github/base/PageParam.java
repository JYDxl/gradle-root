package org.github.base;

import java.util.List;
import java.util.Objects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import lombok.experimental.Accessors;
import static com.google.common.collect.ImmutableList.*;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@Data
@ApiModel(value = "PageParam对象", description = "分页参数")
public class PageParam extends Sort implements IParam {
  @ApiModelProperty(value = "当前页", example = "1")
  private int pageNum = 1;

  @ApiModelProperty(value = "每页显示的数据量", example = "10")
  private int pageSize = 10;

  @ApiModelProperty(value = "是否执行count查询", example = "true")
  private boolean searchCount = true;

  @ApiModelProperty(value = "排序信息集合")
  private @NonNull List<Sort> sortList = of();

  protected @NonNull List<OrderItem> sortList() {
    return sortList.stream().map(Sort::sort).filter(Objects::nonNull).collect(toImmutableList());
  }
}
