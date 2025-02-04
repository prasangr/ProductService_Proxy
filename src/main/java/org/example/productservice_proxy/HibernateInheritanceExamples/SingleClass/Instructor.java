package org.example.productservice_proxy.HibernateInheritanceExamples.SingleClass;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="sc_instructor")
@DiscriminatorValue("3")
public class Instructor extends User {
    private String company;


}
