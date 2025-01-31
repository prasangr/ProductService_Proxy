package org.example.productservice_proxy.client.fakestore.client;

import org.example.productservice_proxy.client.IClientProductDto;
import org.example.productservice_proxy.client.fakestore.dto.FakeStoreProductDto;
import org.example.productservice_proxy.dto.ProductDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class FakeStoreClient {

    private RestTemplateBuilder restTemplateBuilder;
    FakeStoreClient(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public List<FakeStoreProductDto> getAllProducts(){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> productDtos =
                restTemplate.getForEntity("https://fakestoreapi.com/products", FakeStoreProductDto[].class);
        return Arrays.asList(productDtos.getBody());
    }

    public FakeStoreProductDto getSingleProduct(Long id){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> productDto =
                restTemplate.getForEntity("https://fakestoreapi.com/products/{id}",
                        FakeStoreProductDto.class, id);
        return productDto.getBody();
    }

    public FakeStoreProductDto addNewProduct(IClientProductDto productDto){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> productDtoResponseEntity =
                restTemplate.postForEntity("https://fakestoreapi.com/products", productDto, FakeStoreProductDto.class);
        return productDtoResponseEntity.getBody();
    }






}
