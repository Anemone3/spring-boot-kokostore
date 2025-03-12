package com.example.api_kokostore.domain.model;

import com.example.api_kokostore.shared.SlugGenerate;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categories")
public class CategoriesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true,nullable = false)
    private String name;

    @Column(unique = true,nullable = false)
    private String slug;


    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    private List<ProductEntity> products;

    public CategoriesEntity() {}

    public CategoriesEntity(String name, String slug) {
        this.name = name;
        this.slug = slug;
    }

    @PrePersist
    @PreUpdate
    public void generateSlug(){
        if (this.name != null && (this.slug == null || this.slug.isEmpty())) {
            this.slug = SlugGenerate.toSlug(this.name);
        }
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

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
}
