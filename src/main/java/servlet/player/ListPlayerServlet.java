/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.player;

import entity.Player;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.PlayerService;

/**
 * @author ppapakostas
 */
@WebServlet(name = "ListPlayerServlet", urlPatterns = {"/players"})
public class ListPlayerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String contextPath = request.getContextPath();


        PlayerService service = new PlayerService();
        List<Player> listOfPlayers = service.getPlayers();
        StringBuilder builder = new StringBuilder();
        builder.append("<!DOCTYPE html>")
                .append("<html>")
                .append("<head>")
                .append("<title>List of Players</title>")
                .append("</head>")
                .append("</body>")
                .append("<h1>Players<h1>")
                .append("<a href=\"").append(contextPath).append("/player/insert\">New Player</a>")
                .append("<table border=\"1\">");
        for (Player p : listOfPlayers) {
            builder.append("<tr/>")
                    .append("<td>").append(p.getIdNumber()).append("</td>")
                    .append("<td>").append(p.getLName()).append("</td>")
                    .append("<td>").append(p.getFName()).append("</td>")
                    .append("<td>").append(p.getDateOfBirth()).append("</td>")
                    .append("<td>").append(p.getWeight()).append("</td>")
                    .append("<td>").append(p.getHeight()).append("</td>")
                    .append("<td>").append("<a href=\"").append(contextPath).append("/player/update?id=").append(p.getIdNumber()).append("\">update</a>").append("</td>")
                    .append("<td>").append("<a href=\"").append(contextPath).append("/player/delete?id=").append(p.getIdNumber()).append("\">delete</a>").append("</td>")
                    .append("</tr>");
        }

        builder.append("</table>")
                .append("</body>")
                .append("</html>");

        PrintWriter out = response.getWriter();
//        out.println("hello");
        out.println(builder);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
