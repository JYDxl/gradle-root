package org.github.core.util.tree;

import java.util.Collection;
import javax.annotation.Nullable;
import lombok.*;

@Data
public class DefaultTreeNode<I, E> implements TreeNode<I,E> {
  private @Nullable I                                   pid;
  private @NonNull  I                                   id;
  private @NonNull  String                              name;
  private @Nullable E                                   extra;
  private @Nullable Collection<? extends TreeNode<I,E>> child;

  public DefaultTreeNode(@Nullable I pid, @NonNull I id, @NonNull String name) {
    this.pid  = pid;
    this.id   = id;
    this.name = name;
  }
}
