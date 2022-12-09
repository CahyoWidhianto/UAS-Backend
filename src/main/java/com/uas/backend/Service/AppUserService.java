package com.uas.backend.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.uas.backend.Model.Entities.AppUser;
import com.uas.backend.Model.Repository.AppUserRespository;
import com.uas.backend.Utils.EmailValidator;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class AppUserService implements UserDetailsService {


    private EmailValidator emailValidator;

    @Autowired
    private AppUserRespository appUserRespository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        
        return appUserRespository.findByEmail(email)
            .orElseThrow(()-> 
            new UsernameNotFoundException(
                String.format("user with email '%s' not found", email)));
    }
    
    public AppUser registerAppUser(AppUser user){

        boolean userExists = appUserRespository.findByEmail(user.getEmail()).isPresent();
        if(userExists){
            throw new RuntimeException(
                String.format("user with email '%s' already exists", user.getEmail()));
        }

        boolean isValidEmail= emailValidator.test(user.getEmail());
        if(!isValidEmail){
            throw new IllegalAccessError("email is not valid");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return appUserRespository.save(user);
    }
}
