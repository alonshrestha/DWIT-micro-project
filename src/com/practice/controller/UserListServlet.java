package com.practice.controller;

import com.practice.model.Host;
import com.practice.model.Reports;
import com.practice.model.Users;
import com.practice.service.HostService;
import com.practice.service.ReportService;
import com.practice.service.UserListService;
import javafx.beans.property.ReadOnlyListProperty;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserListServlet")
public class UserListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        String page = request.getParameter("q");
        if (page.equalsIgnoreCase("listUser")) {

            List<Users> usersList = new UserListService().listUser();
            System.out.println("ma ya aaye");

            request.setAttribute("u", usersList);


            RequestDispatcher rd = request.getRequestDispatcher("jsp/listUser.jsp");
            rd.forward(request, response);
        }

        if (page.equalsIgnoreCase("deleteUser")) {
            int id = Integer.parseInt(request.getParameter("id"));

            new UserListService().delete(id);
            List<Users> userList = new UserListService().listUser();
            request.setAttribute("u", userList);
            RequestDispatcher rd = request.getRequestDispatcher("jsp/listUser.jsp");
            rd.forward(request, response);
        }

        if (page.equalsIgnoreCase("editUser")) {
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("i", id);
            System.out.println(id);
            System.out.println("id payee");
            request.getRequestDispatcher("jsp/editUser.jsp").forward(request, response);
        }

/*----------------------------------__________-----------------_____________----------______----_____---_____-------_____--*/


        }





    }


