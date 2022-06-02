package com.example.asm_jstl.controller;

import com.example.asm_jstl.dao.UserDao;
import com.example.asm_jstl.model.User;
import jdk.nashorn.internal.ir.RuntimeNode;
import sun.misc.Request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

public class UserServlet extends HttpServlet {
    UserDao dao = new UserDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String msg = insertUser();
        request.setAttribute("messenger",null);
        request.setAttribute("users",getListUser());
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected List<User> getListUser(){
        return  dao.getAllUser();
    }
    protected String updateUser(HttpServletRequest request){
        User user = new User();
//        user.setName(request.getParameter("username"));
//        user.setEmail(request.getParameter("email"));
//        user.setAddress(request.getParameter("address"));
//        user.setPhone(request.getParameter("phone"));
        user.setId(0);
        user.setName("testing011");
        user.setEmail("testing011");
        user.setAddress("testing011");
        user.setPhone("testing011");
        return dao.updateUser(user);
    }

    protected String insertUser(){
        User user = new User();
        user.setName("test12345");
        user.setEmail("test12345");
        user.setPhone("test12345");
        user.setAddress("test12345");
        return dao.insertUser(user);
    }
}
