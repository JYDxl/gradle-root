package org.github.base;

import lombok.Data;

@Data
public class PageModel implements IModel {
  private int pageNum = 1;

  private int pageSize = 10;
}
