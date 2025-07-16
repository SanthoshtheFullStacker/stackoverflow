package com.example.backend.auth.Serviceimpl;

import com.example.backend.auth.DTO.Request.UserrequestDTO;
import com.example.backend.auth.DTO.Response.ErrorresponseDTO;
import com.example.backend.auth.DTO.Response.SuccessresponseDTO;
import com.example.backend.auth.Models.Usermodel;
import com.example.backend.auth.Repositorys.Userrepository;
import com.example.backend.auth.Service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Userserviceimpl implements Userservice {

    @Autowired
    private Userrepository userrepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTserviceimpl jwTserviceimpl;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    @Override
    public ResponseEntity<Object> register(UserrequestDTO userrequestDTO) {
        try{

            Usermodel exisitinguserdata = userrepository.findByUsername(userrequestDTO.getUsername());

            if(exisitinguserdata != null){
                return ResponseEntity.status(400).body(ErrorresponseDTO.Errorconsole(400,"user already available"));
            }

            Usermodel usermodel = new Usermodel(userrequestDTO.getUsername(), userrequestDTO.getEmail(), userrequestDTO.getPassword(), userrequestDTO.getDisplayname(), userrequestDTO.getProfileimageurl(), userrequestDTO.getBio());

            usermodel.setPassword(bCryptPasswordEncoder.encode(usermodel.getPassword()));
            Usermodel savedData = userrepository.save(usermodel);

            return ResponseEntity.status(200).body(SuccessresponseDTO.successconsole(savedData,200,"users saved successfully"));

        } catch (Exception e){

            return ResponseEntity.status(500).body(ErrorresponseDTO.Errorconsole(500,e+""));

        }
    }

    @Override
    public ResponseEntity<Object> login(UserrequestDTO userrequestDTO) {
        try{

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userrequestDTO.getUsername(),userrequestDTO.getPassword())
            );

            if(authentication.isAuthenticated()){

               String token = jwTserviceimpl.generateToken(userrepository.findByUsername(userrequestDTO.getUsername()));

                Map<String, String> responsedata = new HashMap<>();

                responsedata.put("token",token);

                return ResponseEntity.status(200).body(SuccessresponseDTO.successconsole(responsedata,200,"logged in successfully"));

            }

            return ResponseEntity.status(400).body(ErrorresponseDTO.Errorconsole(400,"invalid credentials"));

        } catch (Exception e){

            return ResponseEntity.status(500).body(ErrorresponseDTO.Errorconsole(500,e+""));

        }
    }

}
