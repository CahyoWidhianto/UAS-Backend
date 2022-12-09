package com.uas.backend.Utils;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import com.uas.backend.Model.Entities.AppUser;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        AppUser currenUser = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return Optional.of(currenUser.getEmail());
    }
    
}
