/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.plil.sio.web;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lelaidou
 */
@WebServlet(urlPatterns = {"/api/videoGames/all"})
public class ListVideoGames extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String sortedBy = "id";
        if (request.getParameter("sortedBy") != null) {
                sortedBy = request.getParameter("sortedBy");
        }
        Boolean rev = false;
        if (request.getParameter("rev") != null) {
            rev = Boolean.parseBoolean(request.getParameter("rev"));
        }
        int page = 1;
        int nb_elem = 10;
        if (request.getParameter("page") != null) {
            if(Integer.parseInt(request.getParameter("page"))<1673){
                page = Integer.parseInt(request.getParameter("page"));
            }
        }
        if (request.getParameter("nb_elem") != null) {
            if(Integer.parseInt(request.getParameter("nb_elem"))<10000){
                nb_elem = Integer.parseInt(request.getParameter("nb_elem"));
            }
        }
        
        
        
        response.setContentType("text/json;charset=UTF-8");
        VideoGamesRepository videoGamesRepository = (VideoGamesRepository) getServletContext().getAttribute("videoGamesRepository");
        List<VideoGame> videoGames = videoGamesRepository.getSortedBy(sortedBy, rev).subList(nb_elem*(page-1), page*nb_elem);
        
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        
        String json = gson.toJson(videoGames);
        
        PrintWriter out = response.getWriter();
        out.println(json);
        
        
    }
}

