package com.uas.backend.Controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uas.backend.Dto.AppUserData;
import com.uas.backend.Dto.ResponseData;
import com.uas.backend.Model.Entities.AppUser;
import com.uas.backend.Service.AppUserService;

@RestController
@RequestMapping("/api/users")
public class AppUserControlle {
    
    @Autowired
    private AppUserService appUserService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/signup")
    public ResponseEntity<ResponseData<AppUser>> register(@RequestBody AppUserData userData){
        
        ResponseData<AppUser> response = new ResponseData<>();
        AppUser appUser = modelMapper.map(userData, AppUser.class);

        response.setPayload(appUserService.registerAppUser(appUser));
        response.setStatus(true);
        response.getMassages().add("AppUser Saved!");
        return ResponseEntity.ok(response);
    }
}
