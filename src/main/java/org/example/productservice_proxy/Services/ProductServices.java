package org.example.productservice_proxy.Services;

import org.example.productservice_proxy.dto.ProductDto;
import org.example.productservice_proxy.models.Categories;
import org.example.productservice_proxy.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServices implements iProductServices {

    RestTemplateBuilder restTemplateBuilder;

    public ProductServices(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public List<Product> GetAllProduct() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductDto[]> productDto =
                restTemplate.getForEntity("https://fakestoreapi.com/products", ProductDto[].class);

        List<Product> products = new ArrayList<>();
        for (ProductDto productDto1 : productDto.getBody()) {
            products.add(getProduct(productDto1));
        }
        return products;
    }


    @Override
    public Product GetSingleProduct(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ProductDto productDto =
                restTemplate.getForEntity("https://fakestoreapi.com/products/{id}",
                        ProductDto.class, id).getBody();
        Product product = getProduct(productDto);
        return product;
    }

   @Override
    public Product AddNewProduct(ProductDto productDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
         restTemplate.postForEntity("https://fakestoreapi.com/products",
                productDto, ProductDto.class).getBody();
        Product product = getProduct(productDto);
        return product;

    }


    @Override
    public String UpdateProduct() {
        return null;
    }

    @Override
    public String DeleteProduct() {
        return null;
    }


    private Product getProduct(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        Categories category = new Categories();
        category.setName(productDto.getCategory());
        product.setCategory(category);
        product.setImage(productDto.getImage());
        product.setDescription(productDto.getDescription());
        return product;
    }

}
