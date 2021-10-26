package org.github.util.tree;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import lombok.*;
import com.google.common.collect.Multimap;
import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Multimaps.*;
import static com.google.common.collect.TreeMultimap.*;

public abstract class TreeUtil {
  public static <T extends TreeNode<I,E>, I, E> @NonNull List<T> buildTree(@NonNull List<T> list, @NonNull I pid) {
    val index = index(list, T::getPid);
    val root  = index.get(pid);
    recursion(root, index);
    return root;
  }

  public static <T extends TreeNode<I,E>, I, E> @NonNull List<T> buildTree(@NonNull List<T> list, @NonNull I pid, @NonNull Comparator<I> keyComparator, @NonNull Comparator<T> valueComparator) {
    val index    = create(keyComparator, valueComparator);
    val multimap = index(list, T::getPid);
    index.putAll(multimap);
    val root = index.get(pid);
    recursion(root, index);
    return newArrayList(root);
  }

  private static <T extends TreeNode<I,E>, I, E> void recursion(Collection<T> list, Multimap<I,T> index) {
    for (T item : list) {
      val id      = item.getId();
      val subList = index.get(id);
      if (subList.isEmpty()) continue;
      item.setChild(subList);
      recursion(subList, index);
    }
  }
}
