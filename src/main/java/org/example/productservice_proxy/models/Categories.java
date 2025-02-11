package org.example.productservice_proxy.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;

import java.util.List;

@Setter
@Getter
@ToString
@Entity
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
    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @Fetch(org.hibernate.annotations.FetchMode.JOIN)
    private List<Product> productList;


}
