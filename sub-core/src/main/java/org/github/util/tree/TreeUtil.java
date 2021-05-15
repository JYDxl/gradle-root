package org.github.util.tree;

import java.util.Comparator;
import java.util.List;
import javax.annotation.Nullable;
import lombok.*;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import static com.google.common.collect.ImmutableList.*;
import static com.google.common.collect.ImmutableListMultimap.*;
import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Maps.*;
import static com.google.common.collect.Multimaps.*;
import static java.util.Collections.*;
import static java.util.function.Function.*;

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

  public static <T extends TreeNode<I,E>, I, E> @NonNull List<List<T>> findAllChild(@NonNull List<T> list, boolean includeThemself, @NonNull List<I> ids) {
    val index = list.stream().collect(toImmutableListMultimap(TreeNode::getPid, identity()));
    val map   = uniqueIndex(list, T::getId);
    return ids.stream().map(id -> {
      List<T> result = includeThemself ? newArrayList(map.get(id)) : newArrayList();
      recursion(singletonList(id), index, result);
      return result;
    }).collect(toImmutableList());
  }

  private static <I, T extends TreeNode<I,E>, E> void recursion(List<I> input, ImmutableListMultimap<I,T> index, List<T> result) {
    for (I id : input) {
      List<T> subList = index.get(id);
      if (subList.isEmpty()) continue;
      result.addAll(subList);
      recursion(Lists.transform(subList, T::getId), index, result);
    }
  }
}
