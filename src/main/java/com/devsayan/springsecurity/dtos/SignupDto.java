package com.devsayan.springsecurity.dtos;

import lombok.Data;

@Data
public class SignupDto {
    private String email;
    private String password;
    private String name;
}
