package org.github.web.mongo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Student {
  @Id
  private String  id;
  private String  name;
  private Integer age;
  private Student sub;
}
