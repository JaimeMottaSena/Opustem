<%-- 
    Document   : GenerarSancionPDF
    Created on : 28/11/2021, 08:52:02 PM
    Author     : duban
--%>

<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="Util.Conexion"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            File reporte = new File(application.getRealPath("Sanciones.jasper"));
            Map<String,Object> parametros = new HashMap<String, Object>();
            
            Conexion conexionBD =new Conexion();
            Connection conexion = conexionBD.nuevaConexion();
        

           byte[] bytes = JasperRunManager.runReportToPdf(reporte.getPath(), parametros, conexion);
           response.setContentType("application/pdf");
           response.setContentLength(bytes.length);
           ServletOutputStream salida = response.getOutputStream();
           salida.write(bytes, 0, bytes.length);
           
           salida.flush();
           salida.close();
           
        %>
    </body>
</html>
