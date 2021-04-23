package org.github.base;

import lombok.*;

@Data
public class PageParam implements IParam {
  private int pageNum = 1;

  private int pageSize = 10;

  private boolean searchCount = true;
}
