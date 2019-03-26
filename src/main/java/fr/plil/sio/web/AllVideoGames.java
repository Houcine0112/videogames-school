/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.plil.sio.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lelaidou
 */
@WebServlet(name = "AllVideoGames", urlPatterns = {"/AllVideoGames"})
public class AllVideoGames extends HttpServlet {

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
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        VideoGamesRepository videoGamesRepository = (VideoGamesRepository) getServletContext().getAttribute("videoGamesRepository");
        List<VideoGame> videoGames = videoGamesRepository.getVideoGames();
        int page = 1;
        if (request.getParameter("page") != null) {
            if(Integer.parseInt(request.getParameter("page"))<1673){
                page = Integer.parseInt(request.getParameter("page"));
            }
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Les videoGames</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Les videoGames</h1>"); 
            out.println("<table>");
            VideoGame head = videoGames.get(0);
            out.println("<tr>");
            out.println("<td> # </td>");
            for(String d : head.getData()){
                out.println("<td>"+d+"</td>");
            }
            out.println("</tr>");
            for (int i=page*10 -10; i < page*10 + 1 ; i++){
                VideoGame v = videoGames.get(i);
                out.println("<tr>");
                out.println("<td>"+i+"</td>");
                for(String d : v.getData()){
                    out.println("<td>"+d+"</td>");
                }
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("<form action='/AllVideoGames' method='get'>");
            out.println("<table>");
            out.println("<tr>");        
            out.println("<td>page</td>");            
            out.println("<td><input type='text' name='page'></td>");
            out.println("</tr>");        
            out.println("</table>");
            out.println("<input type=\"submit\" value=\"Send\">");    
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
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
