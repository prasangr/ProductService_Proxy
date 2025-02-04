package org.example.productservice_proxy.HibernateInheritanceExamples.SingleClass;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="sc_ta")
@DiscriminatorValue("1")
public class TA extends User {
    private int rating;
}
