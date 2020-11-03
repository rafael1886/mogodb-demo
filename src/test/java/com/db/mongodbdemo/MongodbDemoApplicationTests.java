package com.db.mongodbdemo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import com.db.mongodbdemo.country.Country;
import com.db.mongodbdemo.country.CountryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class MongodbDemoApplicationTests {
  @Autowired private CountryRepository repository;

  private static final int NUMBER_OF_COUNTRIES = 6;

  @BeforeEach
  public void init() {

    repository.deleteAll();

    repository.save(new Country("China", 1382050000));
    repository.save(new Country("India ", 1313210000));
    repository.save(new Country("USA", 324666000));
    repository.save(new Country("Indonesia", 260581000));
    repository.save(new Country("Brazil", 207221000));
    repository.save(new Country("Pakistan", 196626000));
  }

  @Test
  public void countAllCountries() {

    var countries = repository.findAll();
    assertEquals(NUMBER_OF_COUNTRIES, countries.size());
  }

  @Test
  public void countOneCountry() {

    Example<Country> example = Example.of(new Country("China", 1382050000));

    assertThat(repository.count(example)).isEqualTo(1L);
  }

  @Test
  public void setsIdOnSave() {
    Country nigeria = repository.save(new Country("Nigeria", 186988000));
    assertThat(nigeria.getId()).isNotNull();
  }

  @Test
  public void findOneCountry() {
    Example<Country> example = Example.of(new Country("India", 1313210000));
    Country country = repository.findOne(example).orElseThrow();
    assertThat(country.getName()).isEqualTo("India");
  }
}
