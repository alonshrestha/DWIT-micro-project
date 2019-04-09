package com.practice.controller;

import com.practice.model.CheckInternet;
import com.practice.model.Host;
import com.practice.service.HostService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HostServlet")
public class    HostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String q = request.getParameter("q");
        if (q.equalsIgnoreCase("regHost2")) {
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
            System.out.println("is host samma aaye");
            System.out.println(isHostAdded);

            if (isHostAdded) {
                List<Host> hostList = new HostService().listHost();
                request.setAttribute("h", hostList);

                request.getRequestDispatcher("jsp/home.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("jsp/home.jsp").forward(request, response);
            }
        }

        if (q.equalsIgnoreCase("editHost")) {

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

            boolean isHostUpdate = new HostService().editHost(h);

            if (isHostUpdate) {
                List<Host> hostList = new HostService().listHost();
                request.setAttribute("h", hostList);
                request.getRequestDispatcher("jsp/listHost.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("jsp/editHost.jsp").forward(request, response);
            }


        }



        /*---------------------------------------------------------------------------------------------*/

        if (q.equalsIgnoreCase("regServer2")) {
            String serverName = request.getParameter("serverName");
            String serverAddr = request.getParameter("serverAddr");

            Host s = new Host();
            s.setServerName(serverName);
            s.setServerAddr(serverAddr);

            boolean isServerAdd = new HostService().addServer(s);
            if (isServerAdd) {
                List<Host> serverList = new HostService().serverList();

                request.setAttribute("s", serverList);
                System.out.println("serverList = " + serverList);
                request.getRequestDispatcher("jsp/home.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("jsp/home.jsp").forward(request, response);
            }

        }

        if (q.equalsIgnoreCase("editServer")) {

            String serverName = request.getParameter("serverName");
            String serverAddr = request.getParameter("serverAddr");
            String serverID = request.getParameter("serverId");

            int serverId = Integer.parseInt(serverID);
            System.out.println(serverName);
            System.out.println(serverAddr);
            Host s = new Host();
            System.out.println(serverId);
            s.setServerName(serverName);
            s.setServerAddr(serverAddr);
            s.setserverId(serverId);

            boolean isServerUpdate = new HostService().editServer(s);

            if (isServerUpdate) {
                List<Host> serverList = new HostService().serverList();
                request.setAttribute("s", serverList);
                request.getRequestDispatcher("jsp/listHost.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("jsp/home.jsp").forward(request, response);
            }


        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String q = request.getParameter("q");

        if (q.equalsIgnoreCase("regHost")) {
            request.getRequestDispatcher("jsp/registerHost.jsp").forward(request, response);
        }

        if (q.equalsIgnoreCase("regServer")) {
            request.getRequestDispatcher("jsp/registerServer.jsp").forward(request, response);
        }

        if (q.equalsIgnoreCase("listHost")) {
            List<Host> hostList = new HostService().listHost();
            request.setAttribute("h", hostList);

            List<Host> serverList = new HostService().serverList();
            request.setAttribute("s", serverList);
            request.getRequestDispatcher("jsp/listHost.jsp").forward(request, response);
        }

        if (q.equalsIgnoreCase("deleteHost")) {
            System.out.println("delete ma aaye hai ma ");
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
            String appName = request.getParameter("appName");
            String ipAddr = request.getParameter("ipAddr");
            String url = request.getParameter("url");
            request.setAttribute("id", id);
            request.setAttribute("appName", appName);
            request.setAttribute("ipAddr", ipAddr);
            request.setAttribute("url", url);
            request.getRequestDispatcher("jsp/editHost.jsp").forward(request, response);
        }

       /*------------------------------------------------------------------------------------------*/
        if (q.equalsIgnoreCase("editServer")) {
            int serverId = Integer.parseInt(request.getParameter("serverId"));
            String serverName = request.getParameter("serverName");
            String serverAddr = request.getParameter("serverAddr");
            request.setAttribute("serverId", serverId);
            request.setAttribute("serverName", serverName);
            request.setAttribute("serverAddr", serverAddr);
            request.getRequestDispatcher("jsp/editServer.jsp").forward(request, response);
        }

    }
}
