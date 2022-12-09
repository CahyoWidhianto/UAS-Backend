package com.uas.backend.Model.Repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.uas.backend.Model.Entities.AppUser;

public interface AppUserRespository extends PagingAndSortingRepository<AppUser, Long>{
    Optional<AppUser> findByEmail(String email);
}
