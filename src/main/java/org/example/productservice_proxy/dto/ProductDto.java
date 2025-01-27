package org.example.productservice_proxy.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.productservice_proxy.models.Categories;


@Setter
@Getter
@ToString
public class ProductDto {
    private Long id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
    private RatingDto rating;
    private Categories categories;

}
