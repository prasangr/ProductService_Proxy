package org.example.productservice_proxy.Services;

import org.example.productservice_proxy.dto.ProductDto;
import org.example.productservice_proxy.models.Categories;
import org.example.productservice_proxy.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductServices implements iProductServices {

    RestTemplateBuilder restTemplateBuilder;
    public ProductServices(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }

@Override
public String GetAllProduct(){
    return null;
}
@Override
public Product GetSingleProduct(Long id){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ProductDto productDto =
                restTemplate.getForEntity("https://fakestoreapi.com/products/{id}",
                        ProductDto.class, id).getBody();
        Product product = getProduct(productDto);
        return product;
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


    @Override
public String AddNewProduct(){
    return null;
}

@Override
public String UpdateProduct(){
    return null;
}
@Override
public String DeleteProduct(){
    return null;
}


}
