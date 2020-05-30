package com.abc.demo3.controller;

import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/action")
public class ActionController {

    @RolesAllowed({"STAFF", "OFFICER", "ADMIN"})
    @GetMapping("/get")
    public String get() {
        String message = "get";
        System.out.println(message);
        return message;
    }

    @RolesAllowed({"OFFICER", "ADMIN"})
    @PostMapping("/add")
    public String add() {
        String message = "add";
        System.out.println(message);
        return message;
    }

    @RolesAllowed({"OFFICER", "ADMIN"})
    @PatchMapping("/update")
    public String update() {
        String message = "update";
        System.out.println(message);
        return message;
    }

    @RolesAllowed({"ADMIN"})
    @DeleteMapping("/delete")
    public String delete() {
        String message = "delete";
        System.out.println(message);
        return message;
    }

}
