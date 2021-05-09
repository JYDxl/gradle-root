package org.github.web.module.sys.menu.model.bo;

import javax.annotation.Nullable;
import lombok.*;
import org.github.base.PageParam;
import com.fasterxml.jackson.annotation.JsonSetter;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class QueryMenuListBO extends PageParam {
  @JsonSetter("searchText")
  private @Nullable String name;
}
