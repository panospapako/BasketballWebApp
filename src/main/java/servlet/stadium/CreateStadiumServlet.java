/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.stadium;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "CreateStadiumServlet", urlPatterns = {"/stadium/insert"})
public class CreateStadiumServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispacher = request.getRequestDispatcher("/stadium/formStadium.jsp");
        dispacher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StadiumService service = new StadiumService();
        String sName = request.getParameter("sName");
        String location = request.getParameter("location");
        String capacityStr = request.getParameter("capacity");
        Integer capacity = Integer.parseInt(capacityStr);
        service.create(sName, location, capacity);
        request.setAttribute("message", "Stadium created successfully");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listStadium");
        dispatcher.forward(request, response);
    }

}
