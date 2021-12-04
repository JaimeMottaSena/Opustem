package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import ModeloDAO.UsuarioDAO;
import ModeloVO.UsuarioVO;
import ModeloVO.UsuarioVO;

public final class consultarUsuario_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/Sesiones.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");

    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-control", "no-cache,no-store,must-revalidate");
    response.setDateHeader("Expires", 0);


      out.write('\n');
      out.write('\n');


    HttpSession buscarSesion =(HttpSession)request.getSession();
    String usuario="";
    if (buscarSesion.getAttribute("datos") ==null){
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }else {
    UsuarioVO usuVO = (UsuarioVO)buscarSesion.getAttribute("datos");
    usuario = usuVO.getAliasUsuario();
                    
    }
    


      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title></title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container col-md-12\">\n");
      out.write("            <nav class=\"navbar navbar-dark bg-dark \">\n");
      out.write("             \n");
      out.write("            <h1 class=\"text-light font-italic\">Bienvenido: ");
      out.print(usuario);
      out.write("</h1>\n");
      out.write("            <form method=\"post\" action=\"Sesiones\">\n");
      out.write("            <button type=\"submit\" class=\"btn btn-success mb-2\">Cerrar Sesión</button>\n");
      out.write("        \n");
      out.write("            </form>\n");
      out.write("        </nav>\n");
      out.write("    </div>\n");
      out.write("    </body>\n");
      out.write("</html>");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Consultar Usuario</h1>\n");
      out.write("    <center>\n");
      out.write("        <form method=\"post\" action=\"Usuario\" >\n");
      out.write("            <table  class=\"tablaDeFormulario\">\n");
      out.write("                <tr>\n");
      out.write("                    \n");
      out.write("                <th>\n");
      out.write("                    Cédula<br>\n");
      out.write("                    <input type=\"number\" name=\"textDocumento\"><br>\n");
      out.write("                  \n");
      out.write("                  \n");
      out.write("                </th>\n");
      out.write("                </tr>\n");
      out.write("            </table><br>\n");
      out.write("            <button class=\"btn btn-success btn-block col-md-2\">Consultar</button>\n");
      out.write("            <input type=\"hidden\"  value=\"4\" name=\"opcion\">\n");
      out.write("        </form>\n");
      out.write("        </center>\n");
      out.write("        \n");
      out.write("        <div>\n");
      out.write("            ");
 if(request.getAttribute("mensajeError")!=null){
      out.write("\n");
      out.write("            <div style=\"color:red;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensajeError}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</div>\n");
      out.write("            ");
}else{
      out.write("\n");
      out.write("            <div style=\"color: blue;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensajeÉxito}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</div>");
}
      out.write("\n");
      out.write("        </div><br><br>\n");
      out.write("        \n");
      out.write("        <form>\n");
      out.write("            <table class=\"table col-md-6\" border=\"2px\">\n");
      out.write("                <tr>\n");
      out.write("                    <th>Id Usuario</th>\n");
      out.write("                    <th>Alias</th>\n");
      out.write("                    <th>Nombre</th>\n");
      out.write("                    <th>Apelllido</th>\n");
      out.write("                    <th>Fecha Nacimiento</th>\n");
      out.write("                    <th>Correo</th>\n");
      out.write("                    <th>Clave</th>\n");
      out.write("                    <th>Tipo De documento</th>\n");
      out.write("                    <th>Numero De documento</th>\n");
      out.write("                    <th>Dirección</th>\n");
      out.write("                    <th>Teléfono</th>\n");
      out.write("                     <th>Cargo</th>\n");
      out.write("                      <th>Turno</th>\n");
      out.write("                </tr>\n");
      out.write("                ");

                    
               UsuarioVO UsuVO = new UsuarioVO();
                UsuarioDAO UsuDAO = new UsuarioDAO(UsuVO); 
              
                ArrayList<UsuarioVO>listaUsuarios= UsuDAO.listar();
                for (int i=0; i<listaUsuarios.size(); i++){
                    UsuVO = listaUsuarios.get(i);
                
                
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <th>");
      out.print(UsuVO.getIdUsuario());
      out.write("</th>\n");
      out.write("                    <td>");
      out.print(UsuVO.getAliasUsuario());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(UsuVO.getNombreUsuario());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(UsuVO.getApellidoUsuario());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(UsuVO.getFechaNacimiento());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(UsuVO.getCorreoUsuario());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(UsuVO.getClaveUsuario());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(UsuVO.getTipoDocumento());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(UsuVO.getNumeroDocumento());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(UsuVO.getDireccionUsuario());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(UsuVO.getTelefono());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(UsuVO.getIdCargoFK());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(UsuVO.getIdTurnoFK());
      out.write("</td>\n");
      out.write("                    <td>\n");
      out.write("                    <a class=\"btn btn-warning\" value=\"0\" name=\"opcion\">Editar</a>\n");
      out.write("                   <button>Eliminar</button>\n");
      out.write("                     <input type=\"hidden\"  value=\"4\" name=\"opcion\">\n");
      out.write("            <input type=\"hidden\" value=\"2\" name=\"opcion\">\n");
      out.write("                </td>\n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                </tr>\n");
      out.write("                ");
 }
      out.write("\n");
      out.write("            </table>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
