package com.example.demo.entities;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Table
@Entity
public class User{

    @Column
    String name;
    @Id
    String mail;



}
