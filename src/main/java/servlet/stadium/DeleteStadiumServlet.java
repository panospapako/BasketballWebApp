/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.stadium;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.StadiumService;

/**
 * @author ppapakostas
 */
@WebServlet(name = "DeleteStadiumServlet", urlPatterns = {"/stadium/delete"})
public class DeleteStadiumServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int role = (int) request.getSession().getAttribute("role");
        if (role == 1) {
            StadiumService service = new StadiumService();
            int stadId = Integer.parseInt(request.getParameter("id"));
            service.delete(stadId);
            request.setAttribute("message", "Stadium deleted successfully");
        } else {
            request.setAttribute("message", "You don't have permissions to delete a stadium");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listStadium");
        dispatcher.forward(request, response);
    }
}
