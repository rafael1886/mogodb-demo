package com.db.mongodbdemo.address;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AddressService {
  private final AddressRepository addressRepository;

  public List<Address> findAll() {
    final List<Address> all = addressRepository.findAll();
    log.info("All address " + all.size());
    return all;
  }

  public Address findById(String id) {
    return addressRepository.findById(id).orElseThrow();
  }

  public Address save(Address address) {
    log.info("Save " + address.getStreet());
    return addressRepository.save(address);
  }

  public void remove() {
    addressRepository.deleteAll();
  }
}
