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

    @RolesAllowed("HR_MANAGER")
    @GetMapping("/all")
    public List<String> getAllUserNames() {
       return userService.getAllUserNames();
    }

}
