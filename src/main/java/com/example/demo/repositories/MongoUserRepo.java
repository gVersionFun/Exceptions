package com.example.demo.repositories;

import com.example.demo.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoUserRepo extends MongoRepository<User, Long> {




}
