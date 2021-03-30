package com.maktab.servlets;

import com.maktab.models.Customer;
import com.maktab.repositories.CustomerRepository;
import com.maktab.services.CustomerDao;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

        if (username == null) {
            System.out.println("# 1");
            HttpSession session = request.getSession(false);
            if (session != null && session.getAttribute("username") != null) {
                if (optionalCustomer.isPresent()) {
                    System.out.println("# 2");
                    Customer customer = optionalCustomer.get();
                    request.getRequestDispatcher("customer_menu.html").include(request, response);
                    writer.println("<script>");
                    writer.println("document.getElementById('welcome-message').innerHTML = \" Welcome " + customer.getFirstName() + " " + customer.getLastName() + "\";");
                }
                else {
                    System.out.println("# 3");
                    request.getRequestDispatcher("login.html").include(request, response);
                    writer.println("<script>");
                    writer.println("document.getElementById('incorrect-username-or-password').innerHTML = \"* Username or password is incorrect\";");
                }
                writer.println("</script>");
            }
            else {
                System.out.println("# 4");
                writer.println("<script>");
                writer.println("alert(\"* You must login first, Please login\";");
                writer.println("</script>");

                request.getRequestDispatcher("login.html").include(request, response);
            }
        }
        else if (optionalCustomer.isPresent()) {
            System.out.println("# 5");
            Customer customer = optionalCustomer.get();

            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            session.setAttribute("firstName", customer.getFirstName());
            session.setAttribute("lastName", customer.getLastName());

            request.getRequestDispatcher("customer_menu.html").include(request, response);

            writer.println("<script>");
            writer.println("document.getElementById('welcome-message').innerHTML = \" Welcome " + customer.getFirstName() + " " + customer.getLastName() + "\";");
            writer.println("</script>");
        }
        else {
            System.out.println("# 6");
            writer.println("<script>");
            writer.println("alert(\"* You must login first, Please login\";");
            writer.println("</script>");

            request.getRequestDispatcher("login.html").include(request, response);
        }

        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
