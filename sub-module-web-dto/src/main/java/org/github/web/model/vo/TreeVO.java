package org.github.web.model.vo;

import org.jetbrains.annotations.Nullable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import lombok.Setter;
import lombok.ToString;
import org.github.core.util.tree.DefaultTreeNode;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Getter
@Setter
public class TreeVO extends DefaultTreeNode<String,Object> {
  private boolean leaf;

  public TreeVO(@Nullable String pid, @NotNull String id, @NotNull String name) {
    super(pid, id, name);
  }
}
