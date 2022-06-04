package com.tms.webappshop.dto;

//import com.tms.webappshop.entity.Role;
import com.tms.webappshop.entity.RoleEnum;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private String email;

    private String password;

    private String phoneNumber;

    private String firstName;

    private String lastName;

    private RoleEnum role;
}
