package org.github.base.model.bo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.github.base.PageModel;
import static org.apache.commons.lang3.StringUtils.*;

@EqualsAndHashCode(callSuper = true)
@Data
public class ItemSearchBO extends PageModel {
  private String keywords;

  private String sort;

  @Override
  public ItemSearchBO valid() {
    if(isBlank(keywords)) {
      keywords = null;
    } else {
      if(!keywords.startsWith("%")) keywords = "%" + keywords;
    }
    return this;
  }
}
