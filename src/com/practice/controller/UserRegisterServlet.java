package com.practice.controller;

import com.practice.model.Users;
import com.practice.service.UserCheckService;
import com.practice.service.UserRegisterService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("aayo ya");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String pass1 = request.getParameter("password1");
        String pass2 = request.getParameter("password2");
        String password = "";
        if (pass1.equals(pass2)) {
            password = pass1;
            System.out.printf(password);
        } else

            request.getRequestDispatcher("jsp/register.jsp");
        System.out.println("ya samma ni aayo ");
        Users user = new Users();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

        boolean isUserSame = new UserCheckService().CheckUserSame(user);
        if (isUserSame) {
            request.getRequestDispatcher("jsp/test.jsp").forward(request, response);
                  }else {

                   boolean isInserted = new UserRegisterService().addUser(user);

                if (isInserted) {
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                } else
                    request.getRequestDispatcher("jsp/register.jsp").forward(request, response);

    }

            }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String page = request.getParameter("q");

        if(page.equalsIgnoreCase("register")){
            request.getRequestDispatcher("jsp/register.jsp").forward(request,response);
        }
    }

    }
