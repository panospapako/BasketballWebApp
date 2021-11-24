/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.game;

import entity.Game;
import entity.Training;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.GameService;
import service.TrainingService;

/**
 * @author ppapakostas
 */
@WebServlet(name = "UpdateGameServlet", urlPatterns = {"/game/updateGame"})
public class UpdateGameServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GameService service = new GameService();
        int gameId = Integer.parseInt(request.getParameter("id"));
        Game game = service.getGameById(gameId);
        request.setAttribute("game", game);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/game/formGame.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GameService service = new GameService();
        service.create(request.getParameterMap());
        request.setAttribute("message", "Game updated successfully");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listGame");
        dispatcher.forward(request, response);
    }
}
