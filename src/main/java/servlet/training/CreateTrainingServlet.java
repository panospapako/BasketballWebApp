/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.training;

import java.io.IOException;
import java.time.LocalDateTime;
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
@WebServlet(name = "CreateTrainingServlet", urlPatterns = {"/training/insert"})
public class CreateTrainingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispacher = request.getRequestDispatcher("/training/formTraining.jsp");
        dispacher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TrainingService service = new TrainingService();
        LocalDateTime tDateTime = LocalDateTime.parse(request.getParameter("tDateTime"));
        service.create(tDateTime);
        request.setAttribute("message", "Training created successfully");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listTraining");
        dispatcher.forward(request, response);
    }


}
