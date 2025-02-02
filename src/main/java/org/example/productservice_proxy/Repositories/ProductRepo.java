package org.example.productservice_proxy.Repositories;


import org.example.productservice_proxy.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    Product save(Product product);  //(save) is a method of jpa repository interface
}
