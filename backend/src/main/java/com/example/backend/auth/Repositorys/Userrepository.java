package com.example.backend.auth.Repositorys;

import com.example.backend.auth.Models.Usermodel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Userrepository extends JpaRepository<Usermodel , Long> {

    Usermodel findByUsername(String Username);

}
