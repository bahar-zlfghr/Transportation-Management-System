package com.maktab.servlets;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

//@WebServlet(name = "GetPriceServlet")
public class GetPriceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(" # get price servlet");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        HttpSession session = request.getSession();

        request.getRequestDispatcher("get_price.html").include(request, response);

        int parcelPostWeight = Integer.parseInt((String) session.getAttribute("parcelPostWeight"));
        int premiumPrice = parcelPostWeight * 20_000;
        int goldPrice = parcelPostWeight * 14_000;
        int silverPrice = parcelPostWeight * 10_000;

        writer.println("<script>");
        writer.println("document.getElementById('welcome-message').innerHTML = \" Welcome " + session.getAttribute("firstName") + " " + session.getAttribute("lastName") + "\";");

        writer.println("document.getElementById('premium-deliver-time').innerHTML = \"Deliver time: 1 day\";");
        writer.println("document.getElementById('premium-post-price').innerHTML = \"Price : " + premiumPrice + " \";");

        writer.println("document.getElementById('gold-deliver-time').innerHTML = \"Deliver time: 3 day\";");
        writer.println("document.getElementById('gold-post-price').innerHTML = \"Price : " + goldPrice + " \";");

        writer.println("document.getElementById('silver-deliver-time').innerHTML = \"Deliver time: 4 day\";");
        writer.println("document.getElementById('silver-post-price').innerHTML = \"Price : " + silverPrice + " \";");

        Random random = new Random();
        int num1 = random.nextInt(25);
        int num2 = random.nextInt(25);

        session.setAttribute("num1", num1);
        session.setAttribute("num2", num2);

        writer.println("document.getElementById('sum-statement').innerHTML = \"" + num1 + " + " + num2 +"\";");
        writer.println("</script>");

        request.getRequestDispatcher("saveDeliveryServlet").include(request, response);

        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
