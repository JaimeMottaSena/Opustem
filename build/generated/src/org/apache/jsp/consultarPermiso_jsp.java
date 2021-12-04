package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ModeloDAO.TipoPermisoDAO;
import ModeloVO.TipoPermisoVO;
import java.util.ArrayList;
import ModeloVO.PermisoVO;
import ModeloDAO.PermisoDAO;
import ModeloVO.UsuarioVO;
import ModeloDAO.UsuarioDAO;
import ModeloVO.UsuarioVO;

public final class consultarPermiso_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("--%>\n");
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
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n");
      out.write("   <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>\n");
      out.write("     <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css\">\n");
      out.write("    <title>Paginacion</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"sidebar\">\n");
      out.write("    <div class=\"logo-details\">\n");
      out.write("        \n");
      out.write("      <i class='bx bxs-time-five icon' ></i>\n");
      out.write("      <a href=\"menu.jsp\">\n");
      out.write("        <div class=\"logo_name\">Opustem</div>\n");
      out.write("        </a>\n");
      out.write("        <i class='bx bx-menu' id=\"btn\" ></i>\n");
      out.write("    </div>\n");
      out.write("    <ul class=\"nav-list\">\n");
      out.write("      <li>\n");
      out.write("       <a href=\"consultarUsuario.jsp\">\n");
      out.write("         <i class='bx bx-user' ></i>\n");
      out.write("         <span class=\"links_name\">Usuarios</span>\n");
      out.write("       </a>\n");
      out.write("       <span class=\"tooltip\">Usuarios</span>\n");
      out.write("     </li>\n");
      out.write("     <li>\n");
      out.write("       <a href=\"consultarPermiso.jsp\">\n");
      out.write("         <i class='bx bxs-spreadsheet' ></i>\n");
      out.write("         <span class=\"links_name\">Permisos</span>\n");
      out.write("       </a>\n");
      out.write("       <span class=\"tooltip\">Permisos</span>\n");
      out.write("     </li>\n");
      out.write("     <li>\n");
      out.write("       <a href=\"#\">\n");
      out.write("         <i class='bx bxs-calendar-event' ></i>\n");
      out.write("         <span class=\"links_name\">Eventos</span>\n");
      out.write("       </a>\n");
      out.write("       <span class=\"tooltip\">Eventos</span>\n");
      out.write("     </li>\n");
      out.write("     <li>\n");
      out.write("       <a href=\"consultarSancion.jsp\">\n");
      out.write("         <i class='bx bxs-info-square'></i>\n");
      out.write("         <span class=\"links_name\">Sanciones</span>\n");
      out.write("       </a>\n");
      out.write("       <span class=\"tooltip\">Sanciones</span>\n");
      out.write("     </li>\n");
      out.write("     <li class=\"profile\">\n");
      out.write("         <div class=\"profile-details\">\n");
      out.write("           <img src=\"profile.jpg\" alt=\"profileImg\">\n");
      out.write("           <div class=\"name_job\">\n");
      out.write("             <div class=\"name\">Prem Shahi</div>\n");
      out.write("             <div class=\"job\">Web designer</div>\n");
      out.write("           </div>\n");
      out.write("         </div>\n");
      out.write("         <i class='bx bx-log-out' id=\"log_out\" ></i>\n");
      out.write("     </li>\n");
      out.write("    </ul>\n");
      out.write("  </div>\n");
      out.write("    <section class=\"home-section\">\n");
      out.write("        <div class=\"container col-md-12\">\n");
      out.write("          <nav class=\"navbar navbar-light\" style=\"border-radius: 20px; background-color: #160E75;\">\n");
      out.write("\n");
      out.write("                <h1 class=\"text-light font-italic\">Bienvenido: ");
      out.print(usuario);
      out.write("</h1>\n");
      out.write("                <form method=\"post\" action=\"Sesiones\">\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-secondary mb-2\">Cerrar Sesión</button>\n");
      out.write("\n");
      out.write("                </form>\n");
      out.write("            </nav>\n");
      out.write("        </div>\n");
      out.write("                <center><h1>Consultar Permisos</h1>\n");
      out.write("                <a href=\"registrarPermiso.jsp\" class=\"btn btn-info btn-block col-md-2\" >Registrar un Permiso</a></center>\n");
      out.write("    <div class=\"container\" style=\"margin-top: 10px;padding: 5px\">\n");
      out.write("    <table id=\"tablax\" class=\"table table-striped table-bordered\" style=\"width:100%\">\n");
      out.write("        <thead>\n");
      out.write("                <th>Id Permiso</th>\n");
      out.write("                <th>Tipo de Permiso</th>\n");
      out.write("                <th>Fecha de solicitud</th>\n");
      out.write("                <th>Fecha de permiso</th>\n");
      out.write("                <th>Descripccion</th>\n");
      out.write("                <th>Hora de salida</th>\n");
      out.write("                <th>regreso</th>\n");
      out.write("                <th>estado del permiso</th>\n");
      out.write("                <th>Acciones</th>\n");
      out.write("                \n");
      out.write("             </thead>\n");
      out.write("                ");

                                   
                    PermisoVO PerVO = new PermisoVO();
                     PermisoDAO PerDAO = new PermisoDAO();
                     ArrayList<PermisoVO>listaPermisos= PerDAO.listar();
                     for (int i = 0; i<listaPermisos.size(); i++){
                     
                         PerVO = listaPermisos.get(i); 
                     
                
      out.write("\n");
      out.write("           <tbody>\n");
      out.write("            <tr>\n");
      out.write("                ");

                    
                TipoPermisoDAO TiPerDAO = new TipoPermisoDAO();
                TipoPermisoVO TiPeVO = new TipoPermisoVO();
                 TiPeVO = TiPerDAO.consultarId(PerVO.getIdTipoPermisoFK());
                 
  
                 
                
      out.write("\n");
      out.write("                <th>");
      out.print(PerVO.getIdPermiso());
      out.write("</th>\n");
      out.write("                <td>");
      out.print(TiPeVO.getNombrePermiso());
      out.write("</td>              \n");
      out.write("                <td>");
      out.print(PerVO.getFechaSolicitud());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(PerVO.getFechaPermiso());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(PerVO.getDescripcion());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(PerVO.getHoraSalida());
      out.write("</td\n");
      out.write("                 <td>");
      out.print(PerVO.getRegreso());
      out.write("</td>\n");
      out.write("                  <td>");
      out.print(PerVO.getEstadoPermiso());
      out.write("</td>\n");
      out.write("                <td>\n");
      out.write("                    <form method=\"post\" action=\"Permiso\">\n");
      out.write("                        <input type=\"hidden\" name=\"textId\" value=\"");
      out.print(PerVO.getIdPermiso());
      out.write("\">\n");
      out.write("                    <button value=\"2\" class=\"btn btn-warning btn-block\" name=\"opcion\" >Editar</button>\n");
      out.write("                    \n");
      out.write("                    <a class=\"btn btn-danger\" href=\"/Permiso?opcion=4\">Eliminar</a>\n");
      out.write("                    </form>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            </tbody>\n");
      out.write("            \n");
      out.write("            ");
 }
      out.write("\n");
      out.write("              \n");
      out.write("        </table>\n");
      out.write("</div>\n");
      out.write("            </section>\n");
      out.write("\n");
      out.write("    <!-- JQUERY -->\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.4.1.js\"\n");
      out.write("        integrity=\"sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=\" crossorigin=\"anonymous\">\n");
      out.write("        </script>\n");
      out.write("    <!-- DATATABLES -->\n");
      out.write("    <script src=\"https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js\">\n");
      out.write("    </script>\n");
      out.write("    <!-- BOOTSTRAP -->\n");
      out.write("    <script src=\"https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js\">\n");
      out.write("    </script>\n");
      out.write("    <script>\n");
      out.write("  let sidebar = document.querySelector(\".sidebar\");\n");
      out.write("  let closeBtn = document.querySelector(\"#btn\");\n");
      out.write("  let searchBtn = document.querySelector(\".bx-search\");\n");
      out.write("\n");
      out.write("  closeBtn.addEventListener(\"click\", ()=>{\n");
      out.write("    sidebar.classList.toggle(\"open\");\n");
      out.write("    menuBtnChange();//calling the function(optional)\n");
      out.write("  });\n");
      out.write("\n");
      out.write("  searchBtn.addEventListener(\"click\", ()=>{ // Sidebar open when you click on the search iocn\n");
      out.write("    sidebar.classList.toggle(\"open\");\n");
      out.write("    menuBtnChange(); //calling the function(optional)\n");
      out.write("  });\n");
      out.write("\n");
      out.write("  // following are the code to change sidebar button(optional)\n");
      out.write("  function menuBtnChange() {\n");
      out.write("   if(sidebar.classList.contains(\"open\")){\n");
      out.write("     closeBtn.classList.replace(\"bx-menu\", \"bx-menu-alt-right\");//replacing the iocns class\n");
      out.write("   }else {\n");
      out.write("     closeBtn.classList.replace(\"bx-menu-alt-right\",\"bx-menu\");//replacing the iocns class\n");
      out.write("   }\n");
      out.write("  }\n");
      out.write("  </script>\n");
      out.write("    <script>\n");
      out.write("        $(document).ready(function () {\n");
      out.write("            $('#tablax').DataTable({\n");
      out.write("                language: {\n");
      out.write("                    processing: \"Tratamiento en curso...\",\n");
      out.write("                    search: \"Buscar&nbsp;:\",\n");
      out.write("                    lengthMenu: \"Agrupar de _MENU_ items\",\n");
      out.write("                    info: \"Mostrando del item _START_ al _END_ de un total de _TOTAL_ items\",\n");
      out.write("                    infoEmpty: \"No existen datos.\",\n");
      out.write("                    infoFiltered: \"(filtrado de _MAX_ elementos en total)\",\n");
      out.write("                    infoPostFix: \"\",\n");
      out.write("                    loadingRecords: \"Cargando...\",\n");
      out.write("                    zeroRecords: \"No se encontraron datos con tu busqueda\",\n");
      out.write("                    emptyTable: \"No hay datos disponibles en la tabla.\",\n");
      out.write("                    paginate: {\n");
      out.write("                        first: \"Primero\",\n");
      out.write("                        previous: \"Anterior\",\n");
      out.write("                        next: \"Siguiente\",\n");
      out.write("                        last: \"Ultimo\"\n");
      out.write("                    },\n");
      out.write("                    aria: {\n");
      out.write("                        sortAscending: \": active para ordenar la columna en orden ascendente\",\n");
      out.write("                        sortDescending: \": active para ordenar la columna en orden descendente\"\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                scrollY: 400,\n");
      out.write("                lengthMenu: [ [10, 25, -1], [10, 25, \"All\"] ],\n");
      out.write("            });\n");
      out.write("        });\n");
      out.write("    </script>\n");
      out.write("<a href=\"menu.jsp\">Volver</a>\n");
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
