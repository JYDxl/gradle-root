package org.github.base.model.dto;

import java.util.List;
import lombok.*;
import static java.util.Collections.*;

@Data
public class NoticePO {
  private List<String> noticeIdList = emptyList();

  private String noticeIds;
}
