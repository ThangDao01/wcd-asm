package com.example.asm_jstl.controller.user;

import com.example.asm_jstl.dao.UserDao;
import com.example.asm_jstl.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddUserServlet", value = "/AddUserServlet")
public class AddUserServlet extends HttpServlet {
    UserDao dao = new UserDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            User user = new User();
            user.setName(request.getParameter("username"));
            user.setEmail(request.getParameter("email"));
            user.setAddress(request.getParameter("address"));
            user.setPhone(request.getParameter("phone"));
            String msg =dao.insertUser(user);
            String redirectURL = "/UserServlet";
            request.setAttribute("messenger",msg);
            response.sendRedirect(redirectURL);
    }
}
