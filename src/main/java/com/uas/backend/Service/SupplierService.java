package com.uas.backend.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uas.backend.Model.Entities.Supplier;
import com.uas.backend.Model.Repository.SupplierRepository;

@Service   
@Transactional
public class SupplierService {
    
    @Autowired
    private SupplierRepository supplierRepository;

    public Supplier save(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public Supplier byId(Long id){
        Optional<Supplier> supplier = supplierRepository.findById(id);
        if(!supplier.isPresent()){
            return null;
        }
        return supplier.get();
    }

    public Iterable<Supplier> GetAll(){
        return supplierRepository.findAll();
    }

    public Supplier delete(Long id){
        Supplier supplier = byId(id);
         supplierRepository.delete(supplier);
         return supplier;
         
    }

    public Supplier findByEmail(String email){
        return supplierRepository.findByEmail(email);
    }

    public List<Supplier> findByName(String name){
        return supplierRepository.findByNameContains(name);
    }
}
