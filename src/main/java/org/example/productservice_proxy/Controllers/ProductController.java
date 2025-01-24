package org.example.productservice_proxy.Controllers;


import org.example.productservice_proxy.dto.ProductDto;
import org.example.productservice_proxy.models.Product;
import org.springframework.web.bind.annotation.*;


//This controller is used to handle all the requests related to the product
@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/{id}")
    public String getSingleProduct(@PathVariable("id") Long id) {
        return "Single product with product id: " + id;
    }

    @GetMapping("/")
    public String getAllProducts() {
        return "All products";
    }


    @PostMapping()
    public String addNewProduct(@RequestBody ProductDto product) {}

}
