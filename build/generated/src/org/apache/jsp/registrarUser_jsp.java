package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import ModeloVO.CargoVO;
import ModeloVO.TurnoVO;
import ModeloDAO.CargoDAO;
import ModeloDAO.TurnoDAO;
import ModeloVO.UsuarioVO;

public final class registrarUser_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("  <meta charset=\"UTF-8\">\n");
      out.write("  <meta content=\"width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no\" name=\"viewport\">\n");
      out.write("  <title>Registrar Sanción</title>\n");
      out.write("  <!-- General CSS Files -->\n");
      out.write("  <link rel=\"stylesheet\" href=\"assets/css/app.min.css\">\n");
      out.write("  <!-- Template CSS -->\n");
      out.write("  <link rel=\"stylesheet\" href=\"assets/css/style.css\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"assets/css/components.css\">\n");
      out.write("  <!-- Custom style CSS -->\n");
      out.write("  <link rel=\"stylesheet\" href=\"assets/css/custom.css\">\n");
      out.write("  <link rel='shortcut icon' type='image/x-icon' href='assets/img/tem.ico' />\n");
      out.write("  <link rel=\"stylesheet\" href=\"css/sweetalert.css\">\n");
      out.write("  <script src=\"js/sweetalert.min.js\" type=\"text/javascript\"></script>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("  \n");
      out.write("  <div id=\"app\">\n");
      out.write("    <div class=\"main-wrapper main-wrapper-1\">\n");
      out.write("      <div class=\"navbar-bg\"></div>\n");
      out.write("      <nav class=\"navbar navbar-expand-lg main-navbar sticky\">\n");
      out.write("        <div class=\"form-inline mr-auto\">\n");
      out.write("          <ul class=\"navbar-nav mr-3\">\n");
      out.write("            <li><a href=\"#\" data-toggle=\"sidebar\" class=\"nav-link nav-link-lg\n");
      out.write("\t\t\t\t\t\t\t\t\tcollapse-btn\"> <i data-feather=\"align-justify\"></i></a></li>\n");
      out.write("            <li><a href=\"#\" class=\"nav-link nav-link-lg fullscreen-btn\">\n");
      out.write("                <i data-feather=\"maximize\"></i>\n");
      out.write("              </a></li>\n");
      out.write("            \n");
      out.write("          </ul>\n");
      out.write("        </div>\n");
      out.write("        <ul class=\"navbar-nav navbar-right\">\n");
      out.write("        \n");
      out.write("          <li class=\"dropdown\"><a href=\"#\" data-toggle=\"dropdown\"\n");
      out.write("              class=\"nav-link dropdown-toggle nav-link-lg nav-link-user\"> <img alt=\"image\" src=\"assets/img/user.jpg\"\n");
      out.write("                class=\"user-img-radious-style\"> <span class=\"d-sm-none d-lg-inline-block\"></span></a>\n");
      out.write("            <div class=\"dropdown-menu dropdown-menu-right pullDown\">\n");
      out.write("              <div class=\"dropdown-title\">Usuario: ");
      out.print(usuario);
      out.write("</div>\n");
      out.write("              <a href=\"profile.html\" class=\"dropdown-item has-icon\"> <i class=\"far\n");
      out.write("\t\t\t\t\t\t\t\t\t\tfa-user\"></i> Perfil\n");
      out.write("              </a>  \n");
      out.write("              <div class=\"dropdown-divider\"></div>\n");
      out.write("              <form method=\"post\" action=\"Sesiones\">\n");
      out.write("                  <a class=\"dropdown-item has-icon text-danger\" href=\"Sesiones\"> <i class=\"fas fa-sign-out-alt\"></i>\n");
      out.write("                Cerrar Sesión\n");
      out.write("              </a>\n");
      out.write("\n");
      out.write("                </form>\n");
      out.write("              \n");
      out.write("            </div>\n");
      out.write("          </li>\n");
      out.write("        </ul>\n");
      out.write("      </nav>\n");
      out.write("      <div class=\"main-sidebar sidebar-style-2\">\n");
      out.write("        <aside id=\"sidebar-wrapper\">\n");
      out.write("          <div class=\"sidebar-brand\">\n");
      out.write("            <a href=\"index.html\"> <img alt=\"image\" src=\"assets/img/opus.png\" class=\"header-logo\" /> <span\n");
      out.write("                class=\"logo-name\">Opustem</span>\n");
      out.write("            </a>\n");
      out.write("          </div>\n");
      out.write("          <ul class=\"sidebar-menu\">\n");
      out.write("            <li class=\"menu-header\">Módulos</li>\n");
      out.write("            <li class=\"dropdown\">\n");
      out.write("              <a href=\"#\" class=\"menu-toggle nav-link has-dropdown\"><i data-feather=\"users\"></i><span>Usuarios</span></a>\n");
      out.write("            <ul class=\"dropdown-menu\">\n");
      out.write("              <li><a class=\"nav-link\" href=\"consultarUsuario.jsp\">Consultar Usuarios</a></li>\n");
      out.write("              <li><a class=\"nav-link\" href=\"registrarUser.jsp\">Registrar Usuario NUEVO</a></li>\n");
      out.write("            </ul>\n");
      out.write("            </li>\n");
      out.write("            <li class=\"dropdown\">\n");
      out.write("              <a href=\"#\" class=\"menu-toggle nav-link has-dropdown\"><i data-feather=\"book\"></i></i><span>Permisos</span></a>\n");
      out.write("              <ul class=\"dropdown-menu\">\n");
      out.write("                <li><a class=\"nav-link\" href=\"consultarPermiso.jsp\">Consultar Permisos</a></li>\n");
      out.write("              </ul>\n");
      out.write("            </li>\n");
      out.write("            <li class=\"dropdown\">\n");
      out.write("              <a href=\"#\" class=\"menu-toggle nav-link has-dropdown\"><i data-feather=\"calendar\"></i></i><span>Eventos</span></a>\n");
      out.write("              <ul class=\"dropdown-menu\">\n");
      out.write("                <li><a class=\"nav-link\" href=\"consultarEvento.jsp\">Consultar Eventos</a></li>\n");
      out.write("              </ul>\n");
      out.write("            </li>\n");
      out.write("            <li class=\"dropdown\">\n");
      out.write("              <a href=\"#\" class=\"menu-toggle nav-link has-dropdown\"><i data-feather=\"alert-triangle\"></i><span>Sanciones</span></a>\n");
      out.write("              <ul class=\"dropdown-menu\">\n");
      out.write("                <li><a class=\"nav-link\" href=\"consultarSancion.jsp\">Consultar Sanciones</a></li>\n");
      out.write("                <li><a class=\"nav-link\" href=\"registrarSancion.jsp\">Registrar Sanción</a></li>\n");
      out.write("              </ul>\n");
      out.write("            </li>\n");
      out.write("          </ul>\n");
      out.write("        </aside>\n");
      out.write("      </div>\n");
      out.write("      <!-- Main Content -->\n");
      out.write("      <div class=\"main-content\">\n");
      out.write("        <section class=\"section\">\n");
      out.write("          <div class=\"selection-boby\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("              <div class=\"col-12 col-md-12 col-lg-12\">\n");
      out.write("                <div class=\"card\">\n");
      out.write("                  <div class=\"card-header\">\n");
      out.write("        <center><h1>Registrar Usuario</h1></center>\n");
      out.write("        <div class=\"container\">\n");
      out.write("        <form method=\"post\" action =\"Usuario\">\n");
      out.write("            <div class=\"form-row\">\n");
      out.write("                <div class=\"form-group col-md-4\">\n");
      out.write("                    <label  for=\"\"> Usuario:</label><br>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" name=\"textUsuario\" placeholder=\"Ingrese aquí su alias de Usuario\"><br>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group col-md-4\">\n");
      out.write("                    <label for=\"\"> Nombre:</label><br>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" name=\"textNombre\" placeholder=\"Digite su nombre\"><br>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group col-md-4\">\n");
      out.write("                    <label for=\"\"> Apellido:</label><br>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" name=\"textApellido\" placeholder=\"Digite su apellido\"><br>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-row\">\n");
      out.write("                <div class=\"form-group col-md-4\">\n");
      out.write("                    <label for=\"\"> Fecha de Nacimiento:</label><br>\n");
      out.write("                    <input type=\"date\" class=\"form-control\" name=\"textFecha\"><br>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group col-md-4\">\n");
      out.write("                    <label for=\"\"> Correo:</label><br>\n");
      out.write("                    <input type=\"mail\" class=\"form-control\" name=\"textCorreo\" placeholder=\"Digite su correo\"><br>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group col-md-4\">\n");
      out.write("                    <label for=\"\"> Clave:</label><br>\n");
      out.write("                    <input type=\"password\" class=\"form-control\" name=\"textClave\" placeholder=\"Digite una clave segura\"><br>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-row\">\n");
      out.write("                <div class=\"form-group col-md-4\">\n");
      out.write("                    <label for=\"\"> Tipo de  Documento:</label><br>\n");
      out.write("                    <select class=\"form-control\" name=\"textTipoDoc\" id=\"\">\n");
      out.write("                        <option value=\"#\">Seleccione...</option>\n");
      out.write("                        <option value=\"C.C\">Cédula de ciudadanía</option>\n");
      out.write("                        <option value=\"C.E\">Cédula de Extranjería</option>\n");
      out.write("                        <option value=\"T.I\">Tarjeta de Identidad</option>\n");
      out.write("                    </select>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group col-md-4\">\n");
      out.write("                    <label for=\"\"> Número Documento:</label><br>\n");
      out.write("                    <input type=\"number\" class=\"form-control\" name=\"textDocumento\" placeholder=\"Digite su número de documento\"><br>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group col-md-4\">\n");
      out.write("                    <label for=\"\"> Dirección de Residencia:</label><br>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" name=\"textDireccion\" placeholder=\"Digite su dirección\"><br>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-row\">\n");
      out.write("                <div class=\"form-group col-md-4\">\n");
      out.write("                    <label for=\"\">Teléfono:</label><br>\n");
      out.write("                    <input type=\"number\" class=\"form-control\" name=\"textTelefono\" placeholder=\"Digite su número de teléfono\"><br>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group col-md-4\">\n");
      out.write("                    <label for=\"\">Cargo:</label>\n");
      out.write("                   <select name=\"textCargo\" class=\"form-control\" id=\"\">\n");
      out.write("                        <option value=\"\">Seleccione Su Cargo...</option>\n");
      out.write("                        ");
 
                            
                         CargoDAO CarDAO = new CargoDAO();
                        for( CargoVO carVO: CarDAO.listar()){
                            
                    
      out.write("\n");
      out.write("                    <option value=\"");
      out.print(carVO.getIdCargoFK());
      out.write('"');
      out.write('>');
      out.print(carVO.getNombreCargo());
      out.write("</option>\n");
      out.write("                    ");

                    }
                    
      out.write("\n");
      out.write("                   </select><br>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group col-md-4\">\n");
      out.write("                    <label for=\"\">Turno:</label>\n");
      out.write("                   <select name=\"textTurno\" class=\"form-control\" id=\"\">\n");
      out.write("                        <option value=\"\">Seleccione Su Turno...</option>\n");
      out.write("                        ");
 
                            
                         TurnoDAO TurDAO = new TurnoDAO();
                        for( TurnoVO turVO: TurDAO.listar()){
                            
                    
      out.write("\n");
      out.write("                    <option value=\"");
      out.print(turVO.getIdTurnoFK());
      out.write('"');
      out.write('>');
      out.print(turVO.getHoraEntrada());
      out.write("</option>\n");
      out.write("                    \n");
      out.write("                    ");

                    }
                    
      out.write("\n");
      out.write("                   </select><br>\n");
      out.write("                </div>\n");
      out.write("                   \n");
      out.write("                    <div class=\"form-group col-md-4\">\n");
      out.write("                    <label for=\"\"> Estado:</label><br>\n");
      out.write("                    <select class=\"form-control\" name=\"textEstado\" id=\"\">\n");
      out.write("                        <option value=\"#\">Seleccione</option>\n");
      out.write("                        <option value=\"Activo\">Activo</option>\n");
      out.write("                        <option value=\"Inactivo\">Inactivo</option>\n");
      out.write("                      \n");
      out.write("                    </select>\n");
      out.write("                </div>\n");
      out.write("                   \n");
      out.write("                   \n");
      out.write("            </div>        \n");
      out.write("            <div class=\"form-row\">\n");
      out.write("                <div class=\"form-group col-md-4\"></div>\n");
      out.write("                <div class=\"form-group col-md-6\"></div>\n");
      out.write("                <div class=\"form-group col-md-2\">\n");
      out.write("                    <label for=\"\"></label>\n");
      out.write("                <button class=\"btn btn-success btn-block\">Registrar</button>\n");
      out.write("                <input type=\"hidden\"  value=\"1\" name=\"opcion\">\n");
      out.write("            </div>\n");
      out.write("            </div>\n");
      out.write("        </form>    \n");
      out.write("        \n");
      out.write("        \n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("     \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("       \n");
      out.write("                \n");
      out.write("       <div>\n");
      out.write("            \n");
      out.write("            ");
 if (request.getAttribute("mensajeError2")!= null){
      out.write("\n");
      out.write("            <div style=\"color: red;\">\n");
      out.write("                ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensajeError2}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                 \n");
      out.write("            </div>\n");
      out.write("            ");
} 
      out.write("\n");
      out.write("            \n");
      out.write("            ");
 if (request.getAttribute("mensajeError3")!= null){
      out.write("\n");
      out.write("            <div style=\"color: red;\">\n");
      out.write("                ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensajeError3}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                 \n");
      out.write("            </div>\n");
      out.write("            ");
} 
      out.write("\n");
      out.write("            \n");
      out.write("            ");
 if (request.getAttribute("mensajeError4")!= null){
      out.write("\n");
      out.write("            <div style=\"color: red;\">\n");
      out.write("                ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensajeError4}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                 \n");
      out.write("            </div>\n");
      out.write("            ");
} 
      out.write("\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            ");
 if (request.getAttribute("mensajeError")!= null){
      out.write("\n");
      out.write("            <div style=\"color: red;\">\n");
      out.write("                ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensajeError}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                 \n");
      out.write("            </div>\n");
      out.write("            ");
} else {
      out.write("\n");
      out.write("            <div style=\"color: blue\">\n");
      out.write("                ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensajeÉxito}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("            </div>\n");
      out.write("                ");
 }
      out.write("\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("                \n");
      out.write("                \n");
      out.write("    </body>\n");
      out.write("</html>");
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
