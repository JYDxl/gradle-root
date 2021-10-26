package org.github.util.tree;

import java.util.Collection;
import javax.annotation.Nullable;
import lombok.*;

@RequiredArgsConstructor
@Data
public class DefaultTreeNode<I, E> implements TreeNode<I,E> {
  private @NonNull  I                                   pid;
  private @NonNull  I                                   id;
  private @NonNull  String                              name;
  private @Nullable E                                   extra;
  private @Nullable Collection<? extends TreeNode<I,E>> child;
}
