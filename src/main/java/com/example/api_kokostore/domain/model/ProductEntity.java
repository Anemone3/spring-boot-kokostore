package com.example.api_kokostore.domain.model;


import com.example.api_kokostore.shared.SlugGenerate;
import jakarta.persistence.*;


@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(unique = true,nullable = false)
    private String sku;

    @Column(unique = true,nullable = false)
    private String slug;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String image;

    @ManyToOne
    @JoinColumn(name = "category_id",nullable = false)
    private CategoriesEntity category;

    @PrePersist
    @PreUpdate
    public void generateSlug(){
        if(this.slug == null || this.slug.isEmpty()){
            this.slug = SlugGenerate.toSlug(this.name);
        }
    }

    public ProductEntity() {}

    public ProductEntity(String sku, String slug, String name, double price, String description, String image, CategoriesEntity category) {
        this.sku = sku;
        this.slug = slug;
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public CategoriesEntity getCategory() {
        return category;
    }

    public void setCategory(CategoriesEntity category) {
        this.category = category;
    }
}
