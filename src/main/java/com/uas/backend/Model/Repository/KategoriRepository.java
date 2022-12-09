package com.uas.backend.Model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.repository.CrudRepository;

import com.uas.backend.Model.Entities.Kategori;

public interface KategoriRepository extends JpaRepository<Kategori, Long>{

   
    
}
