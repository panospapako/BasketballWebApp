package servlet.player;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.PlayerService;

/**
 * @author ppapakostas
 */
@WebServlet(name = "CreatePlayerServlet", urlPatterns = {"/player/insert"})
public class CreatePlayerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StringBuilder builder = new StringBuilder();
        String contextPath = request.getContextPath();
        builder.append("<!DOCTYPE html>")
                .append("<html>")
                .append("<head>")
                .append("<title>Insert Player</title>")
                .append("</head>")
                .append("</body>")
                .append("<h1>New PLayer<h1>")
                .append("<form action= \"").append(contextPath).append("/player/insert\" method= \"post\">")
                .append("Lname:").append("<input type=\"text\" name=\"lName\">")
                .append("Fname:").append("<input type=\"text\" name=\"fName\">")
                .append("Date Of Birth:").append("<input type=\"text\" name=\"dateOfBirth\">")
                .append("Weight:").append("<input type=\"text\" name=\"weight\">")
                .append("Height:").append("<input type=\"text\" name=\"height\">")
                .append("<br/>")
                .append("<input type=\"submit\" value=\"Submit\">")
                .append("</form>")
                .append("</body>")
                .append("</html>");

        PrintWriter out = response.getWriter();
        out.println(builder);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PlayerService service = new PlayerService();
        String lName = request.getParameter("lName");
        String fName = request.getParameter("fName");
        LocalDate dateOfBirth = LocalDate.parse(request.getParameter("dateOfBirth"));
        Integer weight = Integer.parseInt(request.getParameter("weight"));
        Integer height = Integer.parseInt(request.getParameter("height"));
        service.create(lName, fName, dateOfBirth, weight, height);
        RequestDispatcher dispatcher = request.getRequestDispatcher("../players");
        dispatcher.forward(request, response);
    }

}
