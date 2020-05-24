package com.example.login.controller;

import com.example.login.dto.UserDTO;
import com.example.login.service.UserService;
import com.example.login.utils.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private UserService userService;

    @GetMapping("/site/")
    public String root() {
        return "index";
    }

    @GetMapping(value = "/register")
    public String showRegisterForm(Model model, UserDTO userDTO) {
        model.addAttribute("userDTO", userDTO);
        return "register";
    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping(value = "/register")
    public String register(Model model, @Valid UserDTO userDTO, BindingResult bindingResult) {
        String errMsg;
        if(bindingResult.hasFieldErrors("login")) {
            errMsg = bindingResult.getFieldError("login").getDefaultMessage();
            bindingResult.rejectValue("login", errMsg);
            return "register";
        }
        if(bindingResult.hasFieldErrors("password")) {
            errMsg = bindingResult.getFieldError("password").getDefaultMessage();
            bindingResult.rejectValue("password", errMsg);
            return "register";
        }
        if(!userDTO.getConfirmPassword().equals(userDTO.getPassword())) {
            bindingResult.rejectValue("confirmPassword", "register.confirmPassword.fail");
            return "register";
        }
        userService.save(userDTO);
        model.addAttribute("message", Common.getMessage("user.register.success", LocaleContextHolder.getLocale(), messageSource));
        return "register";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "/access-denied";
    }
}
