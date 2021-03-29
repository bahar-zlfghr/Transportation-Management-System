package com.maktab.filters;

import com.maktab.repositories.CustomerRepository;
import com.maktab.services.CustomerDao;

import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

//@WebFilter(filterName = "SignupFilter")
public class SignupFilter implements Filter {
    private static final CustomerRepository customerRepository = new CustomerRepository();
    private static final CustomerDao customerDao = new CustomerDao();

    static {
        customerRepository.addCustomer(customerDao.fetch());
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println(" # filter");
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        String username = req.getParameter("username");
        String email = req.getParameter("email");

        if (!customerRepository.existsUsername(username) && !customerRepository.existsEmail(email)) {
            System.out.println(" # Not Duplicate");
            chain.doFilter(req, resp);
        }
        else {
            System.out.println(" # Duplicate");

            req.getRequestDispatcher("signup.html").include(req, resp);

            writer.println("<script>");
            if (customerRepository.existsUsername(username)) {
                writer.println("document.getElementById('duplicate-error-username').innerHTML = \" * Username should not be duplicated\";");
            } else {
                writer.println("document.getElementById('duplicate-error-username').innerHTML = \"\";");
            }
            if (customerRepository.existsEmail(email)) {
                writer.println("document.getElementById('duplicate-error-email').innerHTML = \" * Email should not be duplicated\";");
            } else {
                writer.println("document.getElementById('duplicate-error-email').innerHTML = \"\";");
            }
            writer.println("</script>");
        }
        writer.close();
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
