package com.uas.backend.Controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uas.backend.Dto.KategoriData;
import com.uas.backend.Dto.ResponseData;
import com.uas.backend.Model.Entities.Kategori;
import com.uas.backend.Service.KategoriService;

@RestController
@RequestMapping("/api/kategori")
public class KategoriController {
    @Autowired
    private ModelMapper modelmapper;
    
    @Autowired
    private KategoriService kategoriService;

    @PostMapping
    public ResponseEntity<ResponseData<Kategori>> create(@Valid @RequestBody KategoriData kategoriData, Errors errors) {

        ResponseData<Kategori> responseData = new ResponseData<>();

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMassages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        Kategori kategori = modelmapper.map(kategoriData, Kategori.class);
        responseData.setStatus(true);
        responseData.setPayload(kategoriService.save(kategori));
        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    public Iterable<Kategori> getAll(){
        return kategoriService.GetAll();
    }

    @GetMapping("/{id}")
    public Kategori byId(@PathVariable("id") Long id){
        return kategoriService.byId(id);
    }

    @PutMapping
    public ResponseEntity<ResponseData<Kategori>> update(@Valid @RequestBody KategoriData kategoriData, Errors errors) {

        ResponseData<Kategori> responseData = new ResponseData<>();

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMassages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        Kategori kategori = modelmapper.map(kategoriData, Kategori.class);
        responseData.setStatus(true);
        responseData.setPayload(kategoriService.save(kategori));
        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping("/{id}")
    public Kategori delete(@PathVariable Long id) {
        return kategoriService.delete(id);
    }

    // @PostMapping("/search/{size}/{page}")
    // public Iterable<Kategori> findByName(@RequestBody SearchData searchData){
    //     return kategoriService.GetAll();
    // }
}
