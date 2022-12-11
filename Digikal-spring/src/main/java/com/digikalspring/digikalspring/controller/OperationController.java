package com.digikalspring.digikalspring.controller;

import com.digikalspring.digikalspring.dto.LoginRequestDto;
import com.digikalspring.digikalspring.dto.LoginResponseDto;
import com.digikalspring.digikalspring.dto.RegisterRequestDto;
import com.digikalspring.digikalspring.dto.RegisterResponseDto;
import com.digikalspring.digikalspring.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class OperationController {
    private final UserService userService;

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto requestDto){
                 return userService.login(requestDto);
    }
    @PostMapping("/register")
    public RegisterResponseDto register(@RequestBody RegisterRequestDto requestDto){return userService.register(requestDto);}
}
