package org.github.web.model.vo;

import java.util.Optional;
import lombok.*;
import org.github.util.tree.DefaultTreeNode;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Getter
@Setter
public class TreeVO extends DefaultTreeNode<String,Object> {
  private boolean leaf;

  public TreeVO(@NonNull Optional<String> pid, @NonNull String id, @NonNull String name) {
    super(pid, id, name);
  }
}
