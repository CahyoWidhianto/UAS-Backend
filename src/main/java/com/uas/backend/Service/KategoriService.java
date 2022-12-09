package com.uas.backend.Service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uas.backend.Model.Entities.Kategori;
import com.uas.backend.Model.Repository.KategoriRepository;

@Service
@Transactional
public class KategoriService {
    
    @Autowired
    private KategoriRepository kategoriRepository;

    public Kategori save(Kategori kategori){
        if(kategori.getId()!=null){
            Kategori currentKategori = kategoriRepository.findById(kategori.getId()).get();
            currentKategori.setName(kategori.getName());
            kategori = currentKategori;
        }
       return kategoriRepository.save(kategori);
    }

    public Kategori byId(Long id){
        Optional<Kategori> kategori = kategoriRepository.findById(id);
        if(!kategori.isPresent()){
            return null;
        }
        return kategori.get();
    }

    public Iterable<Kategori> GetAll(){
        return kategoriRepository.findAll();
    }

    public Kategori delete(Long id){
        Kategori kategori = byId(id);
         kategoriRepository.delete(kategori);
         return kategori;
         
    }

    // public Iterable<Kategori> findByName(String name, Pageable pageable){
    //     return kategoriRepository.findByNameContains(name, pageable);
    // }
}
