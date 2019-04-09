package com.practice.controller;
import com.practice.model.Host;
import com.practice.model.Users;
import com.practice.service.HostService;
import com.practice.service.UserLoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("--------------------------------");


            String email = request.getParameter("email");
            String password = request.getParameter("password");

            Users user = new Users();
            user.setEmail(email);
            user.setPassword(password);

            boolean isUserExist = new UserLoginService().login(user);

            if (isUserExist){

                String page = request.getParameter("q");
                if (page.equalsIgnoreCase("listHost"))
                {
                    List<Host> hostList = new HostService().listHost();
                    request.setAttribute("h", hostList);

                    List<Host> serverList = new HostService().serverList();
                    request.setAttribute("s", serverList);

                    List<Host> hostCount = new HostService().countHost();
                    request.setAttribute("hc", hostCount);

                    List<Host> serverCount = new HostService().countServer();
                    request.setAttribute("sc", serverCount);

                    request.getRequestDispatcher("jsp/home.jsp").forward(request,response);

                }
            }else
                request.getRequestDispatcher("main.jsp").forward(request,response);







    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ma home ma aaye");

        String page = request.getParameter("q");
        if (page.equalsIgnoreCase("home"))
        {
            List<Host> hostList = new HostService().listHost();
            request.setAttribute("h", hostList);
            List<Host> serverList = new HostService().serverList();
            request.setAttribute("s", serverList);

            List<Host> hostCount = new HostService().countHost();
            request.setAttribute("hc", hostCount);

            List<Host> serverCount = new HostService().countServer();
            request.setAttribute("sc", serverCount);
            request.getRequestDispatcher("jsp/home.jsp").forward(request,response);
        }
        if(page.equalsIgnoreCase("logout"))
        {
            request.getRequestDispatcher("main.jsp").forward(request,response);

        }
    }
}
