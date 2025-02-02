package org.example.productservice_proxy.Services;

import org.example.productservice_proxy.Repositories.ProductRepo;
import org.example.productservice_proxy.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelfProductService implements iProductServices {



    ProductRepo productRepo;
    public SelfProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }



    @Override
    public List<Product> GetAllProduct() {
        return null;
    }

    @Override
    public Product GetSingleProduct(Long id) {
        return null;
    }

    @Override
    public Product AddNewProduct(Product productDto) {
       this.productRepo.save(productDto);
        return productDto;
    }

    @Override
    public Product UpdateProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public String DeleteProduct(Long id) {
        return null;
    }
}
