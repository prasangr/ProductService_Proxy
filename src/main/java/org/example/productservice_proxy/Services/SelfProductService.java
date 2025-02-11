package org.example.productservice_proxy.Services;

import org.example.productservice_proxy.Repositories.ProductRepo;
import org.example.productservice_proxy.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelfProductService implements iProductServices {


    @Autowired
    ProductRepo productRepo;


    @Override
    public List<Product> GetAllProduct() {
      return productRepo.findAll();
    }

    @Override
    public Product GetSingleProduct(Long id) {
       return productRepo.findById(id).get();
    }

    @Override
    public List<Product> GetProductByLimit(int limit) {
       return productRepo.findByIdBetween(0L, (long) limit);
    }

    @Override
    public List<Product> GetAllProductsInDescOrder() {
        return productRepo.findAllByOrderByIdDesc();
    }

    @Override
    public Product AddNewProduct(Product productDto) {
        return productRepo.save(productDto);
    }

    @Override
    public Product UpdateProduct(Long productId, Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product DeleteProduct(Long id) {
        Product product = productRepo.findById(id).get();
        productRepo.deleteById(id);
        return product;
    }
}
