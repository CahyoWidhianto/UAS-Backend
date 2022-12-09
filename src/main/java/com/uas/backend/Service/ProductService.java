package com.uas.backend.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import java.lang.RuntimeException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uas.backend.Model.Entities.Product;
import com.uas.backend.Model.Entities.Supplier;
import com.uas.backend.Model.Repository.ProductRepository;


@Service
@Transactional
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SupplierService supplierService;

    public Product save(Product product){
        return productRepository.save(product);
    }

    public Product Byid(Long id){
        Optional<Product> product = productRepository.findById(id);
        if(!product.isPresent()){
            return null;
        }
        return product.get();

        // return productRepository
        //         .findById(id)
        //         .orElseThrow(()
        //                 -> new ResponseStatusException
        //                 (HttpStatus.NOT_FOUND, "Product not found")
        //         );
           
    }

    public Iterable<Product> GetAll(){
        return productRepository.findAll();
    }

    public Product delete(Long id){
        Product product = Byid(id);
         productRepository.delete(product);
         return product;
         
    }


    public void addSupplier(Supplier supplier, Long productId){
        Product product = Byid(productId);
        if(product == null){
            throw new  RuntimeException("Product with id " 
            + productId + "NOT_FOUND");
        }

        product.getSupplier().add(supplier);
        save(product);
    }

    public List<Product> findByProductName(String name) {
        return productRepository.findByName("%"+name+"%");
    }

    public List<Product> findByKategori(Long kategoriId) {
        return productRepository.findByKategori(kategoriId);
    }


    public List<Product> findBySupplier(Long supplierId) {
        Supplier supplier = supplierService.byId(supplierId);
        if(supplier == null) {
            return new ArrayList<Product>();
        }
        return productRepository.findBySupplier(supplier);
    }
}
