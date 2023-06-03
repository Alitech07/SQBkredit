package org.example.entity;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String firstName;
    private String LastName;
    private String birthDay;
    private String phoneNumber;
    private Double salary;
}
