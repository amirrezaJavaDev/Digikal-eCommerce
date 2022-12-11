package com.digikalspring.digikalspring.controller;

import com.digikalspring.digikalspring.dto.UserOprationResponseDto;
import com.digikalspring.digikalspring.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping(value = "/users")
    public UserOprationResponseDto findAllUsers(){
        return (UserOprationResponseDto) userService.findAllUsers();
    }

    @GetMapping(value = "/users")
    public UserOprationResponseDto findById(@RequestParam("id") Long id){
        return userService.findUserById(id);
    }

}
