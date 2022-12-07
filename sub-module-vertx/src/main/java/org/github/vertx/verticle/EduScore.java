package org.github.vertx.verticle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EduScore {

  private String lesson;
  private Double score;
  private String name;

  public String getLesson()            { return lesson;}

  public void setLesson(String lesson) { this.lesson = lesson;}

  public String getName()              { return name;}

  public void setName(String name)     { this.name = name;}

  public Double getScore()             { return score;}

  public void setScore(Double score)   { this.score = score;}
}
