/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.plil.sio.web;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author lelaidou
 */
@WebServlet(urlPatterns = {"/api/videoGames/all"})
public class ListVideoGames extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        // default values if not assigned
        String sortBy = "id";
        Boolean reverse = false;
        int page = 1;
        int page_rows_nb = 10;

        if (request.getParameter("sortBy") != null) sortBy = request.getParameter("sortBy");
        if (request.getParameter("reverse") != null) reverse = Boolean.parseBoolean(request.getParameter("reverse"));
        if (request.getParameter("page_rows_nb") != null) {
            if (Integer.parseInt(request.getParameter("page_rows_nb")) < 16719) {
                page_rows_nb = Integer.parseInt(request.getParameter("page_rows_nb"));
            }
        }
        if (request.getParameter("page") != null) {
            if (Integer.parseInt(request.getParameter("page")) < 16719 / page_rows_nb) {
                page = Integer.parseInt(request.getParameter("page"));
            }
        }


        VideoGamesRepository videoGamesRepository = (VideoGamesRepository) getServletContext().getAttribute("videoGamesRepository");
        List<VideoGame> videoGames = videoGamesRepository.getSortedBy(sortBy, reverse).subList(page_rows_nb * (page - 1), page * page_rows_nb);

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        String json = gson.toJson(videoGames);

        PrintWriter out = response.getWriter();
        out.println(json);


    }
}

