<%-- 
    Document   : registrarEvento
    Created on : 27/06/2021, 08:59:26 PM
    Author     : duban
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Sesiones.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container col-md-4">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="collapse navbar-collapse">
                    <a class="navbar-brand" href="consultarPermiso.jsp">Permisos</a>
                    <a class="navbar-brand" href="consultarUsuario.jsp">Usuario</a>
                    <a class="navbar-brand" href="consultarEvento.jsp">Eventos</a>
                    <a class="navbar-brand" href="consultarSancion.jsp">Sanciones</a>
                </div>
            </nav>
    </div>
    <center>
        <h1>Registro de Evento</h1>
    </center>
        <div class="container">
            <form action="Evento" method="post">
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="">Fecha</label>
                        <br>
                        <input type="date" class="form-control" required="required" name="textFecha">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="">Hora</label>
                        <br>
                        <input type="time" class="form-control" required="required" name="textHora">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="">Tipo de evento</label>
                        <br>
                        <select class="form-control" name="" id="">
                            <option value="">Seleccione...</option>
                            <option value="">Llegada Trabajo</option>
                            <option value="">Salida Trabajo</option>
                            <option value="">Salida Almuerzo</option>
                            <option value="">Llegada Almuerzo</option>
                            <option value="">HOLA</option>
                        </select>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-12">
                        <label for="">Descripción:</label>
                        <textarea name="textDescripcion" class="form-control" id="" cols="10" rows="5"></textarea>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-4"></div>
                <div class="form-group col-md-6"></div>
                <div class="form-group col-md-2">
                    <label for=""></label>
                <button class="btn btn-success btn-block">Registrar</button>
                <input type="hidden"  value="1" name="opcion">
            </div>
                </div>
            </form>

        </div>
    </body>
</html>
