package com.cydeo.convertor;

import com.cydeo.dto.RoleDTO;
import com.cydeo.service.RoleService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component                    //challenge  that we faced
@ConfigurationPropertiesBinding //-spring is doing automatically for you
public class RoleDtoConvertor implements Converter<String, RoleDTO> { //functional converter interface generic //converted String (source)to RoleDTO
    RoleService roleService;//injections

    public RoleDtoConvertor(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override  //generic methode
    public RoleDTO convert(String source) {//"2" go to roleService

        return roleService.findById(Long.parseLong(source));//methode inside class -is going to give you long object instead of string
    }
}
