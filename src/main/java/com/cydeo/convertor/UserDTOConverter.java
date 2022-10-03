package com.cydeo.convertor;


import com.cydeo.dto.UserDTO;
import com.cydeo.service.UserService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component//if any class has a relationship we need @component
@ConfigurationPropertiesBinding//spring boot is providing for us automatically//we don't put it
public class UserDTOConverter implements Converter<String, UserDTO> {

    UserService userService;//injected

    public UserDTOConverter(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDTO convert(String source) {
        return userService.findById(source);
    }
}
