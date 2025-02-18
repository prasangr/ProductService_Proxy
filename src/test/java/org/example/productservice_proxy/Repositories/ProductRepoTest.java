package org.example.productservice_proxy.Repositories;

import jakarta.transaction.Transactional;
import org.example.productservice_proxy.models.Categories;
import org.example.productservice_proxy.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;


@SpringBootTest
class ProductRepoTest {

    @Autowired
   private ProductRepo productRepo;
    @Autowired
  private  CategoryRepo categoryRepo;



    @Test
    @Transactional
    @Rollback(value = false)  // as this is a test case , we need this to save the data in the database , otherwise it will not save the data in the database
    void savePorductsAndsCategories() {
        Categories categories = new Categories();
        categories.setName("Electronics");
        categories.setDescription("Electronics products");
       // categories=categoryRepo.save(categories);


        Product product = new Product();
        product.setTitle("Samsung Galaxy S21");
        product.setPrice(1000);
        product.setDescription("Samsung Galaxy S21");
        product.setCategory(categories);
        productRepo.save(product);


      /*  Categories categories1 = categoryRepo.findById(categories.getId()).get();
        List<Product> productList = categories1.getProductList();*/

    }

    @Test
    @Transactional
  //  @Rollback(value = false) // to let the data save in the database
    void savePorductsAndsCategories1() {
        Categories categories = new Categories();
       Categories categories1= categoryRepo.findById(1L);


     //   Product product = productRepo.findByPriceBetween(1000, 1012);
        System.out.println("Debug");
    }
}