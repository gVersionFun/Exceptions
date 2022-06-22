package com.example.demo.services;

import com.example.demo.dtos.UserDTO;
import com.example.demo.entities.User;
import com.example.demo.repositories.MongoUserRepo;
import com.example.demo.repositories.UserRepo;

public class UserService {
    private UserRepo userRepo;
    private MongoUserRepo mongoUserRepo;


    public UserService(UserRepo userRepo, MongoUserRepo mongoUserRepo){
        this.userRepo = userRepo;
        this.mongoUserRepo = mongoUserRepo;

    }





    public void createUser(User user) {
        if(userRepo.findUserByEmail(user.getMail()) == null) {
            mongoUserRepo.save(user);

        }
        }






    }

