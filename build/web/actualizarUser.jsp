<%-- 
    Document   : actualizarUser
    Created on : 29/07/2021, 01:55:39 PM
    Author     : JUAN DAVID PACHON
--%>

<%@page import="ModeloVO.TurnoVO"%>
<%@page import="ModeloDAO.TurnoDAO"%>
<%@page import="ModeloVO.CargoVO"%>
<%@page import="ModeloDAO.CargoDAO"%>
<%@page import="ModeloVO.UsuarioVO"%>
<%@include file="Sesiones.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">


<!-- index.html  21 Nov 2019 03:44:50 GMT -->
<head>
  <meta charset="UTF-8">
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no" name="viewport">
  <title>Inicio</title>
  <!-- General CSS Files -->
  <link rel="stylesheet" href="assets/css/app.min.css">
  <!-- Template CSS -->
  <link rel="stylesheet" href="assets/css/style.css">
  <link rel="stylesheet" href="assets/css/components.css">
  <!-- Custom style CSS -->
  <link rel="stylesheet" href="assets/css/custom.css">
  <link rel='shortcut icon' type='image/x-icon' href='assets/img/tem.ico' />
</head>

<body>
  <div class="loader"></div>
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
              <center><h1>Actualizar Usuario</h1></center>
        <%
        UsuarioVO usuVO = (UsuarioVO)request.getAttribute("Usuario");
        if (usuVO != null){
        
        %>
        <div class="container">
        <form method="post" action ="Usuario">
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label  for=""> Usuario:</label><br>
                    <input type="text" class="form-control" value="<%=usuVO.getAliasUsuario()%>" name="textUsuario" placeholder="Ingrese aquí su alias de Usuario"><br>
                </div>
                <div class="form-group col-md-4">
                    <label for=""> Nombre:</label><br>
                    <input type="text" class="form-control" value="<%=usuVO.getNombreUsuario()%>" name="textNombre" placeholder="Digite su nombre"><br>
                </div>
                <div class="form-group col-md-4">
                    <label for=""> Apellido:</label><br>
                    <input type="text" class="form-control" value="<%=usuVO.getApellidoUsuario()%>" name="textApellido" placeholder="Digite su apellido"><br>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for=""> Fecha de Nacimiento:</label><br>
                    <input type="date" class="form-control" value="<%=usuVO.getFechaNacimiento()%>" name="textFecha"><br>
                </div>
                <div class="form-group col-md-4">
                    <label for=""> Correo:</label><br>
                    <input type="mail" class="form-control" value="<%=usuVO.getCorreoUsuario()%>" name="textCorreo" placeholder="Digite su correo"><br>
                </div>
                <div class="form-group col-md-4">
                    <label for=""> Clave:</label><br>
                    <input type="password" class="form-control" value="<%=usuVO.getClaveUsuario()%>" name="textClave" placeholder="Digite una clave segura"><br>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for=""> Tipo de  Documento:</label><br>
                    <select class="form-control" value="<%=usuVO.getTipoDocumento()%>" name="textTipoDoc" id="">
                        <option value="#">Seleccione...</option>
                        <option value="C.C">Cédula de ciudadanía</option>
                        <option value="C.E">Cédula de Extranjería</option>
                        <option value="T.I">Tarjeta de Identidad</option>
                    </select>
                </div>
                <div class="form-group col-md-4">
                    <label for=""> Número Documento:</label><br>
                    <input type="number" class="form-control" value="<%=usuVO.getNumeroDocumento()%>" name="textDocumento" placeholder="Digite su número de documento"><br>
                </div>
                <div class="form-group col-md-4">
                    <label for=""> Dirección de Residencia:</label><br>
                    <input type="text" class="form-control" value="<%=usuVO.getDireccionUsuario()%>" name="textDireccion" placeholder="Digite su dirección"><br>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="">Teléfono:</label><br>
                    <input type="number" class="form-control" value="<%=usuVO.getTelefono()%>" name="textTelefono" placeholder="Digite su número de teléfono"><br>
                </div>
                <div class="form-group col-md-4">
                    <label for="">Cargo:</label>
                   <select name="textCargo" value="<%=usuVO.getIdCargoFK()%>" class="form-control" id="">
                       <% 
                            
                         CargoDAO CarDAO = new CargoDAO();
                        for( CargoVO carVO: CarDAO.listar()){
                            
                    %>
                        <option value=""><%=carVO.getNombreCargo()%></option>
                       
                    <option value="<%=carVO.getIdCargoFK()%>"><%=carVO.getNombreCargo()%></option>
                    <%
                    }
                    %>
                   </select><br>
                </div>
                <div class="form-group col-md-4">
                    <label for="">Turno:</label>
                   <select name="textTurno" value="<%=usuVO.getIdTurnoFK()%>" class="form-control" id="">
                        <% 
                            
                         TurnoDAO TurDAO = new TurnoDAO();
                        for( TurnoVO turVO: TurDAO.listar()){
                            
                    %>
                     <option value="#"><%=turVO.getHoraEntrada()%></option>
                       
                    <option value="<%=turVO.getIdTurnoFK()%>"><%=turVO.getHoraEntrada()%></option>
                    
                    <%
                    }
                    %>
                   </select><br>
                   <input type="hidden" name="textId" value="<%=usuVO.getIdUsuario()%>">
                </div>
            </div>        
            <div class="form-row">
                <div class="form-group col-md-4"></div>
                <div class="form-group col-md-6"></div>
                <div class="form-group col-md-2">
                    <label for=""></label>
                <input type="hidden" name="textId" value="<%=usuVO.getIdUsuario()%>">
                 <button value="2" class="btn btn-warning btn-block" name="opcion" >Editar</button>
            </div>
            </div>
        </form>    
        
        
</div>
        <% }%>
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
                <li><a class="nav-link" href="consultarSancion.jsp">Consultar Sanciones</a></li>
                <li><a class="nav-link" href="registrarSancion.jsp">Registrar Sanción</a></li>
              </ul>
            </li>
          </ul>
        </aside>
      </div>
      <!-- Main Content -->
      <div class="main-content">
        <section class="section">
          <div class="row ">
           
         
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
</body>


<!-- index.html  21 Nov 2019 03:47:04 GMT -->
    </body>
</html>
