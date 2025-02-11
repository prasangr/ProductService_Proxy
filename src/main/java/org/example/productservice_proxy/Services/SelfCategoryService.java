package org.example.productservice_proxy.Services;

import org.example.productservice_proxy.Repositories.CategoryRepo;
import org.example.productservice_proxy.models.Categories;
import org.example.productservice_proxy.models.Product;


import java.util.List;
import java.util.stream.Collectors;

public class SelfCategoryService implements iCategoryService {


    CategoryRepo categoryRepo;
    public SelfCategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }


    @Override
    public List<Product> GetProductsByCategory(String categoryname) {
        return categoryRepo.findByName(categoryname);
    }



    public List<String> GetAllCategory() {
        return categoryRepo.findAll().stream()
                .map(Categories::getName)
                .collect(Collectors.toList());
    }


}
