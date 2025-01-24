package org.example.productservice_proxy.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString

@Setter
@Getter
public class ProductDto {
    private String title;
    private double price;
    private String description;
    private String category;
    private String imageUrl;

}
