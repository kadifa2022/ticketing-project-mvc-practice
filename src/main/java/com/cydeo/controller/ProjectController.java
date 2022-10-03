package com.cydeo.controller;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.ProjectService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/project")
public class ProjectController {
    private final UserService userService;
    private final ProjectService projectService;

    public ProjectController(UserService userService, ProjectService projectService) {
        this.userService = userService;
        this.projectService = projectService;
    }

    @RequestMapping("/create")
    public String createProject(Model model){
        model.addAttribute("project", new ProjectDTO());
        model.addAttribute("managers", userService.findManager());
        model.addAttribute("projects", projectService.findAll());


        return "/project/create";
    }
    @PostMapping("/create")
    public String insertProject(@ModelAttribute("project") ProjectDTO project){
        projectService.save(project);
      //  project.setProjectStatus(Status.OPEN);//we don't put business logic inside controller

        return "redirect:/project/create";
    }
    @GetMapping("/delete/{projectCode}")
    public String  deleteUser(@PathVariable("projectCode") String projectCode){
        projectService.deleteById(projectCode);

        return"redirect:/project/create";
    }
    @GetMapping("/complete/{projectCode}")
    public String completeProject(@PathVariable("projectCode") String projectCode){//alleays chec for service
        projectService.complete(projectService.findById(projectCode));

        return "redirect:/project/create";
    }
    @GetMapping("/update/{username}")//pathVariable- parameter                            //just for retrieving data-need to go to the service
    public String editProject(@PathVariable("username") String projectCode, Model model){//view and figure what we needed

        model.addAttribute("project", projectService.findById(projectCode) );
        model.addAttribute("managers",userService.findManager());
        model.addAttribute("projects",projectService.findAll());

        return"/project/update";

    }
    @PostMapping("/update")//spring is binding @ModelAttribute-Automatically
    public String updateProject(@ModelAttribute("user") ProjectDTO project){
        projectService.update(project);//terminology-service

        return"redirect:/project/create";
    }



}
