package com.cydeo.controller;

import com.cydeo.dto.UserDTO;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    //dependency injection->constructor
    private final RoleService roleService;//interface
    private final UserService userService;//interface

    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }



    @GetMapping("/create")
    public String createUser(Model model){

        model.addAttribute("user", new UserDTO());//empty user
        model.addAttribute("roles",roleService.findAll());
        model.addAttribute("users",userService.findAll());

        return "/user/create";

    }
    @PostMapping ("/create")      //@ModelAttribute holding object//post- methode
    public String insertUser(@ModelAttribute("user")UserDTO user){//we need to pass empty user object
        // model.addAttribute("user", new UserDTO());
        //model.addAttribute("roles", roleService.findAll());
        userService.save(user);//we need to save object -it before
        // model.addAttribute("users",userService.findAll());

        return"redirect:/user/create";//why? -application requirement

    }
    @GetMapping("/update/{username}")//pathVariable- parameter                            //just for retrieving data-need to go to the service
    public String editUser(@PathVariable("username") String username, Model model){//view and figure what we needed

        model.addAttribute("user", userService.findById(username) );
        model.addAttribute("roles",roleService.findAll());
        model.addAttribute("users",userService.findAll());

        return"/user/update";

    }
    @PostMapping("/update")//spring is binding @ModelAttribute-Automatically
    public String updateUser(@ModelAttribute("user")UserDTO user){
        userService.update(user);//terminology-service

        return"redirect:/user/create";
    }

    @GetMapping("/delete/{username}")
    public String  deleteUser(@PathVariable("username") String username){
        userService.deleteById(username);

        return"redirect:/user/create";
    }





}
