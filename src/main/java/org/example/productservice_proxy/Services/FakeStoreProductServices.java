package org.example.productservice_proxy.Services;


import jakarta.annotation.Nullable;
import org.example.productservice_proxy.client.IClientProductDto;
import org.example.productservice_proxy.client.fakestore.client.FakeStoreClient;
import org.example.productservice_proxy.client.fakestore.dto.FakeStoreProductDto;
import org.example.productservice_proxy.dto.ProductDto;
import org.example.productservice_proxy.models.Categories;
import org.example.productservice_proxy.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

//@Service
public class FakeStoreProductServices implements iProductServices {

    private final FakeStoreClient fakeStoreClient;
    RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductServices(RestTemplateBuilder restTemplateBuilder, FakeStoreClient fakeStoreClient) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreClient = fakeStoreClient;
    }

    @Override
    public List<Product> GetAllProduct() {
 RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductDto[]> productDtos =
                restTemplate.getForEntity("https://fakestoreapi.com/products", ProductDto[].class);


        // the above code should be provided by the client, hence calling the client method here.

        List<FakeStoreProductDto> fakeStoreProductDtos =  fakeStoreClient.getAllProducts();
        List<Product> answers = new ArrayList<>();
        for (FakeStoreProductDto productDto : fakeStoreProductDtos) {
           Product product =new Product();
              product.setId(productDto.getId());
                product.setTitle(productDto.getTitle());
                product.setPrice(productDto.getPrice());
                Categories category = new Categories();
                category.setName(productDto.getCategory());
                product.setCategory(category);
                product.setImageUrl(productDto.getImage());
                answers.add(product);
        }
        return answers;
    }


    @Override
    public Product GetSingleProduct(Long id) {
        /*RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> productDto =
        restTemplate.getForEntity("https://fakestoreapi.com/products/{id}",
        FakeStoreProductDto.class, id);*/

        // the above code should be provided by the client, hence calling the client method here.
        FakeStoreProductDto productDto = fakeStoreClient.getSingleProduct(id);
        Product product = getProduct(productDto);
        return product;
    }

    @Override
    public List<Product> GetProductByLimit(int limit) {
        return List.of();
    }

    @Override
    public List<Product> GetAllProductsInDescOrder() {
        return List.of();
    }

    @Override
    public Product AddNewProduct(Product productDto) {
        return null;
    }

    @Override
    public Product UpdateProduct(Product product) {
        return null;
    }




    public Product AddNewProduct(IClientProductDto productDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.postForEntity("https://fakestoreapi.com/products",productDto, ProductDto.class);
        // the above code should be provided by the client, hence calling the client method here.



        FakeStoreProductDto fakeStoreProductDto = fakeStoreClient.addNewProduct( productDto);
        //save to db
        Product product = getProduct((FakeStoreProductDto)productDto);
        return product;

        /*RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.postForEntity("https://fakestoreapi.com/products",productDto, ProductDto.class);
        Product product = getProduct((FakeStoreProductDto) productDto);
        return product;*/
    }





    public Product  UpdateProduct(Long productId, Product product) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setCategory(product.getCategory().getName());
        fakeStoreProductDto.setImage(product.getImageUrl());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setTitle(product.getTitle());

        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity
                = requestForEntity(
                HttpMethod.PATCH,
                "https://fakestoreapi.com/products/{id}",
                fakeStoreProductDto,
                FakeStoreProductDto.class,
                productId
        );
        FakeStoreProductDto fakeStoreProductDto1 = fakeStoreProductDtoResponseEntity.getBody();
        return getProduct(fakeStoreProductDto1);

    }

  private <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod, String url, @Nullable Object request,
                                                       Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate = restTemplateBuilder.requestFactory(
                HttpComponentsClientHttpRequestFactory.class
        ).build();
        RequestCallback requestCallback =restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }


    @Override
    public Product DeleteProduct(Long id) {
        /*RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.delete("https://fakestoreapi.com/products/{id}", id);
        return "Product has been deleted";*/
        return null;
    }


    private Product getProduct(FakeStoreProductDto productDto) {

        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        Categories category = new Categories();
        category.setName(productDto.getCategory());
        product.setCategory(category);
        product.setImageUrl(productDto.getImage());
        product.setDescription(productDto.getDescription());
        return product;
    }

}
