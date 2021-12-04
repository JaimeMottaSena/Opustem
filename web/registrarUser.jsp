<%-- 
    Document   : registrarUser
    Created on : 29/07/2021, 01:51:34 PM
    Author     : JUAN DAVID PACHON
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="ModeloVO.CargoVO"%>
<%@page import="ModeloVO.TurnoVO"%>
<%@page import="ModeloDAO.CargoDAO"%>
<%@page import="ModeloDAO.TurnoDAO"%>
<%@include file="Sesiones.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no" name="viewport">
        <title>Registrar Sanción</title>
        <!-- General CSS Files -->
        <link rel="stylesheet" href="assets/css/app.min.css">
        <!-- Template CSS -->
        <link rel="stylesheet" href="assets/css/style.css">
        <link rel="stylesheet" href="assets/css/components.css">
        <link rel="stylesheet" href="assets/css/estilos.css">
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
                            <a href="menu.jsp"> <img alt="image" src="assets/img/opus.png" class="header-logo" /> <span
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
                        <div class="selection-boby">
                            <div class="row">
                                <div class="col-12 col-md-12 col-lg-12">
                                    <div class="card">
                                        <div class="card-header">
                                            <center><h1>Registrar Usuario</h1></center>
                                            <div class="card-body">
                                                <form method="post" action ="Usuario"  class="formulario" id="formulario">
                                                    <div class="form-row">
                                                        <div class="form-group col-md-4">
                                                            <!-- Grupo: Usuario -->
                                                            <div class="formulario__grupo " id="grupo__usuario">
                                                                <label for="textUsuario" class="formulario__label">Usuario</label>
                                                                <div class="formulario__grupo-input">
                                                                    <input type="text" class="formulario__input" id="textUsuario" name="textUsuario" placeholder="Alias de Usuario"placeholder="john123" required>
                                                                    <i class="formulario__validacion-estado fas fa-times-circle"></i>
                                                                </div>
                                                                <p class="formulario__input-error">El alias tiene que ser de 4 a 10 dígitos y solo puede contener numeros, letras y guion bajo.</p>
                                                            </div>

                                                        </div>
                                                        <div class="form-group col-md-4">
                                                            <!-- Grupo: Nombre -->
                                                            <div class="formulario__grupo" id="grupo__nombre">
                                                                <label for="textNombre" class="formulario__label">Nombre</label>
                                                                <div class="formulario__grupo-input">
                                                                    <input type="text" class="formulario__input" id="textNombre" name="textNombre" placeholder="Digite su nombre" required>
                                                                    <i class="formulario__validacion-estado fas fa-times-circle"></i>
                                                                </div>
                                                                <p class="formulario__input-error">El Nombre tiene que ser de 4 a 15 dígitos y solo puede contener numeros, letras y guion bajo.</p>
                                                            </div>
                                                        </div>
                                                        <div class="form-group col-md-4">
                                                            <!-- Grupo: Apellido -->
                                                            <div class="formulario__grupo" id="grupo__apellido">
                                                                <label for="textApellido" class="formulario__label">Apellido</label>
                                                                <div class="formulario__grupo-input">
                                                                    <input type="text" class="formulario__input" id="textApellido" name="textApellido" placeholder="Digite su apellido" required>
                                                                    <i class="formulario__validacion-estado fas fa-times-circle"></i>
                                                                </div>
                                                                <p class="formulario__input-error">El Apellido tiene que ser de 4 a 15 dígitos y solo puede contener numeros, letras y guion bajo.</p>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="form-row">
                                                        <div class="form-group col-md-4">
                                                            <!-- Grupo: FecchaNacimiento -->
                                                            <div class="formulario__grupo" id="grupo__fecha">
                                                                <label for="textFecha" class="formulario__label">Fecha De Nacimiento</label>
                                                                <div class="formulario__grupo-input">
                                                                    <input type="date" class="formulario__input" id="textFecha" name="textFecha" placeholder="" required>
                                                                    <i class="formulario__validacion-estado fas fa-times-circle"></i>
                                                                </div>
                                                                <p class="formulario__input-error">Solo se permiten Fechas</p>
                                                            </div>

                                                        </div>
                                                        <div class="form-group col-md-4">
                                                            <!-- Grupo: Correo Electronico -->
                                                            <div class="formulario__grupo" id="grupo__correo">
                                                                <label for="textCorreo" class="formulario__label">Correo Electrónico</label>
                                                                <div class="formulario__grupo-input">
                                                                    <input type="email" class="formulario__input" id="textCorreo" name="textCorreo" placeholder="correo@correo.com" required>
                                                                    <i class="formulario__validacion-estado fas fa-times-circle"></i>
                                                                </div>
                                                                <p class="formulario__input-error">El correo solo puede contener letras, numeros, puntos, guiones y guion bajo.</p>
                                                            </div>
                                                        </div>
                                                        <div class="form-group col-md-4">
                                                            <!-- Grupo: Contraseña -->
                                                            <div class="formulario__grupo" id="grupo__password">
                                                                <label for="textClave" class="formulario__label">Contraseña</label>
                                                                <div class="formulario__grupo-input">
                                                                    <input type="password" class="formulario__input" id="textClave" name="textClave" value="" placeholder="clave automatica haga click" required  onclick="Generar()">
                                                                    <i class="formulario__validacion-estado fas fa-times-circle"></i>
                                                                </div>
                                                                <p class="formulario__input-error">La contraseña tiene que ser de 4 a 20 dígitos.</p>
                                                                <input type="button" class="btn btn-outline-info" name="wf" onclick="Mostrar()" value="&#x1f576;">
                                                            </div>
                                                        </div>
                                                        <script src="assets/generado.js"></script>
                                                        <div class="form-row">
                                                            <div class="form-group col-md-4">
                                                                <!-- Grupo: Tipódocumento -->
                                                                <div class="formulario__grupo" id="grupo__tipodoc">
                                                                    <label for="textTipoDoc" class="formulario__label">Tipo de documento</label>
                                                                    <div class="formulario__grupo-input">
                                                                        <select class="formulario__input" name="textTipoDoc" id="textTipoDoc" required>
                                                                            <option value="#">Seleccione...</option>
                                                                            <option value="C.C">Cédula de ciudadanía</option>
                                                                            <option value="C.E">Cédula de Extranjería</option>
                                                                            <option value="T.I">Tarjeta de Identidad</option>
                                                                        </select>
                                                                        <i class="formulario__validacion-estado fas fa-times-circle"></i>
                                                                    </div>
                                                                    <p class="formulario__input-error">Solo se permiten Fechas</p>
                                                                </div>
                                                            </div>
                                                            <div class="form-group col-md-4">
                                                                <!-- Grupo: Numero Documento -->
                                                                <div class="formulario__grupo" id="grupo__numerodoc">
                                                                    <label for="telefono" class="formulario__label">Numero de documento</label>
                                                                    <div class="formulario__grupo-input">
                                                                        <input type="text" class="formulario__input" id="textDocumento" name="textDocumento" placeholder="10002586" required>
                                                                        <i class="formulario__validacion-estado fas fa-times-circle"></i>
                                                                    </div>
                                                                    <p class="formulario__input-error">El Numero de documento solo puede contener numeros y el maximo son 10 dígitos.</p>
                                                                </div> 
                                                            </div>
                                                            <div class="form-group col-md-4">
                                                                <!-- Grupo: Direccion -->
                                                                <div class="formulario__grupo" id="grupo__direccion">
                                                                    <label for="textDireccion" class="formulario__label">Direccion</label>
                                                                    <div class="formulario__grupo-input">
                                                                        <input type="text" class="formulario__input" id="textDireccion" name="textDireccion" placeholder="Digite su dirección" placeholder="Digite su apellido" required>
                                                                        <i class="formulario__validacion-estado fas fa-times-circle"></i>
                                                                    </div>
                                                                    <p class="formulario__input-error"> La direccion solo puede tener 4 a 15 dígitos y solo puede contener numeros, letras y guion bajo.</p>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="form-row">
                                                            <div class="form-group col-md-4">
                                                                <!-- Grupo: Telefono-->
                                                                <div class="formulario__grupo" id="grupo__telefono">
                                                                    <label for="telefono" class="formulario__label">Telefono</label>
                                                                    <div class="formulario__grupo-input">
                                                                        <input type="text" class="formulario__input" id="textTelefono" name="textTelefono" placeholder="Digite su número de teléfono" required>
                                                                        <i class="formulario__validacion-estado fas fa-times-circle"></i>
                                                                    </div>
                                                                    <p class="formulario__input-error">El Numero de telefono solo puede contener numeros y el maximo son 10 dígitos.</p>
                                                                </div>
                                                            </div>
                                                            <div class="form-group col-md-4">
                                                                <label for="">Cargo:</label>
                                                                <select name="textCargo" class="form-control" id="" required>
                                                                    <option value="">Seleccione Su Cargo...</option>
                                                                    <%

                                                                        CargoDAO CarDAO = new CargoDAO();
                                                                        for (CargoVO carVO : CarDAO.listar()) {

                                                                    %>
                                                                    <option value="<%=carVO.getIdCargoFK()%>"><%=carVO.getNombreCargo()%></option>
                                                                    <%
                                                                        }
                                                                    %>
                                                                </select>
                                                            </div>
                                                            <div class="form-group col-md-4">
                                                                <label for="">Turno:</label>
                                                                <select name="textTurno" class="form-control" id="" required>
                                                                    <option value="">Seleccione Su Turno...</option>
                                                                    <%
                                                                        TurnoDAO TurDAO = new TurnoDAO();
                                                                        for (TurnoVO turVO : TurDAO.listar()) {

                                                                    %>
                                                                    <option value="<%=turVO.getIdTurnoFK()%>"><%=turVO.getHoraEntrada()%></option>

                                                                    <%
                                                                        }
                                                                    %>
                                                                </select>
                                                            </div>

                                                            <div class="form-group col-md-4">
                                                                <label for=""> Estado:</label><br>
                                                                <select class="form-control" name="textEstado" id="" required>
                                                                    <option value="Activo">Activo</option>  
                                                                </select>
                                                            </div>


                                                        </div>        

                                                        <div class="form-group col-md-4">
                                                            <label for=""></label>

                                                            <button class="btn btn-info btn-block">Registrar</button>
                                                            <input type="hidden"  value="1" name="opcion">
                                                        </div>
                                                    </div>
                                                </form>    

                                                <script src="assets/formulario.js"></script>
                                                <script src="https://kit.fontawesome.com/2c36e9b7b1.js" crossorigin="anonymous"></script>
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

        <div class="modal" id="modalError1" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Ocurrio Un Error</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <center>
                            <img style="border-radius: 10px;" src="img/error.PNG">
                        </center>
                        <div class="form-group"></div>
                        <p>Algo Ocurrio no se pudo registrar el usuario</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal" id="modalExito" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Usuario Registrado</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <center>
                            <img style="border-radius: 10px;" src="img/Exito.PNG">
                        </center>
                        <div class="form-group"></div>
                        <p>Registro Exitoso Bienvenido a OpusTem</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>
     
 <script>
    //$(function() {
    const error =<%=request.getParameter("mensajeError")%>;
    if (error) {
        swal("Error", "No se pudo registrar el usuario por favor verifique.", "error");
    }
    const exito=<%=request.getParameter("mensajeExito")%>;
    if(exito){
        swal("¡Excelente!", "el usuario se registró correctamente.", "success")
    }
    
   
    </script>



    </body>
</html>