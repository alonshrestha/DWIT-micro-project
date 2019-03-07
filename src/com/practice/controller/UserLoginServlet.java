package com.practice.controller;
import com.practice.model.Users;
import com.practice.service.UserLoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

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
                HttpSession oldSession = request.getSession(false);
                if (oldSession != null) {
                    oldSession.invalidate();
                }
                //generate a new session
                HttpSession newSession = request.getSession(true);

                //setting session to expiry in 5 mins
                newSession.setMaxInactiveInterval(5*60);

                Cookie message = new Cookie("message", "Welcome");
                response.addCookie(message);

                request.getRequestDispatcher("jsp/home.jsp").forward(request,response);
            }else
                request.getRequestDispatcher("index.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ma home ma aaye");

        String page = request.getParameter("q");
        if (page.equalsIgnoreCase("home"))
        {
            request.getRequestDispatcher("jsp/home.jsp").forward(request,response);
        }
    }
}
