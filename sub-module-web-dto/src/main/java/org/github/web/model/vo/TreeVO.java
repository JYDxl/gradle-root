package org.github.web.model.vo;

import javax.annotation.Nullable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import org.github.core.util.tree.DefaultTreeNode;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Getter
@Setter
public class TreeVO extends DefaultTreeNode<String,Object> {
  private boolean leaf;

  public TreeVO(@Nullable String pid, @NonNull String id, @NonNull String name) {
    super(pid, id, name);
  }
}
