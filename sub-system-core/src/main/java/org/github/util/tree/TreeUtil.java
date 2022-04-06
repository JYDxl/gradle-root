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
  public static <T extends TreeNode<I,E>, I extends Comparable<? super I>, E> List<T> buildTree(@NonNull List<T> list, I pid) {
    return buildTree(list, pid, null);
  }

  public static <T extends TreeNode<I,E>, I extends Comparable<? super I>, E> List<T> buildTree(@NonNull List<T> list, I pid, Comparator<T> valueComparator) {
    val fun   = optional(T::getPid);
    val tmp   = index(list, fun::apply);
    val index = valueComparator == null ? tmp : sort(valueComparator, tmp);

    val root = index.get(ofNullable(pid));
    recursion(root, index);
    return newArrayList(root);
  }

  private static <T extends TreeNode<I,E>, I extends Comparable<? super I>, E> Multimap<Optional<I>,T> sort(Comparator<T> valueComparator, Multimap<Optional<I>,T> tmp) {
    val keyComparator = Comparator.<Optional<I>,I>comparing(v -> v.orElse(null), nullsFirst(naturalOrder()));
    val index         = TreeMultimap.create(keyComparator, valueComparator);
    index.putAll(tmp);
    return index;
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
