package com.isai.webapp.form.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/registro")
public class FormServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //parametros que vamos a utilizar 
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("       <title>Resultado del formulario.</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("   <h1>Resultado del formulario.</h1>");
            out.println("   <ul>");
            out.println("       <li> Username: " + username + "</li>");
            out.println("<li> Password: " + password + "</li>");
            out.println("       <li> Email:   " + email + "</li>");
            out.println("   </ul>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
