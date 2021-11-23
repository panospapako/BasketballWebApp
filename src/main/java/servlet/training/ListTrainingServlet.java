/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.training;

import entities.Training;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.TrainingService;

/**
 * @author ppapakostas
 */
@WebServlet(name = "ListTrainingServlet", urlPatterns = {"/listTraining"})
public class ListTrainingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TrainingService service = new TrainingService();
        List<Training> listOfTrainings = service.getTrainings();
        HttpSession session = request.getSession();
        request.setAttribute("role", session.getAttribute("role"));
        request.setAttribute("trainingList", listOfTrainings);
        RequestDispatcher dispatcher = request.getRequestDispatcher("training/listTraining.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
