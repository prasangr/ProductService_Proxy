package org.example.productservice_proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




// Proxy service is just a delegate service that calls the actual service
@SpringBootApplication
public class ProductServiceProxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceProxyApplication.class, args);
    }

}
