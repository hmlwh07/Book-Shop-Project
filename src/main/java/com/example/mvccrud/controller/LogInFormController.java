package com.example.mvccrud.controller;

import com.example.mvccrud.entity.User;
import com.example.mvccrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LogInFormController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/login-error")
    public String loginError(Model model){
        model.addAttribute("loginError",true);
        return "login";
    }
    @GetMapping("/sign-up")
    public String signUp(Model model){
        model.addAttribute("user",new User());
        return "signup";
    }
    @PostMapping("/register")
    public String register(User user, BindingResult result){
        System.out.println("form------------------"+ user);
        userService.signUp(user);
        return "redirect:/login";
    }



}
