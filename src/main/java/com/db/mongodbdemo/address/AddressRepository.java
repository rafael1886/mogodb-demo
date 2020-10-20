package com.db.mongodbdemo.address;

import org.springframework.data.mongodb.repository.MongoRepository;

interface AddressRepository extends MongoRepository<Address, String> {}
