/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.player;

import entity.Player;

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
@WebServlet(name = "UpdatePlayerServlet", urlPatterns = {"/player/update"})
public class UpdatePlayerServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdatePlayerServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdatePlayerServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idNumber = Integer.parseInt(request.getParameter("id"));
        PlayerService service = new PlayerService();
        Player player = service.getPlayerById(idNumber);
        StringBuilder builder = new StringBuilder();
        String contextPath = request.getContextPath();
        builder.append("<!DOCTYPE html>")
                .append("<html>")
                .append("<head>")
                .append("<title>Update Player</title>")
                .append("</head>")
                .append("</body>")
                .append("<h1>Update PLayer<h1>")
                .append("<form action= \"").append(contextPath).append("/player/update\" method= \"post\">")
                .append("IdNumber:").append("<input type=\"text\" name=\"id\" value=\"").append(player.getIdNumber()).append("\" readonly>")
                .append("<br/>")
                .append("Lname:").append("<input type=\"text\" name=\"lName\"value=\"").append(player.getLName()).append("\">")
                .append("<br/>")
                .append("Fname:").append("<input type=\"text\" name=\"fName\"value=\"").append(player.getFName()).append("\">")
                .append("<br/>")
                .append("Date Of Birth:").append("<input type=\"text\" name=\"dateOfBirth\"value=\"").append(player.getDateOfBirth()).append("\">")
                .append("<br/>")
                .append("Weight:").append("<input type=\"text\" name=\"weight\"value=\"").append(player.getWeight()).append("\">")
                .append("<br/>")
                .append("Height:").append("<input type=\"text\" name=\"height\"value=\"").append(player.getHeight()).append("\">")
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
        int id = Integer.parseInt(request.getParameter("id"));
        service.update(id, lName, fName, dateOfBirth, weight, height);
        RequestDispatcher dispatcher = request.getRequestDispatcher("../players");
        dispatcher.forward(request, response);
    }

}
