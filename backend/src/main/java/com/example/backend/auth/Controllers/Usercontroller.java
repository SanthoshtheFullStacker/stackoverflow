package com.example.backend.auth.Controllers;

import com.example.backend.auth.DTO.Request.UserrequestDTO;
import com.example.backend.auth.DTO.Response.ErrorresponseDTO;
import com.example.backend.auth.Service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class Usercontroller {

    @Autowired
    private Userservice userservice;


    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody UserrequestDTO userrequestDTO){
        try{

            return userservice.register(userrequestDTO);

        } catch (Exception e){

            return ResponseEntity.status(500).body(ErrorresponseDTO.Errorconsole(500,e+""));

        }

    }



    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UserrequestDTO userrequestDTO){
        try{

            return userservice.login(userrequestDTO);

        } catch (Exception e){

            return ResponseEntity.status(500).body(ErrorresponseDTO.Errorconsole(500,e+""));

        }
    }




}
