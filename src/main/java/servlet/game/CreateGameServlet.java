/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.game;

import entity.Stadium;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
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
@WebServlet(name = "CreateGameServlet", urlPatterns = {"/game/insert"})
public class CreateGameServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispacher = request.getRequestDispatcher("/game/formGame.jsp");
        GameService service = new GameService();
        List<Stadium> listOfStadium = service.getStadiums();
        request.setAttribute("listOfStadium", listOfStadium);
        dispacher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GameService service = new GameService();
        service.create(request.getParameterMap());
        request.setAttribute("message", "Game created successfully");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listGame");
        dispatcher.forward(request, response);
    }
}
