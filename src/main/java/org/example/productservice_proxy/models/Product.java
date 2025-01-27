package org.example.productservice_proxy.models;


import lombok.*;

@Getter
@Setter
@ToString
public class Product extends BaseModel{
    private String title;
    private double price;
    private String description;
   // private Categories category;
    private String image;
}
