package org.example.productservice_proxy.Services;

import org.example.productservice_proxy.models.Product;

public interface iProductServices {
    String GetAllProduct();

    Product GetSingleProduct(Long id);

    String AddNewProduct();

    String UpdateProduct();

    String DeleteProduct();
}
