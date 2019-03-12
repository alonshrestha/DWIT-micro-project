package com.practice.controller;

import com.practice.model.CheckInternet;
import com.practice.model.Host;
import com.practice.service.HostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "InternetStatusServlet")
public class InternetStatusServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String page = request.getParameter("q");

        if (page.equalsIgnoreCase("serverStatus")) {
            System.out.println("ok ya aaye");
            String ipaddress = request.getParameter("ip");

            boolean yesInternet = new CheckInternet().serverStatus(ipaddress);
            if (yesInternet) {
                request.getRequestDispatcher("jsp/yesInternet.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("jsp/noInternet.jsp").forward(request, response);
            }

        }

        if (page.equalsIgnoreCase("httpStatus")) {
            String http = request.getParameter("url");

            boolean yesInternet = new CheckInternet().httpStatus(http);
            if (yesInternet) {
                request.getRequestDispatcher("jsp/yesInternet.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("jsp/noInternet.jsp").forward(request, response);
            }
        }




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

}