package com.maktab.servlets;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@WebServlet(name = "NewDeliveryServlet")
public class NewDeliveryServlet extends HttpServlet {
    private static final Map<String, List<String>> addresses = new HashMap<>();

    static {
        addresses.put("alborz", Arrays.asList("Karaj", "Asara", "Taleghan"));
        addresses.put("tehran", Arrays.asList("Malard", "Varamin", "Firouzkouh", "Parand"));
        addresses.put("kermanshah", Arrays.asList("Kangavar", "Sahneh", "Bistoun"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(" # new delivery servlet");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        HttpSession session = request.getSession();

        String originProvince = request.getParameter("originProvince");
        String originCity = addresses.get(originProvince).get(Integer.parseInt(request.getParameter("originCity")));
        String originContinuationAddress = request.getParameter("originContinuationAddress");
        String destinationProvince = request.getParameter("destinationProvince");
        String destinationCity = addresses.get(destinationProvince).get(Integer.parseInt(request.getParameter("destinationCity")));
        String destinationContinuationAddress = request.getParameter("destinationContinuationAddress");
        String recipientFirstName = request.getParameter("recipientFirstName");
        String recipientLastName = request.getParameter("recipientLastName");
        String recipientPhone = request.getParameter("recipientPhone");
        String transportType = request.getParameter("transportType");
        String parcelPostWeight = request.getParameter("parcelPostWeight");

        session.setAttribute("originProvince", originProvince);
        session.setAttribute("originCity", originCity);
        session.setAttribute("originContinuationAddress", originContinuationAddress);
        session.setAttribute("destinationProvince", destinationProvince);
        session.setAttribute("destinationCity", destinationCity);
        session.setAttribute("destinationContinuationAddress", destinationContinuationAddress);
        session.setAttribute("recipientFirstName", recipientFirstName);
        session.setAttribute("recipientLastName", recipientLastName);
        session.setAttribute("recipientPhone", recipientPhone);
        session.setAttribute("transportType", transportType);
        session.setAttribute("parcelPostWeight", parcelPostWeight);

        if (transportType.equals("Non_Document")) {
            String parcelPostContent = request.getParameter("parcelPostContent");
            String parcelPostLength = request.getParameter("parcelPostLength");
            String parcelPostWidth = request.getParameter("parcelPostWidth");
            String parcelPostHeight = request.getParameter("parcelPostHeight");

            session.setAttribute("parcelPostContent", parcelPostContent);
            session.setAttribute("parcelPostLength", parcelPostLength);
            session.setAttribute("parcelPostWidth", parcelPostWidth);
            session.setAttribute("parcelPostHeight", parcelPostHeight);
        }

        request.getRequestDispatcher("/getPriceServlet").forward(request, response);

        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
