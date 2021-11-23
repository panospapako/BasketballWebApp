/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.coach;

import entity.Coach;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CoachService;

/**
 * @author ppapakostas
 */
@WebServlet(name = "UpdateCoachServlet", urlPatterns = {"/coach/update"})
public class UpdateCoachServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateCoachServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateCoachServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idNumber = Integer.parseInt(request.getParameter("id"));
        CoachService service = new CoachService();
        Coach coach = service.getCoachById(idNumber);
        StringBuilder builder = new StringBuilder();
        String contextPath = request.getContextPath();
        builder.append("<!DOCTYPE html>")
                .append("<html>")
                .append("<head>")
                .append("<title>Update Coach</title>")
                .append("</head>")
                .append("</body>")
                .append("<h1>Update Coach<h1>")
                .append("<form action= \"").append(contextPath).append("/coach/update\" method= \"post\">")
                .append("IdNumber:").append("<input type=\"text\" name=\"id\" value=\"").append(coach.getIdNumber()).append("\" readonly>")
                .append("<br/>")
                .append("Lname:").append("<input type=\"text\" name=\"lName\"value=\"").append(coach.getLName()).append("\">")
                .append("<br/>")
                .append("Fname:").append("<input type=\"text\" name=\"fName\"value=\"").append(coach.getFName()).append("\">")
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
        CoachService service = new CoachService();
        String lName = request.getParameter("lName");
        String fName = request.getParameter("fName");
        int id = Integer.parseInt(request.getParameter("id"));
        service.update(id, lName, fName);
        RequestDispatcher dispatcher = request.getRequestDispatcher("../coaches");
        dispatcher.forward(request, response);
    }
}
