package com.maktab.servlets;

import com.maktab.models.Address;
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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@WebServlet(name = "SignupServlet")
public class SignupServlet extends HttpServlet {
    private static final CustomerRepository customerRepository = new CustomerRepository();
    private static final CustomerDao customerDao = new CustomerDao();
    private static final Map<String, List<String>> addresses = new HashMap<>();

    static {
        addresses.put("alborz", Arrays.asList("Karaj", "Asara", "Taleghan"));
        addresses.put("tehran", Arrays.asList("Malard", "Varamin", "Firouzkouh", "Parand"));
        addresses.put("kermanshah", Arrays.asList("Kangavar", "Sahneh", "Bistoun"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(" # servlet");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        customerRepository.addCustomer(customerDao.fetch());

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String province = request.getParameter("province");
        String city = addresses.get(province).get(Integer.parseInt(request.getParameter("city")));
        String continuationAddress = request.getParameter("continuationAddress");

        Address address = new Address(
                province, city, continuationAddress
        );
        Customer customer = new Customer(
                username, password, firstName, lastName, email, phone, address
        );
        customerRepository.addCustomer(customer);
        customerDao.saveAddress(address);
        customerDao.saveCustomer(customer);

        System.out.println(" # Welcome");

        request.getRequestDispatcher("customer_menu.html").include(request, response);
        writer.println("<script>");
        writer.println("document.getElementById('welcome-message').innerHTML = \" Welcome " + firstName + " " + lastName + "\";");
        writer.println("</script>");

        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
