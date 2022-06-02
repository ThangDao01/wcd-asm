package com.example.asm_jstl.controller.user;

import com.example.asm_jstl.dao.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

    @WebServlet(name = "DeleteUserServlet", value = "/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
    UserDao dao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("messenger","Delete all user" + deleteAllUser());
        request.setAttribute("users",null);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            dao.deleteUser(new int[]{Integer.parseInt(request.getParameter("id"))});
    }

    protected String deleteUser(int[] listId) {

        return dao.deleteUser(listId);
    }

    protected String deleteAllUser() {
        return dao.deleteAllUser();
    }
}
