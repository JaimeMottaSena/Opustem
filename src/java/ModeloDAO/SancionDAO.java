/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.SancionVO;
import Util.Conexion;
import Util.Crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Controlador.Sesiones;
import javax.servlet.http.HttpSession;

/**
 *
 * @author duban
 */
public class SancionDAO extends Conexion implements Crud{

    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    
    private boolean operacion = false;
    private String sql;
    
    
    private String IdSancion = "";
    private String IdTipoSancionFK = "";
    private String IdUsuarioFK = "";
    private String IdEventoFK = "";
    private String FechaSancion = "";
    private String Descripcion = "";

    public SancionDAO() {
    }
    
    
    public SancionDAO(SancionVO SanVO) {
        super();

        try {
            conexion = this.nuevaConexion();
            IdSancion = SanVO.getIdSancion();
            IdTipoSancionFK = SanVO.getIdTipoSancionFK();
            IdUsuarioFK = SanVO.getIdUsuarioFK();
            IdEventoFK = SanVO.getIdEventoFK();
            FechaSancion = SanVO.getFechaSancion();
            Descripcion = SanVO.getDescripcion();
        } catch (Exception e) {
            Logger.getLogger(SancionDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    
    @Override
    public boolean agregarRegistro() {
        try {
            sql = "call insertarSancion (?,?,?,?,?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, IdSancion);
            puente.setString(2, IdTipoSancionFK);
            puente.setString(3, IdUsuarioFK);
            puente.setString(4, IdEventoFK);
            puente.setString(5, Descripcion);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(SancionDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {

                this.cerrarConexion();

            } catch (SQLException e) {
            }
        }
        return operacion;
    }

    @Override
    public boolean actualizarRegistro() {
        try {
            sql = "call actualizarSancion(?,?,?,?,?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, IdTipoSancionFK);
            puente.setString(2, IdUsuarioFK);
            puente.setString(3, IdEventoFK);
            puente.setString(4, Descripcion);
            puente.setString(5, IdSancion);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(SancionDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {

                this.cerrarConexion();

            } catch (SQLException e) {
            }
        }
        return operacion;
    }

    @Override
    public boolean eliminarRegistro() {
        try {
            sql = "call eliminarSancion(?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, IdSancion);
            puente.executeUpdate();
            operacion = true;
        } catch (SQLException e) {
            Logger.getLogger(SancionDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(SancionDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }
    
    
    public ArrayList<SancionVO> listar(){
    
        ArrayList<SancionVO>ListaSanciones = new ArrayList<>();
        try {
            conexion=this.nuevaConexion();
            sql="select * from sancion";
            puente=conexion.prepareStatement(sql);
            mensajero=puente.executeQuery();
            while(mensajero.next()){
                
                SancionVO  SanVO= new SancionVO(mensajero.getString(1),mensajero.getString(2)
                                        ,mensajero.getString(3),mensajero.getString(4)
                                        ,mensajero.getString(5),mensajero.getString(6));
                ListaSanciones.add(SanVO);
            }
        } catch (Exception e) {
            Logger.getLogger(SancionDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            try {
                this.cerrarConexion();
                
            } catch (SQLException e) {
                Logger.getLogger(SancionDAO.class.getName()).log(Level.SEVERE, null, e);
            }
      }
        return ListaSanciones;
    
    }
    
     public SancionVO consultarId(String IdSancion){
        SancionVO sanVO = null;
        
        try {
            conexion = this.nuevaConexion();
            sql="select * from Sancion where IdSancion=?";
            puente=conexion.prepareStatement(sql);
            puente.setString(1, IdSancion);
            mensajero= puente.executeQuery();
            while (mensajero.next()){
                sanVO = new SancionVO(IdSancion,mensajero.getString(2)
                                        ,mensajero.getString(3), mensajero.getString(4),
                                           mensajero.getString(5), mensajero.getString(6)
                                           );
            }
        } catch (Exception e) {
            Logger.getLogger(SancionDAO.class.getName()).log(Level.SEVERE, null, e); 
        }finally {
            try {
                this.cerrarConexion();
                
            } catch (SQLException e) {
                Logger.getLogger(SancionDAO.class.getName()).log(Level.SEVERE, null, e);
            }
      }
        return sanVO;
    }
     
      public ArrayList<SancionVO> listarUno(String IdUsuario){
    
        ArrayList<SancionVO>ListaSancionesUno = new ArrayList<>();
        try {
            conexion=this.nuevaConexion();
            sql="select * from sancion where IdUsuarioFK=?";
            puente=conexion.prepareStatement(sql);
            puente.setString(1, IdUsuario);
            mensajero=puente.executeQuery();
            while(mensajero.next()){
                
                SancionVO  SanVO= new SancionVO(mensajero.getString(1),mensajero.getString(2)
                                        ,mensajero.getString(3),mensajero.getString(4)
                                        ,mensajero.getString(5),mensajero.getString(6));
                ListaSancionesUno.add(SanVO);
            }
        } catch (Exception e) {
            Logger.getLogger(SancionDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            try {
                this.cerrarConexion();
                
            } catch (SQLException e) {
                Logger.getLogger(SancionDAO.class.getName()).log(Level.SEVERE, null, e);
            }
      }
        return ListaSancionesUno;
}
}
