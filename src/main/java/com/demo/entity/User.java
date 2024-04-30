package com.demo.entity;


import com.demo.dto.Join;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity(name="tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String userId;

    private String name;

    private String password;

    private String email;

    private String address;

    private String zonecode;

    public User toJoinUser(Join join){
        this.userId = join.getId();
        this.name = join.getName();
        this.password = join.getPassword();
        this.email = join.getMail1()+"@"+join.getMail2();
        this.address = join.getAddress1()+" "+join.getAddress2();
        this.zonecode = join.getZonecode();
        return this;
    }
}
