package com.isai.webapp.form.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/registro")
public class FormServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //parametros que vamos a utilizar 
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String pais = request.getParameter("pais");
        String[] lenguajes = request.getParameterValues("lenguajes");
        String[] roles = request.getParameterValues("roles");
        String idioma = request.getParameter("idioma");
        boolean habilitar = request.getParameter("habilitar") != null
                && request.getParameter("habilitar").equals("on");
        String secreto = request.getParameter("secreto");

        List<String> errores = new ArrayList<>();

        if (username == null || username.isBlank()) {
            errores.add("El user name es requerido.");
        }
        if (password == null || password.isBlank()) {
            errores.add("El password no puede ser vacio.");
        }
        if (email == null || !email.contains("@")) {
            errores.add("El email es requerido y debe tener formato de correo.");
        }
        if (pais == null || pais.isBlank() || pais.equals("")) {
            errores.add("El pais es requerido.");
        }
        if (lenguajes == null || lenguajes.length == 0) {
            errores.add("El lenguaje es querido. Debe seleccionar almenos un tema.");
        }
        if (roles == null || roles.length == 0) {
            errores.add("Debe seleccionar al menos un rol.");
        }
        if (idioma == null) {
            errores.add("Debe seleccionar un idioma.");
        }
        response.setContentType("text/html;charset=UTF-8");
        if (errores.isEmpty()) {
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
                out.println("       <li> Password: " + password + "</li>");
                out.println("       <li> Email:   " + email + "</li>");
                out.println("       <li> Pais:   " + pais + "</li>");
                out.print("         <li>Lenguajes: <ul>");
                Arrays.asList(lenguajes).forEach(lenguaje -> {
                    out.println("       <li> Lenguaje:   " + lenguaje + "</li>");
                });
                out.print("         </ul></li>");

                out.print("         <li>Roles: <ul>");
                Arrays.asList(roles).forEach(rol -> {
                    out.println("       <li> Rol:   " + rol + "</li>");
                });
                out.print("         </ul></li>");
                out.println("       <li> Idioma: " + idioma + "</li>");
                out.println("       <li> Habilitado:   " + habilitar + "</li>");
                out.println("       <li> Secreto:   " + secreto + "</li>");
                out.println("   </ul>");
                out.println("</body>");
                out.println("</html>");
            }
        } else {
            /*  errores.forEach((t) -> {
                    out.println("<li>" + t + "</li>");
                });
                out.println("<p><a href = \"/clase02formularios/index.html\">Volver</p>");*/
            request.setAttribute("errores", errores);
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

}
