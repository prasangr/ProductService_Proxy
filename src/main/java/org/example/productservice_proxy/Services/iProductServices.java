package org.example.productservice_proxy.Services;

import org.example.productservice_proxy.client.IClientProductDto;
import org.example.productservice_proxy.dto.ProductDto;
import org.example.productservice_proxy.models.Product;

import java.util.List;

public interface iProductServices {
     List<Product> GetAllProduct();

    Product GetSingleProduct(Long id);

    Product AddNewProduct(IClientProductDto productDto);

    String UpdateProduct();

    String DeleteProduct();
}
