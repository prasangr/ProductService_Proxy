package org.example.productservice_proxy.models;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;


@Getter
@Setter
@ToString
@Entity
public class Product extends BaseModel{

    private String title;
    private double price;
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)
    private Categories category;
    private String imageUrl;
}
