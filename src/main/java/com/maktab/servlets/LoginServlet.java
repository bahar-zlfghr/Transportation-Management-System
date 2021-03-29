package com.maktab.servlets;

import com.maktab.models.Customer;
import com.maktab.repositories.CustomerRepository;
import com.maktab.services.CustomerDao;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

//@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final CustomerRepository customerRepository = new CustomerRepository();
    private static final CustomerDao customerDao = new CustomerDao();



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(" # Login servlet");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        customerRepository.addCustomer(customerDao.fetch());

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Optional<Customer> optionalCustomer = customerRepository.findCustomerByUsernameAndPassword(username, password);

        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            request.getRequestDispatcher("customer_menu.html").include(request, response);
            writer.println("<script>");
            writer.println("document.getElementById('welcome-message').innerHTML = \" Welcome " + customer.getFirstName() + " " + customer.getLastName() + "\";");
        }
        else {
            request.getRequestDispatcher("login.html").include(request, response);
            writer.println("<script>");
            writer.println("document.getElementById('incorrect-username-or-password').innerHTML = \"* Username or password is incorrect\";");
        }
        writer.println("</script>");
        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
