package com.cos.blogv2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    private static final String VIEWS_USER_CREATE_OR_UPDATE_FROM = "user/createOrUpdateUserForm";
    private static final String VIEWS_USER_LOGIN_FROM = "user/loginUserForm";

    @GetMapping("/user/createUserForm")
    public String joinForm() {
        return VIEWS_USER_CREATE_OR_UPDATE_FROM;
    }

    @GetMapping("/user/UpdateUserForm")
    public String updateForm() {
        return VIEWS_USER_CREATE_OR_UPDATE_FROM;
    }

    @GetMapping("/user/loginUserForm")
    public String loginForm() {
        return VIEWS_USER_LOGIN_FROM;
    }
}
