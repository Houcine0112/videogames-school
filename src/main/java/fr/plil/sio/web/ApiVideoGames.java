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
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author lelaidou
 */
@WebServlet(urlPatterns = {"/api/videoGames/*"})
public class ApiVideoGames extends HttpServlet {

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
        VideoGamesRepository videoGamesRepository = (VideoGamesRepository) getServletContext().getAttribute("videoGamesRepository");

        // default values if not assigned
        int page = 1;
        int page_rows_nb = 10;
        String sortBy = "id";
        Boolean order_asc = false;

        String sales_type = "Global_Sales";
        String group_field = "Platform";

        String json = "[]";
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        String[] params = request.getRequestURI().split("/");
        if (params.length > 3) {
            if (params[3].equals("all")) {
                try {
                    page = Integer.parseInt(params[4]);
                } catch (Exception e) {
                }
                try {
                    page_rows_nb = Integer.parseInt(params[5]);
                } catch (Exception e) {
                }
                try {
                    sortBy = params[6];
                } catch (Exception e) {
                }
                try {
                    order_asc = Boolean.parseBoolean(params[7]);
                } catch (Exception e) {
                }

                List<VideoGame> videoGames = videoGamesRepository
                        .getSortedBy(sortBy, order_asc)
                        .subList(page_rows_nb * (page - 1), page * page_rows_nb);
                json = gson.toJson(videoGames);

            } else if (params[3].equals("grouped")) {
                try {
                    sales_type = params[4];
                } catch (Exception e) {
                }
                try {
                    group_field = params[5];
                } catch (Exception e) {
                }

                Map<String, Map<Integer, Double>> groupedVideoGames = videoGamesRepository
                        .getGroupedSalesBy(group_field, sales_type);
                Set<Integer> years = new TreeSet<>();
                for (Map<Integer, Double> val : groupedVideoGames.values()) {
                    years.addAll(val.keySet());
                }
                years.remove(0);

                String videoGames_json = gson.toJson(groupedVideoGames);
                String years_json = gson.toJson(years);
                json = "[" + years_json + "," + videoGames_json + "]";

            }
        }
        PrintWriter out = response.getWriter();
        out.println(json);
    }
}

