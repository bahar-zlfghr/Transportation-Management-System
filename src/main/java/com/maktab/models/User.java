package com.maktab.models;

import javax.persistence.*;

@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "Discriminator", discriminatorType = DiscriminatorType.STRING
)
@DiscriminatorValue(value="User")
public class User {
    @Id
    @Column(name = "Username")
    private String username;
    @Column(name = "Password", nullable = false)
    private String password;
    @Column(name = "FirstName", nullable = false, length = 15)
    private String firstName;
    @Column(name = "LastName", nullable = false, length = 25)
    private String lastName;

    public User() {
    }

    public User(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
