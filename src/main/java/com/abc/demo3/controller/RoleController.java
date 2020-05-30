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
@RequestMapping("/role")
public class RoleController {

    private final UserService userService;

    @RolesAllowed("HR_MANAGER")
    @GetMapping("/all")
    public List<String> getAllRoleNames() {
        return userService.getAllRoleNames();
    }

}
