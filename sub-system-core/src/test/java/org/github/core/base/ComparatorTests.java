package org.github.core.base;

import cn.hutool.core.lang.Pair;
import java.util.Comparator;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.Test;
import static com.google.common.collect.Sets.newTreeSet;
import static java.util.Comparator.naturalOrder;
import static java.util.Comparator.nullsFirst;

@Slf4j
public class ComparatorTests {
  @Test
  void testComparator() {
    val compareByKey = nullsFirst(Comparator.<Pair<String,String>,String>comparing(Pair::getKey, nullsFirst(naturalOrder())));
    val compareByVal = nullsFirst(Comparator.<Pair<String,String>,String>comparing(Pair::getValue, nullsFirst(naturalOrder())));
    val comparator   = compareByKey.thenComparing(compareByVal);
    val set          = newTreeSet(comparator);
    set.addAll(Set.of(Pair.of("a", "b"), Pair.of("a", null), Pair.of(null, "b"), Pair.of(null, null)));
    set.add(null);
    log.info(set.toString());
    //如果需要继续深入嵌套，那就把【nullsFirst(Comparator.<Pair<String,String>,String>comparing(Pair::getKey, nullsFirst(naturalOrder())))】作为comparing的第二个参数继续使用
    //只有元素本身也可能为null时才需要将nullsFirst(naturalOrder())设置为根，这种情况其实并不多见
  }
}
