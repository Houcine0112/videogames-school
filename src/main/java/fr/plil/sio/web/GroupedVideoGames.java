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
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author lelaidou
 */
@WebServlet(urlPatterns = {"/api/videoGames/grouped"})
public class GroupedVideoGames extends HttpServlet {

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
        String sales_type = "Global_Sales";
        if (request.getParameter("sales_type") != null) sales_type = request.getParameter("sales_type");

        String group_field = "Platform";
        if (request.getParameter("group_field") != null) group_field = request.getParameter("group_field");

        VideoGamesRepository videoGamesRepository = (VideoGamesRepository) getServletContext().getAttribute("videoGamesRepository");
        //Map<String, Map<Integer, List<VideoGame>>> videoGames = videoGamesRepository.getGroupedMapBy();
        Map<String, Map<Integer, Double>> videoGames = videoGamesRepository.getGroupedSalesBy(group_field, sales_type);

        Set<Integer> years = new TreeSet<>();
        for (Map<Integer, Double> val : videoGames.values()) {
            years.addAll(val.keySet());
        }
        years.remove(0);

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        String videoGames_json = gson.toJson(videoGames);
        String years_json = gson.toJson(years);
        PrintWriter out = response.getWriter();
        out.println("[" + years_json + "," + videoGames_json + "]");


    }
}

