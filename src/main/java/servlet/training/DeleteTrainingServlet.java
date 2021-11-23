/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.training;

import java.io.IOException;
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
@WebServlet(name = "DeleteTrainingServlet", urlPatterns = {"/training/delete"})
public class DeleteTrainingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int role = (int) request.getSession().getAttribute("role");
        if (role == 1) {
            TrainingService service = new TrainingService();
            int trainId = Integer.parseInt(request.getParameter("id"));
            service.delete(trainId);
            request.setAttribute("message", "Training deleted successfully");
        } else {
            request.setAttribute("message", "You don't have permissions to delete a training");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listTraining");
        dispatcher.forward(request, response);
    }
}
