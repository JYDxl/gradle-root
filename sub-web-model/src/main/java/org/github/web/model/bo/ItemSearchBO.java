package org.github.web.model.bo;

import lombok.*;
import org.github.base.PageParam;
import static org.apache.commons.lang3.StringUtils.*;

@EqualsAndHashCode(callSuper = true)
@Data
public class ItemSearchBO extends PageParam {
  private String keywords;

  private String sort;

  @Override
  public @NonNull ItemSearchBO valid() {
    if(isBlank(keywords)) {
      keywords = null;
    } else {
      if(!keywords.startsWith("%")) keywords = "%" + keywords;
    }
    return this;
  }
}