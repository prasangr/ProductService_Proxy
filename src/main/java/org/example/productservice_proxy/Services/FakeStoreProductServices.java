package org.example.productservice_proxy.Services;

import org.example.productservice_proxy.client.IClientProductDto;
import org.example.productservice_proxy.client.fakestore.dto.FakeStoreProductDto;
import org.example.productservice_proxy.dto.ProductDto;
import org.example.productservice_proxy.models.Categories;
import org.example.productservice_proxy.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductServices implements iProductServices {

    RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductServices(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public List<Product> GetAllProduct() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductDto[]> productDtos =
                restTemplate.getForEntity("https://fakestoreapi.com/products", ProductDto[].class);

        List<Product> answers = new ArrayList<>();

        for (ProductDto productDto : productDtos.getBody()) {
           Product product =new Product();
              product.setId(productDto.getId());
                product.setTitle(productDto.getTitle());
                product.setPrice(productDto.getPrice());
                Categories category = new Categories();
                category.setName(productDto.getCategory());
                product.setCategory(category);
                product.setImage(productDto.getImage());
                answers.add(product);
        }
        return answers;
    }


    @Override
    public Product GetSingleProduct(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> productDto =
                restTemplate.getForEntity("https://fakestoreapi.com/products/{id}",
                        FakeStoreProductDto.class, id);
        Product product = getProduct(productDto.getBody());
        return product;
    }

    @Override
    public Product AddNewProduct(IClientProductDto productDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.postForEntity("https://fakestoreapi.com/products",productDto, ProductDto.class);
        Product product = getProduct((FakeStoreProductDto) productDto);
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


    private Product getProduct(FakeStoreProductDto productDto) {
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
