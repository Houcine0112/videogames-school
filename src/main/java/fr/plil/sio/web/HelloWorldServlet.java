package fr.plil.sio.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/helloWorld"})
public class HelloWorldServlet extends HttpServlet {
   
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Hello World</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Hello WorldServlet</h1>");
            out.println("<h2>Request</h2>");
            out.println("<p><b>Context Path:</b> " + request.getContextPath () + "</p>");
            out.println("<p><b>Method:</b> " + request.getMethod() + "</p>");
            out.println("<p><b>Request URL:</b> " + request.getRequestURL() + "</p>");
            out.println("<p><b>Servlet Path:</b> " + request.getServletPath() + "</p>");
            out.println("<p><b>Headers:</b></p>");
            Enumeration e = request.getHeaderNames();
            out.println("<table>");
            while(e.hasMoreElements()) {
                String headerName = (String) e.nextElement();
                out.println("<tr><td>" + headerName +"</td><td>"
                        + request.getHeader(headerName)+ "</td></tr>");
            }
            out.println("</table>");
            out.println("<p><b>Parameters:</b></p>");
            e = request.getParameterNames();
            out.println("<table>");
            while(e.hasMoreElements()) {
                String parameterName = (String) e.nextElement();
                out.println("<tr><td>" + parameterName +"</td><td>"
                        + request.getParameter(parameterName)+ "</td></tr>");
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        } finally { 
            out.close();
        }
    } 
}
