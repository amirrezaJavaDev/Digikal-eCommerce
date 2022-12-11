package com.digikalspring.digikalspring.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class LoginRequestDto {
    private String email;
    private String password;
}
