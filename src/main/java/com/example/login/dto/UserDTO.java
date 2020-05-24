package com.example.login.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class UserDTO {

    @NotBlank(message = "login.blank.message")
    @Size(max = 20, min = 3, message = "login.length.message")
    @Pattern(regexp = "^[\\sa-zA-Z0-9_]*$", message = "{register.invalid.login}")
    private String login;

    @NotBlank(message = "password.blank.message")
    @Size(max = 100, min = 5, message = "password.length.message")
    private String password;
    private String confirmPassword;
}
