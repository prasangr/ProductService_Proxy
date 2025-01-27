package org.example.productservice_proxy.Services;

import org.example.productservice_proxy.dto.ProductDto;
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
public String GetSingleProduct(Long id){
    RestTemplate restTemplate = restTemplateBuilder.build();
    ProductDto productDto = restTemplate.getForEntity("http://fakestoreapi.com/products/{id}", ProductDto.class, id).getBody();
    return productDto != null ? productDto.toString() : "Product not found";
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
