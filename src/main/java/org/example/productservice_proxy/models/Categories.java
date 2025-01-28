package org.example.productservice_proxy.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class Categories extends BaseModel{

 /*   category": {
            "id": null,
            "createdAt": null,
            "lastupdatedAt": null,
            "name": "men's clothing",
            "description": null,
            "productList": null,
            "deleted": false
}*/

    private String name;
    private String description;
    private List<Product> productList;


}
