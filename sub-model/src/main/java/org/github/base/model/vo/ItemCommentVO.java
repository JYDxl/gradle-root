package org.github.base.model.vo;

import java.time.LocalDateTime;
import lombok.Data;
import org.github.base.common.DesensitizationUtil;

@Data
public class ItemCommentVO {
  private Integer       commentLevel;
  private String        content;
  private String        specName;
  private LocalDateTime createdTime;
  private String        userFace;
  private String        nickname;

  public String getNickname() {
    return DesensitizationUtil.commonDisplay(nickname);
  }
}
