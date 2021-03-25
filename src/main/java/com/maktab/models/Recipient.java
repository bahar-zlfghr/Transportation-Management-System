package com.maktab.models;

import javax.persistence.*;

@Entity
public class Recipient {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "FirstName", nullable = false, length = 15)
    private String firstName;
    @Column(name = "LastName", nullable = false , length = 25)
    private String lastName;
    @Column(name = "Phone", nullable = false, length = 11)
    private String phone;

    public Recipient() {
    }

    public Recipient(String firstName, String lastName, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
