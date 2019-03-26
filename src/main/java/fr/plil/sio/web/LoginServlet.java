package fr.plil.sio.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserRepository userRepository = (UserRepository) getServletContext().getAttribute("userRepository");

        RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (login == null || password == null) {
            request.setAttribute("message", "Login and/or password error");
        } else {
            User user = userRepository.getUserByLogin(login);

            if (user != null && user.getPassword().equals(password)) {
                HttpSession session = request.getSession(true);
                session.setAttribute("user", user);
                request.setAttribute("message","Login successful");
            } else {
                request.setAttribute("message", "Login failed");
            }
        }
        rd.forward(request, response);
    }
}
