package com.sashutosh.microservice.ordering.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="buyers")
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String identityGuid;
    String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "buyer")
    List<PaymentMethods> paymentMethods;


    public Buyer(String identityGuid, String name, List<PaymentMethods> paymentMethods) {
        this.identityGuid = identityGuid;
        this.name = name;
        this.paymentMethods = paymentMethods;
    }

    public String getIdentityGuid() {
        return identityGuid;
    }

    public void setIdentityGuid(String identityGuid) {
        this.identityGuid = identityGuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PaymentMethods> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(List<PaymentMethods> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }
}
