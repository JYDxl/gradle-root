package org.github.util.tree;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.github.base.IJson;

import javax.annotation.Nullable;
import java.util.List;

@RequiredArgsConstructor
@Data
public class TreeNode<I, E> implements IJson {
  private @NonNull I pid;

  private @NonNull I id;

  private @NonNull String name;

  private @Nullable E extra;

  private @Nullable List<? extends TreeNode<I,E>> child;
}
