package com.abc.demo3.controller;

import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/action")
public class ActionController {

    @RolesAllowed({"HR_MANAGER", "HR_STAFF", "PRODUCT_MANAGER"})
    @GetMapping("/user/get")
    public String getUser() {
        String message = "get user";
        System.out.println(message);
        return message;
    }

    @RolesAllowed({"HR_MANAGER"})
    @PostMapping("/user/add")
    public String addUser() {
        String message = "add user";
        System.out.println(message);
        return message;
    }

    @RolesAllowed({"HR_MANAGER", "HR_STAFF"})
    @PatchMapping("/user/update")
    public String updateUser() {
        String message = "update user";
        System.out.println(message);
        return message;
    }

    @RolesAllowed({"HR_MANAGER"})
    @DeleteMapping("/user/delete")
    public String deleteUser() {
        String message = "delete user";
        System.out.println(message);
        return message;
    }

    @RolesAllowed({"PRODUCT_MANAGER", "PRODUCT_STAFF"})
    @GetMapping("/product/get")
    public String getProduct() {
        String message = "get product";
        System.out.println(message);
        return message;
    }

    @RolesAllowed({"PRODUCT_MANAGER"})
    @PostMapping("/product/add")
    public String addProduct() {
        String message = "add product";
        System.out.println(message);
        return message;
    }

    @RolesAllowed({"PRODUCT_MANAGER", "PRODUCT_STAFF"})
    @PostMapping("/product/update")
    public String updateProduct() {
        String message = "update product";
        System.out.println(message);
        return message;
    }

    @RolesAllowed({"PRODUCT_MANAGER"})
    @PostMapping("/product/delete")
    public String deleteProduct() {
        String message = "delete product";
        System.out.println(message);
        return message;
    }

}
