//*
/* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import javax.swing.*;
import ModeloDAO.RolDAO;
import ModeloDAO.UsuarioDAO;
import ModeloVO.UsuarioVO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author JUAN DAVID PACHON
 */
@WebServlet(name = "UsuarioControlador", urlPatterns = {"/Usuario"})
public class UsuarioControlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String IdUsuario = request.getParameter("textId");
        String AliasUsuario = request.getParameter("textUsuario");
        String NombreUsuario = request.getParameter("textNombre");
        String ApellidoUsuario = request.getParameter("textApellido");
        String FechaNacimiento = request.getParameter("textFecha");
        String CorreoUsuario = request.getParameter("textCorreo");
        String ClaveUsuario = request.getParameter("textClave");
        String TipoDocumento = request.getParameter("textTipoDoc");
        String NumeroDocumento = request.getParameter("textDocumento");
        String DireccionUsuario = request.getParameter("textDireccion");
        String Telefono = request.getParameter("textTelefono");
        String IdCargoFK = request.getParameter("textCargo");
        String IdTurnoFK = request.getParameter("textTurno");
        String Estado = request.getParameter("textEstado");
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        String direccion = request.getParameter("direccion");
        /*
        String Telefono= request.getParameter("textTel");
        String = request.getParameter("textNombre");
        int opcion = Integer.parseInt(request.getParameter("opcion"));
         */
        //2. ¿Quién tiene los datos del sistema?
        UsuarioVO usuVO = new UsuarioVO(IdUsuario, AliasUsuario, NombreUsuario, ApellidoUsuario, FechaNacimiento, CorreoUsuario,
                ClaveUsuario, TipoDocumento, NumeroDocumento, DireccionUsuario, Telefono, IdCargoFK,
                IdTurnoFK, Estado);
        //3. ¿Quién hace las operaciones?
        UsuarioDAO usuDAO = new UsuarioDAO(usuVO);

        switch (opcion) {
            case 1: // Agregar//
                while(usuDAO.existeTel(Telefono)!=0){
                 request.setAttribute("mensajeError2", "Lo sentimos este telefono ya se encuentra registrado");
                 request.getRequestDispatcher("registrarUser.jsp").forward(request, response);
               }
               while(usuDAO.existeCorreo(CorreoUsuario)!=0){
                 request.setAttribute("mensajeError3", "Ya hay un usuario con este correo");
                 request.getRequestDispatcher("registrarUser.jsp").forward(request, response);
               }
               if(usuDAO.existeUsuario(NumeroDocumento)==1){
                 request.setAttribute("mensajeError4", "Lo Sentimos este numero de documento ya existe ");
                 request.getRequestDispatcher("registrarUser.jsp").forward(request, response);
               }
                if (usuDAO.agregarRegistro()) {
                    response.sendRedirect(request.getContextPath() + "/registrarUser.jsp" + "?mensajeExito=" + 1);

                } else {

                    response.sendRedirect(request.getContextPath() + "/registrarUser.jsp" + "?mensajeError=" + 1);
                }

                break;

            case 2: //Actualizar//
                if (usuDAO.actualizarRegistro()) {
                    request.setAttribute("mensajeÉxito", "Usuario Actualizado de forma correcta");
                } else {
                    request.setAttribute("mensajeError", "Lo Lamentamos el usuario no pudo ser actualizado");

                }
                request.getRequestDispatcher("actualizarUser.jsp").forward(request, response);
                break;

            case 3://Iniciar sesión

             
                
                if (usuDAO.iniciarSesion(AliasUsuario, ClaveUsuario)) {
                    
                    HttpSession miSesion = request.getSession(true);
                   
                    RolDAO rolDAO = new RolDAO();
                    ArrayList<UsuarioVO> listaRoles = rolDAO.roles(AliasUsuario);
                    
                    usuVO = new UsuarioVO(usuVO.getIdUsuario(), AliasUsuario, ClaveUsuario
                    );
                    miSesion.setAttribute("datos", usuVO); 
                    
                    for (int i = 0; i < listaRoles.size(); i++) {
                        usuVO= listaRoles.get(i);  
                    }
                    miSesion.setAttribute("roles", listaRoles);
                   
                    
                    if (usuVO.getNombreCargo().equals("Gerente")) {
                         request.getRequestDispatcher("menu_Gerente.jsp").forward(request, response);
                    }else if (usuVO.getNombreCargo().equals("Gestión Humana")){
                        request.getRequestDispatcher("menu_Gestion.jsp").forward(request, response);
                    }else if(usuVO.getNombreCargo().equals("Jefe Directo")){
                        request.getRequestDispatcher("menu_Jefe.jsp").forward(request, response);
                    } else {
                    request.getRequestDispatcher("menu.jsp").forward(request, response);
                    }
                    
                    
                      
                    
                }
                    
                else { 
                    response.sendRedirect(request.getContextPath()+"/index.jsp"+"?mensajeError="+1);
                    /*
                      request.setAttribute("mensajeError", "Datos de inicio de sesión incorrectos");
                      request.getRequestDispatcher("index.jsp").forward(request, response);
                      */}
                break;

            case 4:
                usuVO = usuDAO.consultarCedula(NumeroDocumento);
                if (usuVO != null) {

                    request.setAttribute("Usuario", usuVO);
                    request.getRequestDispatcher("actualizarUser.jsp").forward(request, response);

                } else {
                    request.setAttribute("mensajeError", "El Usuario NO existe");
                    request.getRequestDispatcher("consultarUsuario.jsp").forward(request, response);
                }

                break;

            case 5:
                if (usuDAO.eliminarRegistro()) {
                    request.setAttribute("mensajeÉxito2", "Usuario " + Estado + "de froma correcta");
                } else {
                    request.setAttribute("mensajeError5", "Lo Lamentamos el usuario no pudo ser Eliminado");

                }
                request.getRequestDispatcher("consultarUsuario.jsp").forward(request, response);
                break;

            case 6:
                 if (usuDAO.CargaMasiva()) {
                    response.sendRedirect(request.getContextPath() + "/consultarUsuari.jsp" + "?mensaje1=" + 1);

                } else {

                    response.sendRedirect(request.getContextPath() + "/consultarUsuario.jsp" + "?mensaje2=" + 1);
                };
                break;

        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
