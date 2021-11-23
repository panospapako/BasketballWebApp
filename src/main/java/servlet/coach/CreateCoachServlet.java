/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.coach;

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
@WebServlet(name = "CreateCoachServlet", urlPatterns = {"/coach/insert"})
public class CreateCoachServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StringBuilder builder = new StringBuilder();
        String contextPath = request.getContextPath();
        builder.append("<!DOCTYPE html>")
                .append("<html>")
                .append("<head>")
                .append("<title>Insert Coach</title>")
                .append("</head>")
                .append("</body>")
                .append("<h1>New Coach<h1>")
                .append("<form action= \"").append(contextPath).append("/coach/insert\" method= \"post\">")
                .append("Lname:").append("<input type=\"text\" name=\"lName\">")
                .append("Fname:").append("<input type=\"text\" name=\"fName\">")
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
        service.create(lName, fName);
        RequestDispatcher dispatcher = request.getRequestDispatcher("../coaches");
        dispatcher.forward(request, response);
    }

}
