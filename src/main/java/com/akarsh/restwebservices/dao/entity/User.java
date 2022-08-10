package com.akarsh.restwebservices.dao.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "User")
public class User {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Date birthDate;

}
