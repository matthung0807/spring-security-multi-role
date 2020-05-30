package com.abc.demo3.controller;

import com.abc.demo3.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @RolesAllowed("ADMIN")
    @GetMapping("/all")
    public List<String> getAllUserName() {
       return userService.getAllUserNames();
    }

}
