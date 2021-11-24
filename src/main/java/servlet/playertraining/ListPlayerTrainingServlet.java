/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.playertraining;

/**
 * @author ppapakostas
 */

import entity.PlayerTraining;
import entity.Training;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.PlayerTrainingService;

@WebServlet(name = "ListPlayerTrainingServlet", urlPatterns = {"/listPlayerTraining"})
public class ListPlayerTrainingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PlayerTrainingService service = new PlayerTrainingService();
        int trainId = Integer.parseInt(request.getParameter("training"));
        System.out.println("trainID: " + trainId);
        List<PlayerTraining> listOfParticipants = service.getParticipants(trainId);
        request.setAttribute("listOfParticipants", listOfParticipants);
        Training training = service.getTrainingById(trainId);
        request.setAttribute("training", training);
        System.out.println("training: " + training);
        RequestDispatcher dispatcher = request.getRequestDispatcher("playertraining/listPlayerTraining.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
