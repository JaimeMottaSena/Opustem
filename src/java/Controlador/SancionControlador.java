/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.SancionDAO;
import ModeloVO.SancionVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author duban
 */
@WebServlet(name = "SancionControlador", urlPatterns = {"/Sancion"})
public class SancionControlador extends HttpServlet {

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
        
        String IdSancion = request.getParameter("textId");
        String IdTipoSancionFK = request.getParameter("textTipo");
        String IdUsuarioFK = request.getParameter("textIdUsuario");
        String IdEventoFK = request.getParameter("textIdEvento");
        String FechaSancion = request.getParameter("textFecha");
        String Descripcion = request.getParameter("textDescripcion");
        
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        
        
        SancionVO sanVO = new SancionVO(IdSancion, IdTipoSancionFK, IdUsuarioFK, IdEventoFK, 
                                        FechaSancion, Descripcion);
        
        SancionDAO sanDAO =new SancionDAO(sanVO);
        
        
        switch (opcion){
            case 1:
                
                if(sanDAO.agregarRegistro()){
                    response.sendRedirect(request.getContextPath()+"/registrarSancionGeren.jsp"+"?mensajeExito="+1);
                }else{
                    response.sendRedirect(request.getContextPath()+"/registrarSancionGeren.jsp"+"?mensajeError="+1);
                }
                
                break;
            case 2: //Actualizar Registro
                
                
                sanVO = sanDAO.consultarId(IdSancion);
                if (sanVO !=null) {
                    request.setAttribute("Sancion", sanVO);
                    request.getRequestDispatcher("actualizarSancionGere.jsp").forward(request, response);  
                }
                break;
                
              
            case 3:
                 if (sanDAO.actualizarRegistro()) {
                    response.sendRedirect(request.getContextPath()+"/actualizarSancionGere.jsp"+"?mensajeExito="+1);
                } else {
                    response.sendRedirect(request.getContextPath()+"/actualizarSancionGere.jsp"+"?mensajeError="+1);
                }            
                break;
               
            case 4:
                 if (sanDAO.eliminarRegistro()) {
                    response.sendRedirect(request.getContextPath()+"/consultarSancionGeren.jsp"+"?mensajeExito="+1);
                } else {
                    response.sendRedirect(request.getContextPath()+"/consultarSancionGeren.jsp"+"?mensajeError="+1);
                }            
                break;
                
            case 5:
                
                if(sanDAO.agregarRegistro()){
                    response.sendRedirect(request.getContextPath()+"/registrarSancionGes.jsp"+"?mensajeExito="+1);
                }else{
                    response.sendRedirect(request.getContextPath()+"/registrarSancionGes.jsp"+"?mensajeError="+1);
                }
                
                break;
            case 6:
                
                if(sanDAO.agregarRegistro()){
                    response.sendRedirect(request.getContextPath()+"/registrarSancionJefe.jsp"+"?mensajeExito="+1);
                }else{
                    response.sendRedirect(request.getContextPath()+"/registrarSancionJefe.jsp"+"?mensajeError="+1);
                }
                
                break;
            case 7:
                 if (sanDAO.actualizarRegistro()) {
                    response.sendRedirect(request.getContextPath()+"/actualizarSancionGes.jsp"+"?mensajeExito="+1);
                } else {
                    response.sendRedirect(request.getContextPath()+"/actualizarSancionGes.jsp"+"?mensajeError="+1);
                }            
                break;
            case 8:
                 if (sanDAO.actualizarRegistro()) {
                    response.sendRedirect(request.getContextPath()+"/actualizarSancionJefe.jsp"+"?mensajeExito="+1);
                } else {
                    response.sendRedirect(request.getContextPath()+"/actualizarSancionJefe.jsp"+"?mensajeError="+1);
                }            
                break;
            case 9:
                 if (sanDAO.eliminarRegistro()) {
                    response.sendRedirect(request.getContextPath()+"/consultarSancionGes.jsp"+"?mensajeExito="+1);
                } else {
                    response.sendRedirect(request.getContextPath()+"/consultarSancionGes.jsp"+"?mensajeError="+1);
                }            
                break;
            case 10:
                 if (sanDAO.eliminarRegistro()) {
                    response.sendRedirect(request.getContextPath()+"/consultarSancionJefe.jsp"+"?mensajeExito="+1);
                } else {
                    response.sendRedirect(request.getContextPath()+"/consultarSancionJefe.jsp"+"?mensajeError="+1);
                }            
                break;
            case 11: //Actualizar Registro
                
                
                sanVO = sanDAO.consultarId(IdSancion);
                if (sanVO !=null) {
                    request.setAttribute("Sancion", sanVO);
                    request.getRequestDispatcher("actualizarSancionJefe.jsp").forward(request, response);  
                }
                break;
                
            case 12: //Actualizar Registro
                
                
                sanVO = sanDAO.consultarId(IdSancion);
                if (sanVO !=null) {
                    request.setAttribute("Sancion", sanVO);
                    request.getRequestDispatcher("actualizarSancionGes.jsp").forward(request, response);  
                }
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
