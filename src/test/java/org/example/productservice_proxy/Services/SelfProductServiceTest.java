package org.example.productservice_proxy.Services;

import org.example.productservice_proxy.Repositories.ProductRepo;
import org.example.productservice_proxy.models.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class SelfProductServiceTest {

    @Mock
    private ProductRepo productRepo;

    @InjectMocks
    private SelfProductService selfProductService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllProduct_returnsAllProducts() {
        Product product1 = new Product();
        Product product2 = new Product();
        when(productRepo.findAll()).thenReturn(Arrays.asList(product1, product2));

        List<Product> products = selfProductService.GetAllProduct();

        assertEquals(2, products.size());
        verify(productRepo, times(1)).findAll();
    }

    @Test
    void getSingleProduct_returnsProduct() {
        Product product = new Product();
        when(productRepo.findById(1L)).thenReturn(Optional.of(product));

        Product result = selfProductService.GetSingleProduct(1L);

        assertNotNull(result);
        verify(productRepo, times(1)).findById(1L);
    }

    @Test
    void getSingleProduct_productNotFound() {
        when(productRepo.findById(1L)).thenReturn(Optional.empty());

        Product result = selfProductService.GetSingleProduct(1L);

        assertNull(result);
        verify(productRepo, times(1)).findById(1L);
    }

    @Test
    void getProductByLimit_returnsLimitedProducts() {
        Product product1 = new Product();
        Product product2 = new Product();
        when(productRepo.findByIdBetween(0L, 2L)).thenReturn(Arrays.asList(product1, product2));

        List<Product> products = selfProductService.GetProductByLimit(2);

        assertEquals(2, products.size());
        verify(productRepo, times(1)).findByIdBetween(0L, 2L);
    }

    @Test
    void getAllProductsInDescOrder_returnsProductsInDescOrder() {
        Product product1 = new Product();
        Product product2 = new Product();
        when(productRepo.findAllByOrderByIdDesc()).thenReturn(Arrays.asList(product1, product2));

        List<Product> products = selfProductService.GetAllProductsInDescOrder();

        assertEquals(2, products.size());
        verify(productRepo, times(1)).findAllByOrderByIdDesc();
    }

    @Test
    void addNewProduct_savesAndReturnsProduct() {
        Product product = new Product();
        when(productRepo.save(any(Product.class))).thenReturn(product);

        Product result = selfProductService.AddNewProduct(product);

        assertNotNull(result);
        verify(productRepo, times(1)).save(product);
    }

    @Test
    void updateProduct_updatesAndReturnsProduct() {
        Product product = new Product();
        when(productRepo.save(any(Product.class))).thenReturn(product);

        Product result = selfProductService.UpdateProduct(product);

        assertNotNull(result);
        verify(productRepo, times(1)).save(product);
    }

    @Test
    void deleteProduct_deletesAndReturnsProduct() {
        Product product = new Product();
        when(productRepo.findById(1L)).thenReturn(Optional.of(product));

        Product result = selfProductService.DeleteProduct(1L);

        assertNotNull(result);
        verify(productRepo, times(1)).findById(1L);
        verify(productRepo, times(1)).deleteById(1L);
    }

    @Test
    void deleteProduct_productNotFound() {
        when(productRepo.findById(1L)).thenReturn(Optional.empty());

        Product result = selfProductService.DeleteProduct(1L);

        assertNull(result);
        verify(productRepo, times(1)).findById(1L);
        verify(productRepo, times(0)).deleteById(1L);
    }
}