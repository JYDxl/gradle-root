package org.github.util.tree;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import lombok.*;
import com.google.common.collect.Multimap;
import com.google.common.collect.TreeMultimap;
import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Multimaps.*;
import static java.util.Comparator.*;
import static java.util.Optional.*;
import static org.github.util.FuncUtil.*;

public abstract class TreeUtil {
  private static <T extends TreeNode<I,E>, I extends Comparable<? super I>, E> @NonNull List<T> buildTree0(@NonNull List<T> list, I pid) {
    val func  = optional(T::getPid);
    val index = index(list, func::apply);
    val root  = index.get(ofNullable(pid));
    recursion(root, index);
    return root;
  }

  public static <T extends TreeNode<I,E>, I extends Comparable<? super I>, E> @NonNull List<T> buildTree(@NonNull List<T> list, I pid, Comparator<T> comparator) {
    return comparator == null ? buildTree0(list, pid) : buildTree1(list, pid, comparator);
  }

  private static <T extends TreeNode<I,E>, I extends Comparable<? super I>, E> @NonNull List<T> buildTree1(@NonNull List<T> list, I pid, @NonNull Comparator<T> valueComparator) {
    val func = optional(T::getPid);
    val tmp  = index(list, func::apply);

    val keyComparator = Comparator.<Optional<I>,I>comparing(v -> v.orElse(null), nullsFirst(naturalOrder()));
    val index         = TreeMultimap.create(keyComparator, valueComparator);
    index.putAll(tmp);

    val root = index.get(ofNullable(pid));
    recursion(root, index);
    return newArrayList(root);
  }

  private static <T extends TreeNode<I,E>, I, E> void recursion(Collection<T> list, Multimap<Optional<I>,T> index) {
    for (T item : list) {
      val id  = item.getId();
      val sub = index.get(Optional.of(id));
      if (sub.isEmpty()) continue;
      item.setChild(sub);
      recursion(sub, index);
    }
  }
}
