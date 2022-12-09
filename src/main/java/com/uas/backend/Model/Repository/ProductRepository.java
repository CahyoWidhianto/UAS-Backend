package com.uas.backend.Model.Repository;



import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.uas.backend.Model.Entities.Product;
import com.uas.backend.Model.Entities.Supplier;



public interface ProductRepository extends CrudRepository<Product, Long> {
    

    @Query("SELECT p FROM Product p WHERE p.name LIKE :name")
    public List<Product> findByName(@PathParam("name") String name);

    @Query("SELECT p FROM Product p WHERE p.kategori.id = :kategoriId")
    public List<Product> findByKategori(@PathParam("kategoriId")Long kategoriId);
    
    @Query("SELECT p FROM Product p WHERE :supplier MEMBER OF p.supplier")
    public List<Product> findBySupplier(@PathParam("")Supplier supplier);
}
