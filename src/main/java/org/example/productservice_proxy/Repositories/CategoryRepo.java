package org.example.productservice_proxy.Repositories;

import org.example.productservice_proxy.models.Categories;
import org.example.productservice_proxy.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CategoryRepo extends JpaRepository<Categories, Long> {
    Categories save(Categories categories);
    Categories findById(long id);

    //  List<Product> findByName(String categoryname);

    Categories findByName(String categoryname);
}
