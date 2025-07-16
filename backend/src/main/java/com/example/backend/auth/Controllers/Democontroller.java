package com.example.backend.auth.Controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class Democontroller {

    @GetMapping("/getcsrftoken")
    public CsrfToken getcsrftoken(HttpServletRequest httpServletRequest){
        return (CsrfToken) httpServletRequest.getAttribute("_csrf");
    }


    @PostMapping("/post")
    public String demopost(){
        return "demo post api is calling with token";
    }

}
