package com.uas.backend.Model.Entities;


import java.util.Collection;
import java.util.Collections;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name ="tb_users")
public class AppUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 150, nullable = false)
    private String fullName;
    @Column(length = 150, nullable = false,  unique = true)
    private String email;
    @Column(length = 200, nullable = false)
    private String password;
    @Enumerated((EnumType.STRING))
    private AppUserRole appUserRole;

    private boolean locked;
    private boolean enabled;


    
    public AppUser(String fullName, String email, String password, AppUserRole appUserRole, boolean locked,
            boolean enabled) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.appUserRole = appUserRole;
        this.locked = locked;
        this.enabled = enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(appUserRole.name());
        return Collections.singletonList(authority);

    }

    @Override
    public String getPassword() {
       return password;
    }

    @Override
    public String getUsername() {
       return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }



    // public Long getId() {
    //     return id;
    // }

    // public void setId(Long id) {
    //     this.id = id;
    // }

    // public String getFullName() {
    //     return fullName;
    // }

    // public void setFullName(String fullName) {
    //     this.fullName = fullName;
    // }

    // public String getEmail() {
    //     return email;
    // }

    // public void setEmail(String email) {
    //     this.email = email;
    // }

    // public void setPassword(String password) {
    //     this.password = password;
    // }

    // public AppUserRole getAppUserRole() {
    //     return appUserRole;
    // }

    // public void setAppUserRole(AppUserRole appUserRole) {
    //     this.appUserRole = appUserRole;
    // }



    
    
}
