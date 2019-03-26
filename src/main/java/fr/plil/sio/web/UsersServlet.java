package fr.plil.sio.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/users/*"})
public class UsersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserRepository userRepository = (UserRepository) getServletContext().getAttribute("userRepository");

        String login = request.getPathInfo().substring(1);
        User user = userRepository.getUserByLogin(login);

        if (user == null) {
            response.sendError(response.SC_NOT_FOUND);
        } else {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            try {
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Users</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>User Information</h1>");
                out.println("<p>user: " + user.getLogin() + "</p>");
                out.println("<p>password: " + user.getPassword() + "</p>");
                out.println("</body>");
                out.println("</html>");
            } finally {
                out.close();
            }
        }
    }
}
