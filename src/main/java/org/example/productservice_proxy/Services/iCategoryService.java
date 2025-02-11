package org.example.productservice_proxy.Services;

import org.example.productservice_proxy.models.Product;

import java.util.List;

public interface  iCategoryService {

    public List<String> GetAllCategory();
    List<Product> GetProductsByCategory(String categoryname);







}
