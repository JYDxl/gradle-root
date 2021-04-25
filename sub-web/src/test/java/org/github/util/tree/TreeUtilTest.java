package org.github.util.tree;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.github.base.entity.TabSafeQuestionDataEntity;
import org.github.base.entity.TabSafeQuestionTypeEntity;
import org.github.base.model.vo.TreeVO;
import org.github.base.service.ITabSafeQuestionDataService;
import org.github.base.service.ITabSafeQuestionTypeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static com.google.common.base.MoreObjects.firstNonNull;
import static com.google.common.collect.ImmutableList.copyOf;
import static com.google.common.collect.ImmutableList.toImmutableList;
import static com.google.common.collect.ImmutableSet.toImmutableSet;
import static com.google.common.collect.Lists.newArrayList;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;
import static java.util.stream.Stream.concat;
import static org.github.util.tree.TreeUtil.buildTree;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
class TreeUtilTest {
  @Autowired
  private ITabSafeQuestionTypeService safeQuestionTypeService;
  @Autowired
  private ITabSafeQuestionDataService safeQuestionDataService;
  @Autowired
  private ObjectMapper                mapper;

  private @NonNull TreeVO applyTabSafeQuestionDataEntity2TreeVO(@NonNull TabSafeQuestionDataEntity data) {
    val vo = new TreeVO(firstNonNull(data.getQuestionTypeId(), ""), data.getId(), data.getCheckContent());
    vo.setLeaf(true);
    return vo;
  }

  private @NonNull TreeVO applyTabSafeQuestionTypeEntity2TreeVO(@NonNull TabSafeQuestionTypeEntity type) {
    val vo = new TreeVO(firstNonNull(type.getParentId(), ""), type.getId(), type.getTypeName());
    vo.setLeaf(false);
    return vo;
  }

  private void reduceList(List<TreeVO> list) {
    val pidList = list.stream().map(TreeVO::getPid).collect(toImmutableSet());
    val subList = list.stream().filter(v -> !pidList.contains(v.getId())).filter(v -> !v.isLeaf()).collect(toImmutableList());
    if (subList.isEmpty()) return;
    list.removeAll(subList);
    reduceList(list);
  }

  @Test
  void testGenerateTree() throws JsonProcessingException {
    val typeQuery = safeQuestionTypeService.lambdaQuery();
    typeQuery.eq(TabSafeQuestionTypeEntity::getProjectId, "-1");
    val typeList   = typeQuery.list();
    val typeStream = typeList.stream().map(this::applyTabSafeQuestionTypeEntity2TreeVO);

    val dataQuery = safeQuestionDataService.lambdaQuery();
    dataQuery.eq(TabSafeQuestionDataEntity::getProjectId, "-1");
    dataQuery.eq(TabSafeQuestionDataEntity::getIsUse, 0);
    val dataList   = dataQuery.list();
    val dataStream = dataList.stream().map(this::applyTabSafeQuestionDataEntity2TreeVO);

    val list = concat(typeStream, dataStream).collect(toList());
    reduceList(list);

    val tree = buildTree(list, "", comparing(TreeVO::getName));
    val json = mapper.writeValueAsString(tree);
    log.info(json);
  }

  @Test
  void testReduce() {
    val list = newArrayList(
      new CollectVO(0, 1, 1, 1, "2021-04-25"),
      new CollectVO(1, 0, 1, 1, "2021-04-23"),
      new CollectVO(1, 0, 1, 1, "2021-04-23"),
      new CollectVO(1, 0, 1, 1, "2021-04-23"),
      new CollectVO(0, 1, 1, 1, "2021-04-16"),
      new CollectVO(1, 0, 1, 1, "2021-04-23"),
      new CollectVO(0, 0, 1, 1, "2021-04-23"),
      new CollectVO(1, 0, 1, 1, "2021-04-25"),
      new CollectVO(1, 0, 1, 1, "2021-04-23"),
      new CollectVO(0, 1, 1, 1, "2021-04-16"),
      new CollectVO(1, 0, 1, 1, "2021-04-23"),
      new CollectVO(1, 0, 1, 1, "2021-04-16"),
      new CollectVO(1, 0, 1, 1, "2021-04-23"),
      new CollectVO(1, 0, 1, 1, "2021-04-23"),
      new CollectVO(0, 0, 1, 1, "2021-04-23"),
      new CollectVO(0, 1, 1, 1, "2021-04-16"),
      new CollectVO(1, 0, 1, 1, "2021-04-23"),
      new CollectVO(1, 0, 1, 1, "2021-04-16"),
      new CollectVO(0, 0, 0, 1, "2021-04-15"),
      new CollectVO(0, 0, 0, 1, "2021-04-25"),
      new CollectVO(0, 0, 0, 1, "2021-04-22"),
      new CollectVO(0, 0, 0, 1, "2021-04-22"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-19"),
      new CollectVO(0, 0, 0, 1, "2021-04-15"),
      new CollectVO(0, 0, 0, 1, "2021-04-15"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-16"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-22"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-15"),
      new CollectVO(0, 0, 0, 1, "2021-04-15"),
      new CollectVO(0, 0, 0, 1, "2021-04-14"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-15"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-15"),
      new CollectVO(0, 0, 0, 1, "2021-04-15"),
      new CollectVO(0, 0, 0, 1, "2021-04-22"),
      new CollectVO(0, 0, 0, 1, "2021-04-15")
    );
    val map    = list.stream().collect(groupingBy(CollectVO::getDate, reducing(new CollectVO(), CollectVO::reduce)));
    val result = copyOf(map.values());
    log.info(result.toString());
  }
}

@AllArgsConstructor
@NoArgsConstructor
@Data
class CollectVO {
  private int    normal = 0;
  private int    major  = 0;
  private int    risk   = 0;
  private int    check  = 0;
  private String date;

  public CollectVO reduce(CollectVO vo) {
    return new CollectVO(normal + vo.normal, major + vo.major, risk + vo.risk, check + vo.check, vo.date);
  }
}
