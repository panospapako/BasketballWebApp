/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.login;

import entity.User;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

/**
 * @author ppapakostas
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"},
        initParams = {
                @WebInitParam(name = "username", value = "Invalid"),
                @WebInitParam(name = "password", value = "Too short")
        })

public class LoginServlet extends HttpServlet {

    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserService service = new UserService();
        User user = service.getUserByUserName(username);
        if (user == null) {
            String message = "The user does not exist!";
            request.setAttribute("message", message);
            request.setAttribute("username", getInitParameter("username"));
            request.setAttribute("password", getInitParameter("password"));
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.include(request, response);
        } else {
            boolean isLogin = (username.equals(user.getUsername())) && (password.equals(user.getPassword()));
            if (isLogin) {
                request.getSession().setAttribute("username", username);
                request.getSession().setAttribute("role", user.getRole());
                RequestDispatcher dispatcher = request.getRequestDispatcher("/");
                dispatcher.forward(request, response);
            } else {
                String message = "Login failed!";
                request.setAttribute("message", message);
                request.setAttribute("username", getInitParameter("username"));
                request.setAttribute("password", getInitParameter("password"));
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.include(request, response);

            }
        }
    }
}
