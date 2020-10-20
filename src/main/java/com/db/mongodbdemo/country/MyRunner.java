package com.db.mongodbdemo.country;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MyRunner implements CommandLineRunner {
  private final CountryRepository repository;

  @Override
  public void run(String... args) {
    repository.deleteAll();

    repository.save(new Country("China", 1382050000));
    repository.save(new Country("India", 1313210000));
    repository.findAll().forEach(MyRunner::accept);
  }

  private static void accept(Country country) {
    log.info("{}", country);
  }
}
