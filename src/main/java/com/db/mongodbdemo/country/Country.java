package com.db.mongodbdemo.country;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@EqualsAndHashCode
@Document
public class Country {
  @Id private String id;
  private String name;
  private int population;

  public Country(String name, int population) {
    this.name = name;
    this.population = population;
  }
}
