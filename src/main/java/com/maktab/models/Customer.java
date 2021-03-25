package com.maktab.models;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="Customer")
public class Customer extends User {
    @Column(name = "Email", nullable = false)
    private String email;
    @Column(name = "Phone", length = 11)
    private String phone;
    @OneToOne
    @JoinColumn(name = "Address Id")
    private Address address;

    public Customer() {
    }

    public Customer(String email, String phone, Address address) {
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public Customer(String username, String password, String firstName, String lastName, String email, String phone, Address address) {
        super(username, password, firstName, lastName);
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
