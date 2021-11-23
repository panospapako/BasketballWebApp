/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.coach;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CoachService;

/**
 * @author ppapakostas
 */
@WebServlet(name = "DeleteCoachServlet", urlPatterns = {"/coach/delete"})
public class DeleteCoachServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idNumber = Integer.parseInt(request.getParameter("id"));
        CoachService service = new CoachService();
        service.delete(idNumber);
        response.sendRedirect("../coaches");
    }
}
