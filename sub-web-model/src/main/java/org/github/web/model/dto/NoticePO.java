package org.github.web.model.dto;

import java.util.List;
import lombok.*;
import static com.google.common.collect.ImmutableList.*;

@Data
public class NoticePO {
  private List<String> noticeIdList = of();
  private String       noticeIds;
}
