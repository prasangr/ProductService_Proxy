package org.example.productservice_proxy.Controllers;

import org.example.productservice_proxy.Services.iProductServices;
import org.example.productservice_proxy.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {


    @Mock
    iProductServices productServices;

    @Autowired
    private ProductController productController;

    @Test
    void test_whenGetProductIsCaller_ReturnProducts() {
        Product product = new Product();
        when(productServices.GetSingleProduct(any(Long.class))).thenReturn(product);
        Product pp = productController.getSingleProduct(1L).getBody();
        assertNotNull(pp);

    }

    @Test
    void test_whenGetProductIsCalled_ReturnException(){
        when(productServices.GetSingleProduct(any(Long.class))).thenThrow(new RuntimeException("Something went wrong"));
        assertThrows(RuntimeException.class, () -> productController.getSingleProduct(2l));
    }

}