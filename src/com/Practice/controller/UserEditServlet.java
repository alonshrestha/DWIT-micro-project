package com.Practice.controller;

import com.Practice.model.Users;
import com.Practice.service.UserEditService;
import com.Practice.service.UserListService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserEditServlet")
public class UserEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String UserID= request.getParameter("id");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        int id = Integer.parseInt(UserID);
        System.out.println(id);
        System.out.println(UserID);
        System.out.println(name);
        System.out.println(email);
        System.out.println(password);

        Users user = new Users();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        System.out.println("ok ok ok ok ");
        boolean isUpdate = new UserEditService().editUser(user);
        if (isUpdate) {
            List<Users> userList = new UserListService().listUser();
            request.setAttribute("u", userList);
            request.getRequestDispatcher("jsp/listUser.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("jsp/editUser.jsp").forward(request, response);
        }




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
