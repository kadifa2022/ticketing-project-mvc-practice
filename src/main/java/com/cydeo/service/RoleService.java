package com.cydeo.service;

import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;

import java.util.List;

public interface RoleService {//depends on bus needs
   RoleDTO save(RoleDTO user);
   UserDTO findById(Long id);
   List<UserDTO> findAll();
   void deleteById(Long id);


}
