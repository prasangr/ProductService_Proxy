package org.example.productservice_proxy.HibernateInheritanceExamples.TableperClass;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="tpc_instructor")
public class Instructor extends  User{
    private String company;


}
