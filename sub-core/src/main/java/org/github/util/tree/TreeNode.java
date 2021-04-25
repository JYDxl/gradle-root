package org.github.util.tree;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.github.base.IJson;

import javax.annotation.Nullable;
import java.util.List;

@RequiredArgsConstructor
@Data
public abstract class TreeNode<I, E> implements IJson {
  @NonNull
  private I pid;

  @NonNull
  private I id;

  @NonNull
  private String name;

  @Nullable
  private E extra;

  @Nullable
  private List<? extends TreeNode<I,E>> child;
}
