package org.example.productservice_proxy.Services;

public interface iProductServices {
    String GetAllProduct();

    String GetSingleProduct(Long id);

    String AddNewProduct();

    String UpdateProduct();

    String DeleteProduct();
}
