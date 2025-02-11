package org.example.productservice_proxy.Services;

import org.example.productservice_proxy.Repositories.CategoryRepo;
import org.example.productservice_proxy.Repositories.ProductRepo;
import org.example.productservice_proxy.models.Categories;
import org.example.productservice_proxy.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class SelfCategoryService implements iCategoryService {
@Autowired
ProductRepo productRepo;
    CategoryRepo categoryRepo;
    public SelfCategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }


    @Override
    public List<Product> GetProductsByCategory(String categoryname) {
        Categories categories= categoryRepo.findByName(categoryname);
       String categoryid= String.valueOf(categories.getId());
        return productRepo.findAll().stream()
                .filter(product -> product.getCategory().equals(categoryid))
                .collect(Collectors.toList());

    }



    public List<String> GetAllCategory() {
        return categoryRepo.findAll().stream()
                .map(Categories::getName)
                .collect(Collectors.toList());
    }


}
