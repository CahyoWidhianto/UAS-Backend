package com.uas.backend.Model.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.uas.backend.Model.Entities.Supplier;

public interface SupplierRepository extends CrudRepository<Supplier, Long> {

    Supplier findByEmail(String email);

    List<Supplier> findByNameContains(String name);
}
