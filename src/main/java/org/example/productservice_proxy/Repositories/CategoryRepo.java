package org.example.productservice_proxy.Repositories;

import org.example.productservice_proxy.models.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Categories, Long> {
    Categories save(Categories categories);
    Categories findById(long id);

}
