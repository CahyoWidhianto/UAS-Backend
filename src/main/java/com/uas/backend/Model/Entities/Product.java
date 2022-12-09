package com.uas.backend.Model.Entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

// import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
// import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "tb_products")
// @JsonIdentityInfo(
//     generator = ObjectIdGenerators.PropertyGenerator.class,
//     property = "id"
// )
public class Product implements Serializable {

    // private static final long serialVersionUID = 1L;
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "name is required")
    @Column(name="product", length = 100)
    private String name;

    @NotEmpty(message = "deskription is required")
    @Column(name="deskripsi", length =500)
    private String description;

    private double price;

    @ManyToOne
    private Kategori kategori;

    @ManyToMany
    @JoinTable(name = "tb_products_supplier", 
    joinColumns = @JoinColumn(name ="product_id"),
    inverseJoinColumns = @JoinColumn(name="supplier_id"))
    @JsonManagedReference
    private Set<Supplier> supplier;

    public Product() {
    } 

    public Product(long id, String name, String description, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

    public Set<Supplier> getSupplier() {
        return supplier;
    }

    public void setSupplier(Set<Supplier> supplier) {
        this.supplier = supplier;
    }

    

}
