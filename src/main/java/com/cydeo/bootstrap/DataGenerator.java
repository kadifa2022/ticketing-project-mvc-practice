package com.cydeo.bootstrap;

import com.cydeo.dto.RoleDTO;
import org.springframework.boot.CommandLineRunner;

public class DataGenerator implements CommandLineRunner {//functional interface provided by spring

    @Override
    public void run(String... args) throws Exception {//firs this methode is executed before anything when you starts application else like static block


        //create some roles and put in DB(Map)
        RoleDTO adminRole= new RoleDTO(1L, "Admin");
        RoleDTO managerRole= new RoleDTO(2L, "Manager");
        RoleDTO employeeRole= new RoleDTO(3L, "Employee");



    }
}
