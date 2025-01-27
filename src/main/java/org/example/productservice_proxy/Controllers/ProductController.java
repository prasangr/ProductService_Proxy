package org.example.productservice_proxy.Controllers;


import org.example.productservice_proxy.Services.iProductServices;
import org.example.productservice_proxy.dto.ProductDto;
import org.example.productservice_proxy.models.Product;
import org.springframework.web.bind.annotation.*;


//This controller is used to handle all the requests related to the product
@RestController
@RequestMapping("/products")
public class ProductController {
    iProductServices productServices;
    public ProductController(iProductServices productServices) {
        this.productServices = productServices;
    }

    @GetMapping("/{id}")
    public String getSingleProduct(@PathVariable("id") Long id) {
    Product product = this.productServices.GetSingleProduct(id);

        return "Single product with product id: " + product.toString();
    }

    @GetMapping("/")
    public String getAllProducts() {
        return "All products";
    }

    @PostMapping()
    public String addNewProduct(@RequestBody ProductDto productDto) {
        return "add new product"+productDto;
    }

    @PutMapping("/{productId}")
public String updateProduct(@PathVariable("productId") Long productId) {
        return "update product"+productId;
    }
    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId) {
        return "delete product with id "+productId;
    }
}
