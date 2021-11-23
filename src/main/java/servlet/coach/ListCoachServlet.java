/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.coach;

import entity.Coach;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CoachService;

/**
 * @author ppapakostas
 */
@WebServlet(name = "ListCoachServlet", urlPatterns = {"/coaches"})
public class ListCoachServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String contextPath = request.getContextPath();
        CoachService service = new CoachService();
        List<Coach> listOfCoaches = service.getCoaches();
        StringBuilder builder = new StringBuilder();
        builder.append("<!DOCTYPE html>")
                .append("<html>")
                .append("<head>")
                .append("<title>List of Coaches</title>")
                .append("</head>")
                .append("</body>")
                .append("<h1>Coaches<h1>")
                .append("<a href=\"").append(contextPath).append("/coach/insert\">New Coach</a>")
                .append("<table border=\"1\">");
        for (Coach c : listOfCoaches) {
            builder.append("<tr/>")
                    .append("<td>").append(c.getIdNumber()).append("</td>")
                    .append("<td>").append(c.getLName()).append("</td>")
                    .append("<td>").append(c.getFName()).append("</td>")
                    .append("<td>").append("<a href=\"").append(contextPath).append("/coach/update?id=").append(c.getIdNumber()).append("\">update</a>").append("</td>")
                    .append("<td>").append("<a href=\"").append(contextPath).append("/coach/delete?id=").append(c.getIdNumber()).append("\">delete</a>").append("</td>")
                    .append("</tr>");
        }

        builder.append("</table>")
                .append("</body>")
                .append("</html>");

        PrintWriter out = response.getWriter();
        out.println(builder);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
