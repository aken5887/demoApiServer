package com.demo.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserResponse {
    private Long id;
    private String name;
    private int age;
    private int salary;
    private String dept;

    @Builder
    public UserResponse(Long id, String name, int age, int salary, String dept) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.dept = dept;
    }
}
