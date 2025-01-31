package org.example.productservice_proxy.Controllers;


import org.example.productservice_proxy.Services.iProductServices;
import org.example.productservice_proxy.client.IClientProductDto;
import org.example.productservice_proxy.dto.ProductDto;
import org.example.productservice_proxy.models.Categories;
import org.example.productservice_proxy.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//This controller is used to handle all the requests related to the product
@RestController
@RequestMapping("/products")
public class ProductController {
    iProductServices productServices;

    public ProductController(iProductServices productServices) {

        this.productServices = productServices;
    }

    // GET , Url : /products/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long id) {

        try {
            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
            headers.add("auth-token", "helloaccess ");
            headers.add("Accept", "application/json");
            headers.add("Content-Type", "application/json");

            Product product = this.productServices.GetSingleProduct(id);
            if (id < 1) {
                throw new IllegalAccessException("Invalid id");
            }

            ResponseEntity<Product> responseEntity = ResponseEntity.ok(product);
            return responseEntity;

        } catch (IllegalAccessException e) {
            ResponseEntity<Product> responseEntity = ResponseEntity.badRequest().build();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    // GET , Url : /products/
    @GetMapping("/")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = this.productServices.GetAllProduct();
        return ResponseEntity.ok(products);
    }

    //POST , Url : /products/
    @PostMapping()
    public ResponseEntity<Product> addNewProduct(@RequestBody IClientProductDto productDto) {
        Product product = this.productServices.AddNewProduct(productDto);
        ResponseEntity<Product> responseEntity = new ResponseEntity<>(product, HttpStatus.OK);

        return responseEntity;
    }

    //PUT , Url : /products/{productId}
    @PatchMapping("/{productId}")
    public Product updateProduct(@PathVariable("productId") Long productId, @RequestBody ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setCategory(new Categories());
        product.getCategory().setName(productDto.getCategory());
        return this.productServices.UpdateProduct(productId, product);

    }

    //DELETE , Url : /products/{productId}
    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId) {
        return this.productServices.DeleteProduct(productId);
    }
}
