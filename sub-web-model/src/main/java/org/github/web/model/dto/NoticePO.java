package org.github.web.model.dto;

import java.util.List;
import lombok.*;
import javax.annotation.Nullable;
import static com.google.common.collect.ImmutableList.*;

@Data
public class NoticePO {
  private @NonNull  List<String> noticeIdList = of();
  private @Nullable String       noticeIds;
}
