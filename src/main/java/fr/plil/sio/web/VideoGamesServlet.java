/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.plil.sio.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lelaidou
 */
@WebServlet(name = "VideoGamesServlet", urlPatterns = {"/videoGamesStatic"})
public class VideoGamesServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        VideoGamesRepository videoGamesRepository = (VideoGamesRepository) getServletContext()
                .getAttribute("videoGamesRepository");

        RequestDispatcher rd = request.getRequestDispatcher("/videoGamesStatic.jsp");

        int nb_rows = 5;
        int page = 1;
        if (request.getParameter("page") != null && !request.getParameter("page").equals("")) {
            if (Integer.parseInt(request.getParameter("page")) < 16719 / nb_rows) {
                page = Integer.parseInt(request.getParameter("page"));
            }
        }

        int fin = page * nb_rows;
        int deb = fin - nb_rows;
        List<VideoGame> videoGames = videoGamesRepository.getVideoGames();
        List<List<String>> data = new ArrayList<>();
        for (int i = deb; i < fin; i++) {
            VideoGame v = videoGames.get(i);
            data.add(v.getData());
        }
        request.setAttribute("data", data);
        rd.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
