package com.maktab.models;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Province", nullable = false, length = 25)
    private String province;
    @Column(name = "City", nullable = false, length = 25)
    private String city;
    @Column(name = "ContinuationAddress")
    private String continuationAddress;

    public Address() {
    }

    public Address(String province, String city, String continueAddress) {
        this.province = province;
        this.city = city;
        this.continuationAddress = continueAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContinuationAddress() {
        return continuationAddress;
    }

    public void setContinuationAddress(String continueAddress) {
        this.continuationAddress = continueAddress;
    }
}
