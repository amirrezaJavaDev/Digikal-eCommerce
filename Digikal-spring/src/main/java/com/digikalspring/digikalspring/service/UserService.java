package com.digikalspring.digikalspring.service;

import com.digikalspring.digikalspring.digikalexception.error.LoginOperationFailException;
import com.digikalspring.digikalspring.digikalexception.error.RegisterException;
import com.digikalspring.digikalspring.digikalexception.error.UserNotFoundException;
import com.digikalspring.digikalspring.digikalexception.error.UserRegistedException;
import com.digikalspring.digikalspring.dto.*;
import com.digikalspring.digikalspring.model.User;
import com.digikalspring.digikalspring.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public LoginResponseDto login(LoginRequestDto request){
        return userRepository
                .findByEmailAndPassword(request.getEmail(), request.getPassword())
                .map(User::getId)
                .map(userId->{
                    LoginResponseDto response = new LoginResponseDto();
                    response.setId(userId);
                    return response;
                })
                .orElseThrow(LoginOperationFailException::new);
    }

    public RegisterResponseDto register(RegisterRequestDto request) {
        RegisterResponseDto response = new RegisterResponseDto();
        if (checkIfUserExist(request.getEmail())) {
            throw new RegisterException();
        }
        if (!Objects.equals(request.getPassword(),request.getConfirmPassword())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"the password are not same!");
        }
        User userEntity = new User(request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getPassword(),
                request.getUsername(),
                "/images/avatar/default.jpg");
        userRepository.save(userEntity);
        response.setMessage("user saved!");
        return  response;
    }

    public UserOprationResponseDto findUserById(Long id){
       return userRepository.findUserById(id)
                .map(User::getEmail)
                .map(userEmail->{
                    UserOprationResponseDto oprationResponseDto = new UserOprationResponseDto();
                    oprationResponseDto.setId(id);
                    oprationResponseDto.setMessage(userEmail);
                    return oprationResponseDto;
                })
                .orElseThrow(UserNotFoundException::new);
    }
    public List<UserOprationResponseDto> findAllUsers() {
        List<User> all = userRepository.findAll();
        ArrayList<UserOprationResponseDto> objects = new ArrayList<>();
        for (int i=0;i<all.size();i++){
            UserOprationResponseDto responseDto = new UserOprationResponseDto();
            User user = all.get(i);
            responseDto.setId(user.getId());
            responseDto.setMessage(user.getUserName()+user.getEmail());
            objects.add(responseDto);
        }
        return objects;
    }

    private Boolean checkIfUserExist(String email){
        return userRepository.findByEmail(email) != null?true:false;
    }

   }
