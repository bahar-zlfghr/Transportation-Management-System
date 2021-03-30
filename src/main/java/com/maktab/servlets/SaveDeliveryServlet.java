package com.maktab.servlets;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "SaveDeliveryServlet")
public class SaveDeliveryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(" # save delivery servlet");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        int result = Integer.parseInt(request.getParameter("result"));
        String priceType = request.getParameter("priceType");

        HttpSession session = request.getSession();

        int parcelPostWeight = Integer.parseInt((String) session.getAttribute("parcelPostWeight"));
        int premiumPrice = parcelPostWeight * 20_000;
        int goldPrice = parcelPostWeight * 14_000;
        int silverPrice = parcelPostWeight * 10_000;

        int num1 = Integer.parseInt((String) session.getAttribute("num1"));
        int num2 = Integer.parseInt((String) session.getAttribute("num2"));

        if (result == (num1 + num2)) {
            switch (priceType) {
                case "1" :
                    session.setAttribute("price", premiumPrice);
                    session.setAttribute("deliverTime", 1);
                    writer.println("<script>");
                    writer.println("document.getElementById('error-not-choose-option').innerHTML = \"\";");
                    writer.println("</script>");
                    break;
                case "2":
                    session.setAttribute("price", goldPrice);
                    session.setAttribute("deliverTime", 3);
                    writer.println("document.getElementById('error-not-choose-option').innerHTML = \"\";");
                    break;
                case "3":
                    session.setAttribute("price", silverPrice);
                    session.setAttribute("deliverTime", 4);
                    break;
                default:
                    writer.println("<script>");
                    writer.println("document.getElementById('error-not-choose-option').innerHTML = \" * Choose one service\";");
                    writer.println("</script>");
                    writer.println("document.getElementById('error-not-choose-option').innerHTML = \"\";");
                    break;
            }
            request.getRequestDispatcher("home.html").forward(request, response);
        }
        else {
            request.getRequestDispatcher("/getPriceServlet").forward(request, response);

            /*writer.println("<script>");
            writer.println("document.getElementById('error-incorrect-result').innerHTML = \" * Result is incorrect\";");
            writer.println("</script>");*/
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
