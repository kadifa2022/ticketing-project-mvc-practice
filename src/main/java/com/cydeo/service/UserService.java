package com.cydeo.service;

import com.cydeo.dto.UserDTO;
import com.cydeo.entity.User;

import java.util.List;

public interface UserService {
    UserDTO save (UserDTO user);
    UserDTO findBy(String userName);
    List<UserDTO> findAll();
    void deleteById(String userName);

}
