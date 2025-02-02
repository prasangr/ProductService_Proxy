package org.example.productservice_proxy.Controllers;


import org.example.productservice_proxy.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/products/categories")
public class CategoryController {

    RestTemplateBuilder restTemplateBuilder;
    public CategoryController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }




    @GetMapping("")
    public ResponseEntity<List<String>> getAllCategories() {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<String> productDtos =
                restTemplate.getForEntity("https://fakestoreapi.com/products/category/{categoryId}", String.class);
    return (ResponseEntity<List<String>>) Arrays.asList(productDtos.getBody());
}



    @GetMapping("/{categoryId}")
    public ResponseEntity<List<String>> getProductsinCategory(@PathVariable("categoryId") String categoryId) {
        return null;
    }


}
