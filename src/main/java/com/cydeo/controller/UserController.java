package com.cydeo.controller;

import com.cydeo.dto.UserDTO;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

        model.addAttribute("user", new UserDTO());             //empty user-because we need to save
        model.addAttribute("roles",roleService.findAll());      //bring from DB-service-business logic
        model.addAttribute("users",userService.findAll());

        return "/user/create";

    }
    @PostMapping ("/create")                                                            //@ModelAttribute holding object//post- methode
    public String insertUser(@Valid @ModelAttribute("user")UserDTO user, BindingResult bindingResult, Model model){                 //model is interface -we need to pass empty user object
       if(bindingResult.hasErrors()){
           model.addAttribute("roles", roleService.findAll());
           model.addAttribute("user", userService.findAll());
           return "/user/create";
       }
        userService.save(user);                                //we need to save object -it before


        return"redirect:/user/create";                         //why? -application requirement

    }
    @GetMapping("/update/{username}")                                        //pathVariable- parameter //just for retrieving data-need to go to the service
    public String editUser(@PathVariable("username") String username, Model model){               //view and figure what we needed

        model.addAttribute("user", userService.findById(username) );
        model.addAttribute("roles",roleService.findAll());
        model.addAttribute("users",userService.findAll());

        return"/user/update";

    }
    @PostMapping("/update")                                                       //spring is binding @ModelAttribute-Automatically
    public String updateUser(@Valid@ModelAttribute("user")UserDTO user,BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("roles", roleService.findAll());
            model.addAttribute("user", userService.findAll());

            return "/user/update";
        }
        userService.update(user);//terminology-service

        return"redirect:/user/create";
    }

    @GetMapping("/delete/{username}")
    public String  deleteUser(@PathVariable("username") String username){
        userService.deleteById(username);

        return"redirect:/user/create";
    }






}
