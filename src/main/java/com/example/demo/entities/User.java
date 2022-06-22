package com.example.demo.entities;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class User{
    @Id
    Long id;
    String name;
    String mail;



}
