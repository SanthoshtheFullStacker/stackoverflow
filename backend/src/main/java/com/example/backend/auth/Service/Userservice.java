package com.example.backend.auth.Service;

import com.example.backend.auth.DTO.Request.UserrequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface Userservice {
    ResponseEntity<Object> register(UserrequestDTO userrequestDTO);

    ResponseEntity<Object> login(UserrequestDTO userrequestDTO);
}
