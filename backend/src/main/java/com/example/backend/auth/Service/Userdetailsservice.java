package com.example.backend.auth.Service;

import com.example.backend.auth.Models.Userdetails;
import com.example.backend.auth.Models.Usermodel;
import com.example.backend.auth.Repositorys.Userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class Userdetailsservice implements UserDetailsService {

    @Autowired
    private Userrepository userrepository;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usermodel users = userrepository.findByUsername(username);

        if(users != null){

           return new Userdetails(users);

        }

        throw new UsernameNotFoundException("username not found");

    }

}
