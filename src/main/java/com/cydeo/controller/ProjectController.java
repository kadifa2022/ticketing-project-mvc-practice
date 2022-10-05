package com.cydeo.controller;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.ProjectService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController {
    private final UserService userService;
    private final ProjectService projectService;

    public ProjectController(UserService userService, ProjectService projectService) {
        this.userService = userService;
        this.projectService = projectService;
    }

    @GetMapping("/create")
    public String createProject(Model model){
        model.addAttribute("project", new ProjectDTO());
        model.addAttribute("managers", userService.findManager());
        model.addAttribute("projects", projectService.findAll());


        return "/project/create";
    }
    @PostMapping("/create")
    public String insertProject(@ModelAttribute("project") ProjectDTO project, BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("managers", userService.findManager());
            model.addAttribute("projects", projectService.findAll());
            return "/project/create";
        }
        projectService.save(project);
      //  project.setProjectStatus(Status.OPEN);//we don't put business logic inside controller

        return "redirect:/project/create";
    }
    @GetMapping("/delete/{projectCode}")
    public String  deleteProject(@PathVariable("projectCode") String projectCode){
        projectService.deleteById(projectCode);

        return"redirect:/project/create";
    }
    @GetMapping("/complete/{projectCode}")
    public String completeProject(@PathVariable("projectCode") String projectCode){//always check for service
        projectService.complete(projectService.findById(projectCode));

        return "redirect:/project/create";
    }
    @GetMapping("/update/{projectCode}")//pathVariable- parameter                            //just for retrieving data-need to go to the service
    public String editProject(@PathVariable("projectCode") String projectCode, Model model){//view and figure what we needed

        model.addAttribute("project", projectService.findById(projectCode));
        model.addAttribute("managers",userService.findManager());
        model.addAttribute("projects",projectService.findAll());

        return"/project/update";

    }
    @PostMapping("/update")//spring is binding @ModelAttribute-Automatically
    public String updateProject(@ModelAttribute("project") ProjectDTO project, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("managers", userService.findManager());
            model.addAttribute("projects", projectService.findAll());
            return "/project/update";
        }
        projectService.update(project);//terminology-service

        return"redirect:/project/create";
    }
    @GetMapping("/manager/project-status")// in left-side bar
    public String getProjectByManager(Model model){

        UserDTO manager=userService.findById("john@cydeo.com");//we don't have security mechanism yet that's why is hard coded

        List<ProjectDTO> projects=projectService.getCountedListOfProjectDTO(manager);//need different service for unfinished/finished object for manager

        model.addAttribute("projects", projects);
        return "/manager/project-status";

    }



}
