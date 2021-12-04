/*
 * To /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Util.Conexion;
import Util.Crud;
import ModeloVO.UsuarioVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author JUAN DAVID PACHON
 */
public class UsuarioDAO extends Conexion implements Crud {

    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    private boolean operacion = false;
    private String sql;

    private String IdUsuario = "";
    private String AliasUsuario = "";
    private String NombreUsuario = "";
    private String ApellidoUsuario = "";
    private String FechaNacimiento = "";
    private String CorreoUsuario = "";
    private String ClaveUsuario = "";
    private String TipoDocumento = "";
    private String NumeroDocumento = "";
    private String DireccionUsuario = "";
    private String Telefono = "";
    private String IdCargoFK = "";
    private String IdTurnoFK = "";
    private String Estado = "";
    private String direccion = "";
    
    
    public UsuarioDAO() {
    }

    public UsuarioDAO(UsuarioVO usuVO) {
        super();

        try {
            conexion = this.nuevaConexion();
            IdUsuario = usuVO.getIdUsuario();
            AliasUsuario = usuVO.getAliasUsuario();
            NombreUsuario = usuVO.getNombreUsuario();
            ApellidoUsuario = usuVO.getApellidoUsuario();
            FechaNacimiento = usuVO.getFechaNacimiento();
            CorreoUsuario = usuVO.getCorreoUsuario();
            ClaveUsuario = usuVO.getClaveUsuario();
            TipoDocumento = usuVO.getTipoDocumento();
            NumeroDocumento = usuVO.getNumeroDocumento();
            DireccionUsuario = usuVO.getDireccionUsuario();
            Telefono = usuVO.getTelefono();
            IdCargoFK = usuVO.getIdCargoFK();
            IdTurnoFK = usuVO.getIdTurnoFK();
            Estado = usuVO.getEstado();
            direccion=usuVO.getDireccion();

        } catch (Exception e) {
            //logger captura lo que me esta pasando y como se comporta
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public boolean agregarRegistro() {
        try {

            sql = "{call pa_insertarUsu(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

            puente = conexion.prepareStatement(sql);
            puente.setString(1, IdUsuario);
            puente.setString(2, AliasUsuario);
            puente.setString(3, NombreUsuario);
            puente.setString(4, ApellidoUsuario);
            puente.setString(5, FechaNacimiento);
            puente.setString(6, CorreoUsuario);
            puente.setString(7, ClaveUsuario);
            puente.setString(8, TipoDocumento);
            puente.setString(9, NumeroDocumento);
            puente.setString(10, DireccionUsuario);
            puente.setString(11, Telefono);
            puente.setString(12, IdCargoFK);
            puente.setString(13, IdTurnoFK);
            puente.setString(14, Estado);
            //mando la sentencia
            puente.executeUpdate();
            operacion = true;
            
            if(operacion==true){
                enviarMail(CorreoUsuario);
            }

        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {

                this.cerrarConexion();

            } catch (SQLException e) {

            }
        }
        return operacion; //To change body of generated methods, choose Tools | Templates.
    }
      public static void enviarMail( String CorreoUsuario) {
       try {
                    
                    Properties props = new Properties();
                    props.setProperty("mail.smtp.host", "smtp.gmail.com");
                    props.setProperty("mail.smtp.starttls.enable", "true");
                    props.setProperty("mail.smtp.port", "587");
                    props.setProperty("mail.smtp.auth", "true");

                    Session session = Session.getDefaultInstance(props);

                    String correoRemitente = "opustem@gmail.com";
                    String passwordRemitente = "";
                    String correoReceptor =CorreoUsuario;
                    
                    String asunto = "Registro Exitoso en OpusTem";
                    String mensaje = "Hola nos place infromarle que su registro con <br>"
                            + "nosotros fue exitoso espramos tenga una buena experiencia";

                    BodyPart texto = new MimeBodyPart();
                    texto.setContent(mensaje, "text/html");

                    BodyPart adjunto = new MimeBodyPart();
                    adjunto.setDataHandler(new DataHandler(new FileDataSource("./img/opustem.png")));
                    adjunto.setFileName("opustem.png");

                    MimeMultipart multiparte = new MimeMultipart();
                    multiparte.addBodyPart(texto);
                    multiparte.addBodyPart(adjunto);

                    MimeMessage message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(correoRemitente));

                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
                    message.setSubject(asunto);
                    message.setContent(multiparte,"ISO-8859-1");

                    Transport t = session.getTransport("smtp");
                    t.connect(correoRemitente, passwordRemitente);
                    t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
                    t.close();

                }catch (AddressException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MessagingException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Override
    public boolean actualizarRegistro() {

        try {
            //?? para que no sea inyetado
            sql = "{call pa_actualizarUsuario(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
            //preparo la sentencia
            puente = conexion.prepareStatement(sql);
            puente.setString(1, AliasUsuario);
            puente.setString(2, NombreUsuario);
            puente.setString(3, ApellidoUsuario);
            puente.setString(4, FechaNacimiento);
            puente.setString(5, CorreoUsuario);
            puente.setString(6, ClaveUsuario);
            puente.setString(7, TipoDocumento);
            puente.setString(8, NumeroDocumento);
            puente.setString(9, DireccionUsuario);
            puente.setString(10, Telefono);
            puente.setString(11, IdCargoFK);
            puente.setString(12, IdTurnoFK);
            puente.setString(13, IdUsuario);
            puente.setString(14, Estado);

            //mando la sentencia
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return operacion;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarRegistro() {
        try {
            //?? para que no sea inyetado

            conexion = this.nuevaConexion();
            sql = "UPDATE Usuario SET Estado =?  WHERE IdUsuario=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, Estado);
            puente.setString(2, IdUsuario);
            //mando la sentencia
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return operacion;

        //To change body of generated methods, choose Tools | Templates.
    }

    public boolean CargaMasiva() {

        try {
            conexion = this.nuevaConexion();
          
            sql = "LOAD DATA LOCAL INFILE 'D:/Carga_masiva/Usuarios.csv'\n" +
" INTO TABLE USUARIO\n" +
" FIELDS TERMINATED BY ';'\n" +
" LINES TERMINATED BY '\\n'\n" +
" (AliasUsuario,NombreUsuario,ApellidoUsuario,FechaNacimiento,CorreoUsuario,ClaveUsuario,TipoDocumento,NumeroDocumento,DireccionUsuario,Telefono,IdCargoFK,IdTurnoFK,Estado)\n" +
";";
           
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            if (mensajero.next()) {
                operacion = true;
            }

        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return operacion;

    }

    public boolean iniciarSesion(String usuario, String clave) {

        try {
            conexion = this.nuevaConexion();
            sql = "select * from Usuario where AliasUsuario=? and ClaveUsuario=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuario);
            puente.setString(2, clave);
            mensajero = puente.executeQuery();
            if (mensajero.next()) {
                operacion = true;
            }

        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {

                this.cerrarConexion();

            } catch (SQLException e) {
            }
        }
        return operacion;

    }

    public UsuarioVO consultarDatos(String idUsuario) {
        UsuarioVO usuVO = null;

        try {
            conexion = this.nuevaConexion();
            sql = "select * from Usuario where IdUsuario=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, idUsuario);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                usuVO = new UsuarioVO(mensajero.getString(1), mensajero.getString(2),
                        mensajero.getString(3), mensajero.getString(4),
                        mensajero.getString(5), mensajero.getString(6),
                        mensajero.getString(7), mensajero.getString(8),
                        mensajero.getString(9), mensajero.getString(10),
                        mensajero.getString(11), mensajero.getString(12),
                        mensajero.getString(13), mensajero.getString(14));
            }
        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return usuVO;
    }

    public ArrayList<UsuarioVO> listar() {
        ArrayList<UsuarioVO> listaUsuarios = new ArrayList<>();
        try {
            conexion = this.nuevaConexion();
            sql = "Select * from usuario";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {
                UsuarioVO usuVO = new UsuarioVO(
                        mensajero.getString(1),
                        mensajero.getString(2),
                        mensajero.getString(3),
                        mensajero.getString(4),
                        mensajero.getString(5),
                        mensajero.getString(6),
                        mensajero.getString(7),
                        mensajero.getString(8),
                        mensajero.getString(9),
                        mensajero.getString(10),
                        mensajero.getString(11),
                        mensajero.getString(12),
                        mensajero.getString(13),
                        mensajero.getString(14));

                listaUsuarios.add(usuVO);

            }

        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listaUsuarios;

    }

    public UsuarioVO consultarCedula(String NumeroDocumento) {

        UsuarioVO usuVO = null;

        try {
            conexion = this.nuevaConexion();
            sql = "select * from usuario where NumeroDocumento=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, NumeroDocumento);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                usuVO = new UsuarioVO(
                        mensajero.getString(1),
                        mensajero.getString(2),
                        mensajero.getString(3),
                        mensajero.getString(4),
                        mensajero.getString(5),
                        mensajero.getString(6),
                        mensajero.getString(7),
                        mensajero.getString(8),
                        mensajero.getString(9),
                        mensajero.getString(10),
                        mensajero.getString(11),
                        mensajero.getString(12),
                        mensajero.getString(13),
                        mensajero.getString(14));

            }
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            try {

                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return usuVO;
    }

    public int existeUsuario(String NumeroDocumento) {
        try {

            sql = "select count(NumeroDocumento) from usuario where NumeroDocumento=? ";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, NumeroDocumento);
            mensajero = puente.executeQuery();

            if (mensajero.next()) {
                return mensajero.getInt(1);
            }

            return 1;
            //mando la sentencia

        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return 1;

    }

    public int existeCorreo(String CorreoUsuario) {
        try {

            sql = "select count(CorreoUsuario) from usuario where CorreoUsuario=? ";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, CorreoUsuario);
            mensajero = puente.executeQuery();

            if (mensajero.next()) {
                return mensajero.getInt(1);
            }

            return 1;
            //mando la sentencia

        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return 1;

    }

    public int existeTel(String Telefono) {
        try {

            sql = "select count(Telefono) from usuario where Telefono=? ";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, Telefono);
            mensajero = puente.executeQuery();

            if (mensajero.next()) {
                return mensajero.getInt(1);
            }

            return 1;
            //mando la sentencia

        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return 1;

    }

}
