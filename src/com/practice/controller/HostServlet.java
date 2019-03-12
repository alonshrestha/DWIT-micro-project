package com.practice.controller;

import com.practice.model.CheckInternet;
import com.practice.model.Host;
import com.practice.service.HostService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HostServlet")
public class HostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




        String q = request.getParameter("q");
        if (q.equalsIgnoreCase("regHost")) {
            String appName = request.getParameter("appname");
            String ipAddr = request.getParameter("ipAddr");
            String url = request.getParameter("url");

            System.out.println(appName);
            System.out.println(ipAddr);
            System.out.println(url);
            Host h = new Host();

            h.setAppName(appName);
            h.setIpAddr(ipAddr);
            h.setUrl(url);

            boolean isHostAdded = new HostService().addHost(h);



            if (isHostAdded) {
                List<Host> hostList = new HostService().listHost();
                request.setAttribute("h", hostList);
                request.getRequestDispatcher("jsp/listHost").forward(request, response);
            } else {
                request.getRequestDispatcher("jsp/registerHost.jsp").forward(request, response);
            }
        }

        if(q.equalsIgnoreCase("editHost")){

            String appName = request.getParameter("appName");
            String ipAddr = request.getParameter("ipAddr");
            String url = request.getParameter("url");
            String HostID = request.getParameter("id");

            int id = Integer.parseInt(HostID);
            System.out.println(appName);
            System.out.println(ipAddr);
            System.out.println(url);
            Host h = new Host();
            System.out.println(id);
            h.setAppName(appName);
            h.setIpAddr(ipAddr);
            h.setUrl(url);
            h.setId(id);

            boolean isHostUpdate = new  HostService().editHost(h);

            if(isHostUpdate){
                List<Host> hostList = new HostService().listHost();
                request.setAttribute("h",hostList);
                request.getRequestDispatcher("jsp/listHost.jsp").forward(request,response);
            }else {
                request.getRequestDispatcher("jsp/editHost.jsp").forward(request,response);
            }


        }




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String q = request.getParameter("q");

        if (q.equalsIgnoreCase("regHost")) {
            request.getRequestDispatcher("jsp/registerHost.jsp").forward(request, response);
        }
        if (q.equalsIgnoreCase("listHost")) {
            List<Host> hostList = new HostService().listHost();
            request.setAttribute("h", hostList);
            request.getRequestDispatcher("jsp/listHost.jsp").forward(request, response);
        }

        if (q.equalsIgnoreCase("deleteHost")) {
            int id = Integer.parseInt(request.getParameter("id"));
            System.out.println(id);
            new HostService().deleteHost(id);
            List<Host> hostList = new HostService().listHost();
            request.setAttribute("h", hostList);
            RequestDispatcher rd = request.getRequestDispatcher("jsp/listHost.jsp");
            rd.forward(request, response);
        }

        if (q.equalsIgnoreCase("editHost")) {
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("i", id);
            request.getRequestDispatcher("jsp/editHost.jsp").forward(request, response);
        }

    }
}
