package com.db.mongodbdemo.address;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/address")
public class AddressController {
  private final AddressService addressService;

  @GetMapping
  public List<Address> getAllUsers() {
    log.info("Getting all Employees.");
    return addressService.findAll();
  }

  @GetMapping(value = "/{id}")
  public Address getEmployee(@PathVariable String id) {
    log.info("Getting Employee with ID: {}.", id);
    return addressService.findById(id);
  }

  @PostMapping(value = "/create")
  public Address add(final Address employeeModel) {
    log.info("Saving Employee.");
    return addressService.save(employeeModel);
  }
}
