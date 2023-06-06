package com.sergio.jwt.backend.services;

import com.sergio.jwt.backend.dtos.CredentialsDto;
import com.sergio.jwt.backend.dtos.SignUpDto;
import com.sergio.jwt.backend.dtos.UserDto;

public interface UserService {

    UserDto login(CredentialsDto credentialsDto);

    UserDto register(SignUpDto userDto);

    void updateUserData(UserDto userDto,Long userId);

    UserDto getUserInfo(Long id);
}
