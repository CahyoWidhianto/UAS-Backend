package com.uas.backend.Controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uas.backend.Dto.ResponseData;
import com.uas.backend.Dto.SearchData;
import com.uas.backend.Dto.SupplierData;
import com.uas.backend.Model.Entities.Supplier;
import com.uas.backend.Service.SupplierService;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {
    
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private SupplierService supplierService;

    @PostMapping
    public ResponseEntity<ResponseData<Supplier>> create(@Valid @RequestBody SupplierData supplierData, Errors errors) {

        ResponseData<Supplier> responseData = new ResponseData<>();

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMassages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        Supplier supplier = modelMapper.map(supplierData, Supplier.class);

        responseData.setStatus(true);
        responseData.setPayload(supplierService.save(supplier));
        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    public Iterable<Supplier> getAll(){
        return supplierService.GetAll();
    }

    @GetMapping("/{id}")
    public Supplier byId(@PathVariable("id") Long id){
        return supplierService.byId(id);
    }

    @PutMapping
    public ResponseEntity<ResponseData<Supplier>> update(@Valid @RequestBody SupplierData supplierData, Errors errors) {

        ResponseData<Supplier> responseData = new ResponseData<>();

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMassages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        Supplier supplier = modelMapper.map(supplierData, Supplier.class);

        responseData.setStatus(true);
        responseData.setPayload(supplierService.save(supplier));
        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping("/{id}")
    public Supplier delete(@PathVariable Long id) {
        return supplierService.delete(id);
    }

    @PostMapping("/search/byemail")
    public Supplier findByEmail(@RequestBody SearchData searchData){
        return supplierService.findByEmail(searchData.getSearchKey());
    }

    @PostMapping("/search/byname")
    public List<Supplier> findByName(@RequestBody SearchData searchData){
        return supplierService.findByName(searchData.getSearchKey());
    }
    

}
