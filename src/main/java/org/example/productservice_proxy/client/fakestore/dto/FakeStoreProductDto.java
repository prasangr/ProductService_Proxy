package org.example.productservice_proxy.client.fakestore.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.productservice_proxy.client.IClientProductDto;
import org.example.productservice_proxy.dto.RatingDto;


@Getter
@Setter
@ToString
public class FakeStoreProductDto implements IClientProductDto {

    private Long id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
    private RatingDto rating;

}
