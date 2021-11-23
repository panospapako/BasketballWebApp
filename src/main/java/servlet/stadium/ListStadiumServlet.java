/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.stadium;

import entity.Stadium;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import service.StadiumService;

/**
 * @author ppapakostas
 */
@WebServlet(name = "ListStadiumServlet", urlPatterns = {"/listStadium"})
public class ListStadiumServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StadiumService service = new StadiumService();
        List<Stadium> listOfStadiums = service.getStadiums();
        for (int i=0; i<listOfStadiums.size();i++){
        System.out.println(listOfStadiums.get(i).toString());
        }
        HttpSession session = request.getSession();
        request.setAttribute("role", session.getAttribute("role"));
        request.setAttribute("stadiumList", listOfStadiums);
        RequestDispatcher dispatcher = request.getRequestDispatcher("stadium/listStadium.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
