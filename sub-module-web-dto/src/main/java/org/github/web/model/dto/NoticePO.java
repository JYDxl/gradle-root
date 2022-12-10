package org.github.web.model.dto;

import java.util.List;
import javax.annotation.Nullable;
import lombok.Data;
import lombok.NonNull;
import static com.google.common.collect.ImmutableList.of;

@Data
public class NoticePO {
  private @NonNull  List<String> noticeIdList = of();
  private @Nullable String       noticeIds;
}
