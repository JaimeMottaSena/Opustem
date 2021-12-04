/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */package ModeloDAO;

import ModeloVO.PermisoVO;
import Util.Conexion;
import Util.Crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author
 */
public class PermisoDAO extends Conexion implements Crud {

    /*1. Declarar atributos y obejetos*/
    private Connection conexion;
    /* Sentencia Preparada y declaracion de variable*/
    private PreparedStatement puente;
    /*variable para el resulset*/
    private ResultSet mensajero;
    /*variable booleana inicializada en falso*/
    private boolean operacion = false;
    /*variable para gusradar sentencias sql*/
    private String sql;
    private String sqlMaxPermiso;
    //*atributos inicializados y variables para recibir *//
    private String IdPermiso = "";
    private String IdTipoPermisoFK = "";

    private String FechaSolicitud = "";
    private String FechaPermiso = "";
    private String Descripcion = "";
    private String HoraSalida = "";
    private String Regreso = "";
    private String EstadoPermiso = "";

    public PermisoDAO() {
    }

    public PermisoDAO(PermisoVO PerVO) {
        super();

        try {
            conexion = this.nuevaConexion();
            IdPermiso = PerVO.getIdPermiso();
            IdTipoPermisoFK = PerVO.getIdTipoPermisoFK();

            FechaSolicitud = PerVO.getFechaSolicitud();
            FechaPermiso = PerVO.getFechaPermiso();
            Descripcion = PerVO.getDescripcion();
            HoraSalida = PerVO.getHoraSalida();
            Regreso = PerVO.getRegreso();
            EstadoPermiso = PerVO.getEstadoPermiso();

        } catch (Exception e) {
            //logger captura lo que me esta pasando y como se comporta
            Logger.getLogger(PermisoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public boolean agregarRegistro() {
        try {
            

           sql = "call pa_insertarPer(?,?,?,?,?,?,?)";
            //preparo la sentencia
            
            
               
            puente = conexion.prepareStatement(sql);
            puente.setString(1, IdPermiso);
            puente.setString(2, IdTipoPermisoFK);
           
            puente.setString(3, FechaPermiso);
            puente.setString(4, Descripcion);
            puente.setString(5, HoraSalida);
            puente.setString(6, Regreso);
            puente.setString(7, EstadoPermiso);

            //mando la sentencia
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(PermisoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {

            }
        }
        return operacion; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarRegistro() {
        try {
            //?? para que no sea inyetado
           sql = "update Permiso set IdTipoPermisoFK=?,  FechaPermiso=?, Descripcion=?,HoraSalida=?, "
                + "Regreso=?, EstadoPermiso=? where IdPermiso=?";
                 // sql="call actualizarPermiso(?,?,?,?,?,?,?)";
            //preparo la sentencia
            puente = conexion.prepareStatement(sql);

            puente.setString(1, IdTipoPermisoFK);
            
            puente.setString(2, FechaPermiso);
            puente.setString(3, Descripcion);
            puente.setString(4, HoraSalida);
            puente.setString(5, Regreso);
            puente.setString(6, EstadoPermiso);
            puente.setString(7, IdPermiso);

            //mando la sentencia
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(PermisoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {

            }
        }
        return operacion;//To change body of generated methods, choose Tools | Templates.
    }
    
    
//ESTADO DEL PERMISO
    @Override
    public boolean eliminarRegistro() {
        try {
            //?? para que no sea inyetado
          
            conexion=this.nuevaConexion();
            sql="UPDATE Permiso SET EstadoPermiso =?  WHERE IdPermiso=?";
            puente=conexion.prepareStatement(sql);
            puente.setString(1,EstadoPermiso);
            puente.setString(2,IdPermiso);
        //mando la sentencia
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } 
        return operacion;
    
        
         //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<PermisoVO> listar() {

        ArrayList<PermisoVO> ListaPermisos = new ArrayList<>();
        try {
            conexion = this.nuevaConexion();
            sql = "select * from permiso";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {

                PermisoVO PerVO = new PermisoVO(mensajero.getString(1), mensajero.getString(2),
                        mensajero.getString(3), mensajero.getString(4),
                        mensajero.getString(5), mensajero.getString(6), mensajero.getString(7), mensajero.getString(8));
                ListaPermisos.add(PerVO);
            }
        } catch (Exception e) {
            Logger.getLogger(PermisoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(PermisoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return ListaPermisos;

    }

    public PermisoVO consultarId(String IdPermiso) {
        PermisoVO perVO = null;

        try {
            conexion = this.nuevaConexion();
            sql = "select * from Permiso where IdPermiso=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, IdPermiso);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                perVO = new PermisoVO(IdPermiso, mensajero.getString(2),
                        mensajero.getString(3), mensajero.getString(4),
                        mensajero.getString(5), mensajero.getString(6), mensajero.getString(7),
                        mensajero.getString(8));
            }
        } catch (Exception e) {
            Logger.getLogger(PermisoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(PermisoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return perVO;
    }
}
