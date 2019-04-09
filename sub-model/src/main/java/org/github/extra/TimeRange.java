package org.github.extra;

import lombok.Data;
import lombok.NonNull;
import com.google.common.collect.Range;

@Data
public class TimeRange implements Comparable<TimeRange> {
  @NonNull
  private final String tag;

  @NonNull
  private final Range<Integer> range;

  @Override
  public int compareTo(@NonNull TimeRange other) {
    return range.lowerEndpoint().compareTo(other.range.lowerEndpoint());
  }
}
