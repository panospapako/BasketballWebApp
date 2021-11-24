/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.playertraining;

/**
 * @author ppapakostas
 */

import entity.Player;
import entity.PlayerTraining;
import entity.Training;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.PlayerTrainingService;

@WebServlet(name = "CreatePlayerServlet", urlPatterns = {"/playertraining/createPlayerTraining"})
public class CreatePlayerTrainingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PlayerTrainingService service = new PlayerTrainingService();

        //List<Training> listOfTraining = service.listOfTraining();
        int trainId = Integer.parseInt(request.getParameter("trainId"));
        Training training = service.getTrainingById(trainId);
//        List<Player> listOfPlayerWhoNotParticipate = service.listOfPlayerWhoNotParticipate(trainId);
        List<PlayerTraining> listOfParticipant = service.getParticipants(trainId);

//        request.setAttribute("listOfPlayerWhoNotParticipate", listOfPlayerWhoNotParticipate);
        //request.setAttribute("listOfTraining", listOfTraining);
        request.setAttribute("training", training);

        request.setAttribute("listOfParticipant", listOfParticipant);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/playertraining/formPlayerTraining.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PlayerTrainingService service = new PlayerTrainingService();
        service.create(request.getParameterMap());
        request.setAttribute("message", "PlayerTraining created successfully");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listPlayerTraining");
        dispatcher.forward(request, response);
    }
}
