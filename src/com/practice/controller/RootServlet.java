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
import java.util.Timer;
import java.util.TimerTask;

@WebServlet(name = "RootServlet")
public class RootServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Host> urlSelect = new HostService().selectUrl();
        List<Host> ipAddrSelect = new HostService().selectIPAddr();

      /* int MINUTES = 5; // The delay in minutes
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() { // Function runs every MINUTES minutes.
                // Run the code you want here
                CheckInternet callObj = new CheckInternet();
                callObj.httpStatusList(urlSelect);// If the function you wanted was static
                callObj.serverStatusList(ipAddrSelect);
            }

        }, 0, 1000 * 60 * MINUTES);*/
        request.getRequestDispatcher("main.jsp").forward(request,response);
//        request.getRequestDispatcher("main.jsp").forward(request,response);
        // 1000 milliseconds in a second * 60 per minute * the MINUTES variable.

        /*List<Host> hostSelect = new HostService().selectHost();
        boolean isUrlList = new CheckInternet().httpStatusList(hostSelect);
        if(isUrlList){
            System.out.println("OK!!!");
            request.getRequestDispatcher("jsp/yesInternet.jsp").forward(request,response);
        }else
        {
            System.out.println("NoOK!!");
            request.getRequestDispatcher("jsp/noInternet.jsp").forward(request,response);
        }*/
    }
}
