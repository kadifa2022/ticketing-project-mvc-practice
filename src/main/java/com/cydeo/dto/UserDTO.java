package com.cydeo.dto;

import com.cydeo.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {//limitation

    private String firstName;
    private String lastName;
    private String userName;
    //@NotBlank
   // @Pattern(regexp = "(?=.\\d)(?=.[a-z])(?=.*[A-Z]).{4,}")
    private String passWord;
    private boolean enabled;
   // @NotBlank
  // @Pattern(regexp = "^\\d{10}$")
    private String phone;
    private RoleDTO role;//roleDTO object -WE use convertor to  convert String to role object
    private Gender gender;//enm

}
