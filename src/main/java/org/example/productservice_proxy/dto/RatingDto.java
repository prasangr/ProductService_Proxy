package org.example.productservice_proxy.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class RatingDto {


    private double rate;
    private double count;
}
