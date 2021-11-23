package org.github.util.tree;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import lombok.*;
import com.google.common.collect.Multimap;
import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Multimaps.*;
import static com.google.common.collect.TreeMultimap.*;
import static java.util.Optional.*;

public abstract class TreeUtil {
  public static <T extends TreeNode<I,E>, I, E> @NonNull List<T> buildTree(@NonNull List<T> list, I pid) {
    val index = index(list, T::getPid);
    val root  = index.get(ofNullable(pid));
    recursion(root, index);
    return root;
  }

  public static <T extends TreeNode<I,E>, I, E> @NonNull List<T> buildTree(@NonNull List<T> list, I pid, @NonNull Comparator<Optional<I>> keyComparator, @NonNull Comparator<T> valueComparator) {
    val index    = create(keyComparator, valueComparator);
    val multimap = index(list, T::getPid);
    index.putAll(multimap);
    val root = index.get(ofNullable(pid));
    recursion(root, index);
    return newArrayList(root);
  }

  private static <T extends TreeNode<I,E>, I, E> void recursion(Collection<T> list, Multimap<Optional<I>,T> index) {
    for (T item : list) {
      val id  = item.getId();
      val sub = index.get(of(id));
      if (sub.isEmpty()) continue;
      item.setChild(sub);
      recursion(sub, index);
    }
  }
}
