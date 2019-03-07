package com.Practice.controller;

import com.Practice.model.CheckInternet;
import com.Practice.model.Host;
import com.Practice.service.HostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InternetStatusServlet")
public class InternetStatusServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String page = request.getParameter("q");
        if (page.equalsIgnoreCase("checkStatus")) {

            String host = request.getParameter("host");
            System.out.println(host);

            /*boolean yesInternet = new CheckInternet().internetStatus(host);

            if (yesInternet) {
                request.getRequestDispatcher("jsp/yesInternet.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("jsp/noInternet.jsp").forward(request, response);
            }*/
            boolean isURLon = new CheckInternet().httpsStatus();
            if (isURLon) {
                request.getRequestDispatcher("jsp/yesInternet.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("jsp/noInternet.jsp").forward(request, response);
            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

}