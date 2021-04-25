package org.github.util.tree;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import lombok.NonNull;
import lombok.val;

import javax.annotation.Nullable;
import java.util.Comparator;
import java.util.List;

import static com.google.common.collect.ImmutableListMultimap.toImmutableListMultimap;
import static com.google.common.collect.Multimaps.toMultimap;
import static java.util.function.Function.identity;

public abstract class TreeUtil {
  public static <T extends TreeNode<I,E>, I, E> @NonNull List<T> buildTree(@NonNull List<T> list, @NonNull I pid, @Nullable Comparator<T> comparator) {
    ListMultimap<I,T> index = comparator == null ? list.stream().collect(toImmutableListMultimap(TreeNode::getPid, identity())) : list.stream().collect(toMultimap(TreeNode::getPid, identity(), ArrayListMultimap::create));
    val               root  = index.get(pid);
    recursion(root, index, comparator);
    return root;
  }

  private static <T extends TreeNode<I,E>, I, E> void recursion(List<T> list, ListMultimap<I,T> index, Comparator<T> comparator) {
    if (comparator != null) list.sort(comparator);
    for (T item : list) {
      val id      = item.getId();
      val subList = index.get(id);
      if (subList.isEmpty()) continue;
      item.setChild(subList);
      recursion(subList, index, comparator);
    }
  }
}
