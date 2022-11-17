package org.github.web.mongo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import javax.annotation.Nullable;

@Data
public class Student {
  @Id
  private @Nullable String  id;
  private @Nullable String  name;
  private @Nullable Integer age;
  private @Nullable Student sub;
}
