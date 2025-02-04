package org.example.productservice_proxy.HibernateInheritanceExamples.SingleClass;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="sc_mentor")
@DiscriminatorValue("2")
public class Mentor extends User {
    private int gradYear;
}
