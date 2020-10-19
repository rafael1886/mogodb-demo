package com.db.mongodbdemo.book;

import org.springframework.data.mongodb.repository.MongoRepository;

interface AddressRepository extends MongoRepository<Address, String> {}
