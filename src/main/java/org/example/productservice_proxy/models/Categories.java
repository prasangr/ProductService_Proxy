package org.example.productservice_proxy.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
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

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
    private String name;
    private String description;
  //  @Fetch(org.hibernate.annotations.FetchMode.JOIN)

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Product> productList;


}
