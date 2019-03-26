/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.plil.sio.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lelaidou
 */
@WebServlet(urlPatterns = {"/addUser"})
public class addUserServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserRepository userRepository = (UserRepository) getServletContext().getAttribute("userRepository");

        RequestDispatcher rd = request.getRequestDispatcher("/AllUsers");

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (login == null || password == null) {
            request.setAttribute("message", "Login and/or password error");
        } else {
            User user = new User();
            user.setLogin(login);
            user.setPassword(password);
            userRepository.addUser(user);
            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);
            request.setAttribute("message","created successful");
        }
        rd.forward(request, response);
    }

}
