package org.example.demo.springsecurity.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String greet(HttpServletRequest request){
        return "Admin Access " +request.getUserPrincipal();
    }


    @GetMapping("/user")
    @PreAuthorize("hasAuthority('USER')")
    public String about(HttpServletRequest request){
        return "User Access " +request.getUserPrincipal();
    }
}
