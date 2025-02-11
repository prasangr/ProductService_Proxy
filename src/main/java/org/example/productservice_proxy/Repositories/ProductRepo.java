package org.example.productservice_proxy.Repositories;


import org.example.productservice_proxy.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> findAll();
    Optional<Product> findById(Long id);

    List<Product> findByIdBetween(long l, long limit);
    List<Product> findAllByOrderByIdDesc();

}
