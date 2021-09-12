package org.github;

import lombok.*;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;
import static java.util.Arrays.*;
import static org.apache.flink.api.java.ExecutionEnvironment.*;

public class WordCountBatch {
  public static void main(String[] args) throws Exception {
    val env = getExecutionEnvironment();

    val ds = env.fromElements("hello spark", "hello flink", "data").name("ds");

    ds
      .flatMap(new FlatMapFunction<String,Tuple2<String,Integer>>() {
        @Override public void flatMap(String value, Collector<Tuple2<String,Integer>> out) {
          stream(value.split(" ")).map(v -> Tuple2.of(v, 1)).forEach(out::collect);
        }
      })
      .groupBy(0)
      .sum(1)
      .print();
  }
}