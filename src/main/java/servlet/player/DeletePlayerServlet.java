package servlet.player;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.PlayerService;

/**
 * @author ppapakostas
 */
@WebServlet(name = "DeletePlayerServlet", urlPatterns = {"/player/delete"})
public class DeletePlayerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idNumber = Integer.parseInt(request.getParameter("id"));
        PlayerService service = new PlayerService();
        service.delete(idNumber);
        response.sendRedirect("../players");
    }

}
