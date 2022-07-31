package com.tms.webappshop.dto;

import com.tms.webappshop.entity.RoleEnum;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private Integer id;

    @NotEmpty(message = "Email should not be empty")
    @Size(min = 4, max = 30, message = "Email should be between 5 and 30 characters")
    private String email;

    @NotEmpty(message = "Password should not be empty")
    @Size(min = 5, max = 30, message = "Password should be between 5 and 30 characters")
    private String password;

    @NotEmpty(message = "Phone number should not be empty")
    @Size(min = 12, max = 12, message = "Enter correct phone number. Example: 375291234567")
    private String phoneNumber;

    @NotEmpty(message = "First name should not be empty")
    @Size(min = 2, max = 30, message = "First name should be between 2 and 30 characters")
    private String firstName;

    @NotEmpty(message = "Last name should not be empty")
    @Size(min = 2, max = 30, message = "Last name should be between 2 and 30 characters")
    private String lastName;

    private RoleEnum role;
}
