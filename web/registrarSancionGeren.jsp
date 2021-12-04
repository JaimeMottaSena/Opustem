<%-- 
    Document   : registrarSancion
    Created on : 28/06/2021, 04:42:51 PM
    Author     : duban
--%>
<%@page import="ModeloVO.TipoSancionVO"%>
<%@page import="ModeloDAO.TipoSancionDAO"%>
<%@page import="ModeloVO.UsuarioVO"%>
<%@page import="ModeloDAO.UsuarioDAO"%>
<%@page import="ModeloVO.EventoVO"%>
<%@page import="ModeloDAO.EventoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Sesiones.jsp" %>
<!DOCTYPE html>
<html lang="es">


<!-- index.html  21 Nov 2019 03:44:50 GMT -->
<head>
  <meta charset="UTF-8">
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no" name="viewport">
  <title>Registrar Sanción</title>
  <!-- General CSS Files -->
  <link rel="stylesheet" href="assets/css/app.min.css">
  <!-- Template CSS -->
  <link rel="stylesheet" href="assets/css/style.css">
  <link rel="stylesheet" href="assets/css/components.css">
  <!-- Custom style CSS -->
  <link rel="stylesheet" href="assets/css/custom.css">
  <link rel='shortcut icon' type='image/x-icon' href='assets/img/tem.ico' />
  <link rel="stylesheet" href="css/sweetalert.css">
  <script src="js/sweetalert.min.js" type="text/javascript"></script>
</head>

<body>
  
  <div id="app">
    <div class="main-wrapper main-wrapper-1">
      <div class="navbar-bg"></div>
      <nav class="navbar navbar-expand-lg main-navbar sticky">
        <div class="form-inline mr-auto">
          <ul class="navbar-nav mr-3">
            <li><a href="#" data-toggle="sidebar" class="nav-link nav-link-lg
									collapse-btn"> <i data-feather="align-justify"></i></a></li>
            <li><a href="#" class="nav-link nav-link-lg fullscreen-btn">
                <i data-feather="maximize"></i>
              </a></li>
            
          </ul>
        </div>
        <ul class="navbar-nav navbar-right">
        
          <li class="dropdown"><a href="#" data-toggle="dropdown"
              class="nav-link dropdown-toggle nav-link-lg nav-link-user"> <img alt="image" src="assets/img/user.jpg"
                class="user-img-radious-style"> <span class="d-sm-none d-lg-inline-block"></span></a>
            <div class="dropdown-menu dropdown-menu-right pullDown">
              <div class="dropdown-title">Usuario: <%=usuario%></div>
              <a href="profile.html" class="dropdown-item has-icon"> <i class="far
										fa-user"></i> Perfil
              </a>  
              <div class="dropdown-divider"></div>
              <form method="post" action="Sesiones">
                  <a class="dropdown-item has-icon text-danger" href="Sesiones"> <i class="fas fa-sign-out-alt"></i>
                Cerrar Sesión
              </a>

                </form>
              
            </div>
          </li>
        </ul>
      </nav>
      <div class="main-sidebar sidebar-style-2">
        <aside id="sidebar-wrapper">
          <div class="sidebar-brand">
            <a href="index.html"> <img alt="image" src="assets/img/opus.png" class="header-logo" /> <span
                class="logo-name">Opustem</span>
            </a>
          </div>
          <ul class="sidebar-menu">
            <li class="menu-header">Módulos</li>
            <li class="dropdown">
              <a href="#" class="menu-toggle nav-link has-dropdown"><i data-feather="users"></i><span>Usuarios</span></a>
            <ul class="dropdown-menu">
              <li><a class="nav-link" href="consultarUsuario.jsp">Consultar Usuarios</a></li>
              <li><a class="nav-link" href="registrarUser.jsp">Registrar Usuario NUEVO</a></li>
            </ul>
            </li>
            <li class="dropdown">
              <a href="#" class="menu-toggle nav-link has-dropdown"><i data-feather="book"></i></i><span>Permisos</span></a>
              <ul class="dropdown-menu">
                <li><a class="nav-link" href="consultarPermiso.jsp">Consultar Permisos</a></li>
              </ul>
            </li>
            <li class="dropdown">
              <a href="#" class="menu-toggle nav-link has-dropdown"><i data-feather="calendar"></i></i><span>Eventos</span></a>
              <ul class="dropdown-menu">
                <li><a class="nav-link" href="consultarEvento.jsp">Consultar Eventos</a></li>
              </ul>
            </li>
            <li class="dropdown">
              <a href="#" class="menu-toggle nav-link has-dropdown"><i data-feather="alert-triangle"></i><span>Sanciones</span></a>
              <ul class="dropdown-menu">
                <li><a class="nav-link" href="consultarSancionGeren.jsp">Consultar Sanciones</a></li>
                <li><a class="nav-link" href="registrarSancionGeren.jsp">Registrar Sanción</a></li>
              </ul>
            </li>
          </ul>
        </aside>
      </div>
      <!-- Main Content -->
      <div class="main-content">
        <section class="section">
          <div class="selection-boby">
            <div class="row">
              <div class="col-12 col-md-12 col-lg-12">
                <div class="card">
                  <div class="card-header">
                    <h4>Registrar Sanción</h4>
                  </div>
                  <div class="card-body">
                    <form action="Sancion" method="POST">
                      <div class="form-row">
                          <div class="form-group col-md-4">
                              <label for="">Tipo Sanción</label>
                              <select name="textTipo" class="form-control" id="">
                                  <option value="">Seleccione...</option>
                                  <% 
                                      
                                   TipoSancionDAO TiSaDAO = new TipoSancionDAO();
                                  for( TipoSancionVO TiSaVO: TiSaDAO.listar()){
                                      
                              %>
                              <option value="<%=TiSaVO.getIdTipoSancion()%>"><%=TiSaVO.getNombreSancion()%></option>
                              <%
                              }
                              %>
                              </select>
                          </div>
                          <div class="form-group col-md-4">
                              <label for="">Usuario:</label>
                              <select name="textIdUsuario" class="form-control" id="">
                                  <option value="">Seleccione...</option>
                                  <% 
                                      
                                   UsuarioDAO usuDAO = new UsuarioDAO();
                                  for( UsuarioVO usuVO: usuDAO.listar()){
                                      
                              %>
                              <option value="<%=usuVO.getIdUsuario()%>"><%=usuVO.getAliasUsuario()%></option>
                              <%
                              }
                              %>
                              </select>
                          </div>
                          <div class="form-group col-md-4">
                              <label for="">Id Evento:</label>
                              <select name="textIdEvento" class="form-control" id="">
                               <% 
                                      
                                   EventoDAO eveDAO = new EventoDAO();
                                  for( EventoVO eveVO: eveDAO.listar()){
                                      
                              %>
                              <option value="<%=eveVO.getIdEvento()%>"><%=eveVO.getIdEvento()%></option>
                              <%
                              }
                              %>
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
                          <button class="btn btn-info btn-block">Registrar</button>
                          <input type="hidden"  value="5" name="opcion">
                      </div>
                      </div>
                  </form>
                  </div>
                </div>

              </div>

            </div>

          </div>
           
         
        </section>
        <div class="settingSidebar">
          <a href="javascript:void(0)" class="settingPanelToggle"> <i class="fa fa-spin fa-cog"></i>
          </a>
          <div class="settingSidebar-body ps-container ps-theme-default">
            <div class=" fade show active">
              <div class="setting-panel-header">Setting Panel
              </div>
              <div class="p-15 border-bottom">
                <h6 class="font-medium m-b-10">Select Layout</h6>
                <div class="selectgroup layout-color w-50">
                  <label class="selectgroup-item">
                    <input type="radio" name="value" value="1" class="selectgroup-input-radio select-layout" checked>
                    <span class="selectgroup-button">Light</span>
                  </label>
                  <label class="selectgroup-item">
                    <input type="radio" name="value" value="2" class="selectgroup-input-radio select-layout">
                    <span class="selectgroup-button">Dark</span>
                  </label>
                </div>
              </div>
              <div class="p-15 border-bottom">
                <h6 class="font-medium m-b-10">Sidebar Color</h6>
                <div class="selectgroup selectgroup-pills sidebar-color">
                  <label class="selectgroup-item">
                    <input type="radio" name="icon-input" value="1" class="selectgroup-input select-sidebar">
                    <span class="selectgroup-button selectgroup-button-icon" data-toggle="tooltip"
                      data-original-title="Light Sidebar"><i class="fas fa-sun"></i></span>
                  </label>
                  <label class="selectgroup-item">
                    <input type="radio" name="icon-input" value="2" class="selectgroup-input select-sidebar" checked>
                    <span class="selectgroup-button selectgroup-button-icon" data-toggle="tooltip"
                      data-original-title="Dark Sidebar"><i class="fas fa-moon"></i></span>
                  </label>
                </div>
              </div>
              <div class="p-15 border-bottom">
                <h6 class="font-medium m-b-10">Color Theme</h6>
                <div class="theme-setting-options">
                  <ul class="choose-theme list-unstyled mb-0">
                    <li title="white" class="active">
                      <div class="white"></div>
                    </li>
                    <li title="cyan">
                      <div class="cyan"></div>
                    </li>
                    <li title="black">
                      <div class="black"></div>
                    </li>
                    <li title="purple">
                      <div class="purple"></div>
                    </li>
                    <li title="orange">
                      <div class="orange"></div>
                    </li>
                    <li title="green">
                      <div class="green"></div>
                    </li>
                    <li title="red">
                      <div class="red"></div>
                    </li>
                  </ul>
                </div>
              </div>
              <div class="p-15 border-bottom">
                <div class="theme-setting-options">
                  <label class="m-b-0">
                    <input type="checkbox" name="custom-switch-checkbox" class="custom-switch-input"
                      id="mini_sidebar_setting">
                    <span class="custom-switch-indicator"></span>
                    <span class="control-label p-l-10">Mini Sidebar</span>
                  </label>
                </div>
              </div>
              <div class="p-15 border-bottom">
                <div class="theme-setting-options">
                  <label class="m-b-0">
                    <input type="checkbox" name="custom-switch-checkbox" class="custom-switch-input"
                      id="sticky_header_setting">
                    <span class="custom-switch-indicator"></span>
                    <span class="control-label p-l-10">Sticky Header</span>
                  </label>
                </div>
              </div>
              <div class="mt-4 mb-4 p-3 align-center rt-sidebar-last-ele">
                <a href="#" class="btn btn-icon icon-left btn-primary btn-restore-theme">
                  <i class="fas fa-undo"></i> Restore Default
                </a>
              </div>
            </div>
          </div>
        </div>
      </div>
      <footer class="main-footer">
        <div class="footer-left">
          <a href="templateshub.net">Templateshub</a></a>
        </div>
        <div class="footer-right">
        </div>
      </footer>
    </div>
  </div>
  <!-- General JS Scripts -->
  <script src="assets/js/app.min.js"></script>
  <!-- JS Libraies -->
  <script src="assets/bundles/apexcharts/apexcharts.min.js"></script>
  <!-- Page Specific JS File -->
  <script src="assets/js/page/index.js"></script>
  <!-- Template JS File -->
  <script src="assets/js/scripts.js"></script>
  <!-- Custom JS File -->
  <script src="assets/js/custom.js"></script>
  <script>
    //$(function() {
    
    const error =<%=request.getParameter("mensajeError")%>;
    if (error) {
        swal("Error", "No se pudo registrar la Sanción, por favor verifique.", "error");
    }
    const exito=<%=request.getParameter("mensajeExito")%>;
    if(exito){
        swal("¡Excelente!", "La Sanción se registró correctamente.", "success")
    }




//});

</script>
</body>


<!-- index.html  21 Nov 2019 03:47:04 GMT -->
</html>
