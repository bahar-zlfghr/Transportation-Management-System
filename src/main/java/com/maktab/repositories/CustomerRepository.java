package com.maktab.repositories;

import com.maktab.models.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerRepository {
    private static final List<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addCustomer(List<Customer> customers) {
        CustomerRepository.customers.addAll(customers);
    }

    public static List<Customer> getCustomers() {
        return customers;
    }

    public boolean existsUsername(String username) {
        return customers.stream().filter(customer -> customer.getUsername().equals(username)).count() == 1;
    }

    public boolean existsEmail(String email) {
        return customers.stream().filter(customer -> customer.getEmail().equals(email)).count() == 1;
    }

    public Optional<Customer> findCustomerByUsernameAndPassword(String username, String password) {
        return customers.stream().filter(customer -> customer.getUsername().equals(username) &&
                customer.getPassword().equals(password)).findFirst();
    }
}
