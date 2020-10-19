package com.db.mongodbdemo.book;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/address")
public class AddressController {
  private final AddressService addressService;

  @RequestMapping(value = "", method = RequestMethod.GET)
  public List<Address> getAllUsers() {
    log.info("Getting all Employees.");
    return addressService.findAll();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Address getEmployee(@PathVariable String id) {
    log.info("Getting Employee with ID: {}.", id);
    Address employeeModel = addressService.findById(id);
    return employeeModel;
  }

  @RequestMapping(value = "/create", method = RequestMethod.POST)
  public Address add(final Address employeeModel) {
    log.info("Saving Employee.");
    return addressService.save(employeeModel);
  }
}
