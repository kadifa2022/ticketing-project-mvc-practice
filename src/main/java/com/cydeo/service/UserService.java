package com.cydeo.service;

import com.cydeo.dto.UserDTO;
import com.cydeo.entity.User;

import java.util.List;

public interface UserService extends CrudService<UserDTO,String>{

    //if is something unique for service just add
 List<UserDTO> findManager();


}
