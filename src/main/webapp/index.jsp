<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="java.util.List"%>

<%List<String> errores = (List<String>) request.getAttribute("errores");%> 

<!DOCTYPE html>
<html>
    <head>
        <title>Manejo de Form</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Formulario de Usuarios.</h1>
        <%if(errores != null && errores.size() > 0){%>
        <ul>
            <% for(String  error: errores){%>
            <li> <%=error%></li>
                <%}%>      
        </ul>
        <%}%>      
        <form action="/clase02formularios/registro" method="post">
            <div>
                <label for="username">Usuario: </label>
                <div><input type="text" name="username" id="username"></div>
            </div>
            <div>
                <label for = "password">Password: </label>
                <div><input type="password" name="password" id="password"></div>
            </div>
            <div>
                <label for = "email">Email: </label>
                <div><input type="email" name="email" id="email"></div>
            </div>

            <div>
                <label for = "pais">Pais: </label>
                <div>
                    <select name="pais" id="pais">
                        <option value="">---Seleccionar---</option>
                        <option value="ES">España</option>
                        <option value="MX">México</option>
                        <option value="CL" selected>Chile</option>
                        <option value="AR">Argentina</option>
                        <option value="PE">Perú</option>
                        <option value="CO">Colombia</option>
                        <option value="VE">Venezuela</option>
                    </select>
                </div>
            </div>

            <div>
                <label for = "lenguajes">Lenguajes de programación: </label>
                <div>
                    <!-- para que nos permita selecioanar multiples opciones -->
                    <select name="lenguajes" id="lenguajes" multiple="">
                        <option value="java">Java</option>
                        <option value="jakartaee">Jakarta EE 9</option>
                        <option value="spring">Spring Boot</option>
                        <option value="js">JavaScript</option>
                        <option value="angular">Angular</option>
                        <option value="react">React</option>
                    </select>
                </div>
            </div>

            <div>   
                <label>Roles:</label>
                <div> 
                    <input type="checkbox" name="roles" value="ROLE_ADMIN">
                    <label>Administrador</label>
                </div>
                <div> 
                    <input type="checkbox" name="roles" value="ROLE_USER">
                    <label>Usuario</label>
                </div>
                <div> 
                    <input type="checkbox" name="roles" value="ROLE_MODERATOR">
                    <label>Moderador</label>
                </div>
            </div>

            <div>
                <label>Idiomas.</label>
                <div>
                    <input type="radio" name="idioma" value="es">
                    <label>Español</label>
                </div>
                <div>
                    <input type="radio" name="idioma" value="en">
                    <label>Ingles</label>
                </div>
                <div>
                    <input type="radio" name="idioma" value="fr">
                    <label>Frances</label>
                </div>
            </div>

            <div>     
                <label for="habilitar">Habilitar</label>
                <div>     
                    <input type="checkbox" id="habilitar" name="habilitar" checked="">
                </div>     
            </div>     

            <div>
                <div>
                    <input type="submit" value="Enviar">
                </div>
            </div>
            <input type="hidden" name="secreto" value="12345">
        </form>
    </body>
</html>