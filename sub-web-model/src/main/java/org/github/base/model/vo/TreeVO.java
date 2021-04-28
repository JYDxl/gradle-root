package org.github.base.model.vo;

import lombok.*;
import org.github.util.tree.TreeNode;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Getter
@Setter
public class TreeVO extends TreeNode<String,Object> {
  private boolean leaf;

  public TreeVO(@NonNull String pid, @NonNull String id, @NonNull String name) {
    super(pid, id, name);
  }
}
