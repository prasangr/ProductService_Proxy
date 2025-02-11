package org.example.productservice_proxy.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@ToString
@Entity
public class Product extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private double price;
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private Categories category;

    private String imageUrl;
    private Boolean isPublic;
}
