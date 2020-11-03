package com.db.mongodbdemo;

import static org.junit.Assert.assertEquals;

import com.db.mongodbdemo.address.Address;
import com.db.mongodbdemo.address.AddressService;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class MongodbAddressTests {
  @Autowired private AddressService addressService;

  @BeforeEach
  public void init() {
    addressService.remove();
    IntStream.range(1, 100000)
        .forEach(
            i ->
                addressService.save(
                    new Address("Zamkowa" + i, "Lublin", "lubelskie", String.valueOf(i))));
  }

  @Test
  public void countAllCountries() {
    var countries = addressService.findAll();
    assertEquals(countries.size(), countries.size());
  }
}
