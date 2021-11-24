/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.game;

import entity.Game;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.GameService;

/**
 * @author ppapakostas
 */
@WebServlet(name = "ListGameServlet", urlPatterns = {"/listGame"})
public class ListGameServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GameService service = new GameService();
        List<Game> listOfGames = service.getGames();
        HttpSession session = request.getSession();
        request.setAttribute("role", session.getAttribute("role"));
        request.setAttribute("gameList", listOfGames);
        RequestDispatcher dispatcher = request.getRequestDispatcher("game/listGame.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
