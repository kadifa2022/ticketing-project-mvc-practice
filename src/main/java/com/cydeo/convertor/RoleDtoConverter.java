package com.cydeo.convertor;

import com.cydeo.dto.RoleDTO;
import com.cydeo.service.RoleService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component                    //challenge  that we faced
@ConfigurationPropertiesBinding //methode get executed-spring is doing automatically for you
public class RoleDtoConverter implements Converter<String, RoleDTO> { //functional converter interface generic (java-spring) //converted String (source)to RoleDTO
    RoleService roleService;//get from database RoleService-and then injections

    public RoleDtoConverter(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override  //generic methode
    public RoleDTO convert(String source) {//"2" go to roleService
                  //go to database and findById
        return roleService.findById(Long.parseLong(source));  //methode inside class -is going to give you long object instead of string
    }
}
