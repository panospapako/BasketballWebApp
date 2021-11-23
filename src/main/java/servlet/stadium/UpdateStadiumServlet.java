/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.stadium;

import entity.Stadium;

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
@WebServlet(name = "UpdateStadiumServlet", urlPatterns = {"/stadium/updateStadium"})
public class UpdateStadiumServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StadiumService service = new StadiumService();
        int stadId = Integer.parseInt(request.getParameter("id"));
        Stadium stadium = service.getStadiumById(stadId);
        request.setAttribute("stadium", stadium);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/stadium/formStadium.jsp");
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StadiumService service = new StadiumService();
        int stadId = Integer.parseInt(request.getParameter("stadId"));
        String sName = request.getParameter("sName");
        String location = request.getParameter("location");
        int capacity = Integer.parseInt(request.getParameter("capacity"));
        service.update(stadId, sName, location, capacity);
        request.setAttribute("message", "Stadium updated successfully");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listStadium");
        dispatcher.forward(request, response);
    }


}        