package org.github.base.model.vo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.github.base.entity.TabSafeQuestionDataEntity;
import org.github.base.entity.TabSafeQuestionTypeEntity;
import org.github.base.service.ITabSafeQuestionDataService;
import org.github.base.service.ITabSafeQuestionTypeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static com.google.common.base.MoreObjects.firstNonNull;
import static com.google.common.base.Objects.equal;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.collect.ImmutableList.toImmutableList;
import static com.google.common.collect.ImmutableListMultimap.toImmutableListMultimap;
import static com.google.common.collect.ImmutableSet.toImmutableSet;
import static com.google.common.collect.Lists.newArrayList;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;
import static java.util.stream.Stream.concat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
class TreeVOTest {
    @Autowired
    private ITabSafeQuestionTypeService safeQuestionTypeService;
    @Autowired
    private ITabSafeQuestionDataService safeQuestionDataService;
    @Autowired
    private ObjectMapper mapper;

    private static @NonNull TreeVO<Object> applyTabSafeQuestionTypeEntity2TreeVO(@NonNull TabSafeQuestionTypeEntity type) {
        val vo = new TreeVO<>();

        vo.setPid(firstNonNull(type.getParentId(), ""));
        vo.setId(type.getId());
        vo.setName(type.getTypeName());
        vo.setLeaf(false);
        vo.setExtra(null);

        return vo;
    }

    private static @NonNull TreeVO<Object> applyTabSafeQuestionDataEntity2TreeVO(@NonNull TabSafeQuestionDataEntity data) {
        val vo = new TreeVO<>();

        vo.setPid(firstNonNull(data.getQuestionTypeId(), ""));
        vo.setId(data.getId());
        vo.setName(data.getCheckContent());
        vo.setLeaf(true);
        vo.setExtra(null);

        return vo;
    }

    @Test
    void testGenerateTree() throws JsonProcessingException {
        val typeQuery = safeQuestionTypeService.lambdaQuery();
        typeQuery.eq(TabSafeQuestionTypeEntity::getProjectId, "-1");
        val typeList = typeQuery.list();
        val typeStream = typeList.stream().map(TreeVOTest::applyTabSafeQuestionTypeEntity2TreeVO);

        val dataQuery = safeQuestionDataService.lambdaQuery();
        dataQuery.eq(TabSafeQuestionDataEntity::getProjectId, "-1");
        dataQuery.eq(TabSafeQuestionDataEntity::getIsUse, 0);
        val dataList = dataQuery.list();
        val dataStream = dataList.stream().map(TreeVOTest::applyTabSafeQuestionDataEntity2TreeVO);

        val list = concat(typeStream, dataStream).collect(toList());
        val resultList = reduceList(list);

        val index = resultList.stream().collect(toImmutableListMultimap(TreeVO::getPid, identity()));
        val root = index.get("");
        recursion(root, index);
        val json = mapper.writeValueAsString(root);
        log.info(json);
    }

    private void recursion(ImmutableList<TreeVO<Object>> root, ImmutableListMultimap<String, TreeVO<Object>> index) {
        for (TreeVO<Object> vo : root) {
            val id = vo.getId();
            val subList = index.get(id);
            if (subList.isEmpty()) continue;
            vo.setChild(subList);
            recursion(subList, index);
        }
    }

    private List<TreeVO<Object>> reduceList(List<TreeVO<Object>> list) {
        val pidList = list.stream().map(TreeVO::getPid).collect(toImmutableSet());
        val subList = list.stream().filter(v -> !pidList.contains(v.getId())).filter(v -> !v.isLeaf()).collect(toImmutableList());
        if (subList.isEmpty()) return list;
        list.removeAll(subList);
        return reduceList(list);
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
        val map = list.stream().collect(groupingBy(CollectVO::getDate, reducing(CollectVO::reduce)));
        val result = map.values().stream().map(Optional::get).collect(toImmutableList());
        log.info(result.toString());
    }
}

@AllArgsConstructor
@NoArgsConstructor
@Data
class CollectVO {
    private int normal = 0;
    private int major = 0;
    private int risk = 0;
    private int check = 0;
    private String date;

    public CollectVO reduce(CollectVO vo) {
        checkArgument(equal(date, vo.date));
        return new CollectVO(normal + vo.normal, major + vo.major, risk + vo.risk, check + vo.check, date);
    }
}
