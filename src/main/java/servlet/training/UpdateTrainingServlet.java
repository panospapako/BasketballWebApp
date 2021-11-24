/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.training;

import entity.Stadium;
import entity.Training;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.TrainingService;

/**
 * @author ppapakostas
 */
@WebServlet(name = "UpdateTrainingServlet", urlPatterns = {"/training/updateTraining"})
public class UpdateTrainingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TrainingService service = new TrainingService();
        int trainId = Integer.parseInt(request.getParameter("id"));
        Training training = service.getTrainingById(trainId);
        request.setAttribute("training", training);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/training/formTraining.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TrainingService service = new TrainingService();
        int trainId = Integer.parseInt(request.getParameter("trainId"));
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime tDateTime = LocalDateTime.parse(request.getParameter("tDateTime"));
        service.update(trainId, tDateTime);
        request.setAttribute("message", "Training updated successfully");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listTraining");
        dispatcher.forward(request, response);
    }
}
