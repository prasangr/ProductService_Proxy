package org.example.productservice_proxy.Controllers;


import org.example.productservice_proxy.Services.iProductServices;
import org.example.productservice_proxy.client.IClientProductDto;
import org.example.productservice_proxy.dto.ProductDto;
import org.example.productservice_proxy.models.Categories;
import org.example.productservice_proxy.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    iProductServices productServices;

    // GET , Url : /products/                   getAllProducts
    @GetMapping("/")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = this.productServices.GetAllProduct();
        return ResponseEntity.ok(products);
    }

    // GET , Url : /products/{id}               getSingleProduct
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

    //POST , Url : /products/    // for fakestoreproductServices
    /*@PostMapping()
    public ResponseEntity<Product> addNewProduct(@RequestBody IClientProductDto productDto) {
        Product product = this.productServices.AddNewProduct(productDto);
        ResponseEntity<Product> responseEntity = new ResponseEntity<>(product, HttpStatus.OK);

        return responseEntity;
    }*/

    // GET , Url : /products?limit={limit}    getProductByLimit
    @GetMapping(params = "limit")
    public ResponseEntity<List<Product>> getProductByLimit(@RequestParam("limit") int limit) {
        List<Product> products = this.productServices.GetProductByLimit(limit);
        return ResponseEntity.ok(products);
    }

    // GET , Url : /products?sort=desc    getAllProductsInDescOrder
    @GetMapping(params = "sort")
    public ResponseEntity<List<Product>> getAllProductsSorted(@RequestParam("sort") String sort) {
        if ("desc".equalsIgnoreCase(sort)) {
            List<Product> products = this.productServices.GetAllProductsInDescOrder();
            return ResponseEntity.ok(products);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    //POST , Url : /products/              addNewProduct
    @PostMapping("/")
    public ResponseEntity<Product> addNewProduct(@RequestBody ProductDto productDto) {
        Product product = getProduct(productDto);
        Product product1 = this.productServices.AddNewProduct(product);
        ResponseEntity<Product> responseEntity = new ResponseEntity<>(product1, HttpStatus.OK);

        return responseEntity;
    }

    //PUT , Url : /products/{productId}
    @PutMapping("/{productId}")
    public Product updateProduct(@PathVariable("productId") Long productId, @RequestBody ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setCategory(new Categories());
        product.getCategory().setName(productDto.getCategory());
        return this.productServices.UpdateProduct( product);

    }

    //DELETE , Url : /products/{productId}
    @DeleteMapping("/{productId}")
    public Product deleteProduct(@PathVariable("productId") Long productId) {
        return this.productServices.DeleteProduct(productId);
    }

    public Product getProduct(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setCategory(new Categories());
        product.getCategory().setName(productDto.getCategory());
        product.setImageUrl(productDto.getImage());
        return product;
    }
}
