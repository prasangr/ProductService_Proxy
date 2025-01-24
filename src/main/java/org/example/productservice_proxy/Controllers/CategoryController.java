package org.example.productservice_proxy.Controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products/categories")

public class CategoryController {

    @GetMapping("/")
    public String getAllCategories() {
        return "All categories";
    }
    @GetMapping("/{categoryId}")
    public String getProductsinCategory(@PathVariable("categoryId") Long categoryId) {
        return "All products in category with category id: " + categoryId;
    }


}
