/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.game;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.GameService;

/**
 * @author ppapakostas
 */
@WebServlet(name = "DeleteGameServlet", urlPatterns = {"/game/delete"})
public class DeleteGameServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int role = (int) request.getSession().getAttribute("role");
        if (role == 1) {
            GameService service = new GameService();
            int gameId = Integer.parseInt(request.getParameter("id"));
            service.delete(gameId);
            request.setAttribute("message", "Game deleted successfully");
        } else {
            request.setAttribute("message", "You don't have permissions to delete a game");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listGame");
        dispatcher.forward(request, response);
    }
}
