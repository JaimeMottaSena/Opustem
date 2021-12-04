<%-- 
    Document   : consultarUsuario
    Created on : 20/10/2021, 08:33:09 AM
    Author     : JUAN DAVID PACHON
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.UsuarioDAO"%>
<%@page import="ModeloVO.UsuarioVO"%>
<%@include file="Sesiones.jsp" %>
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
        <link rel="stylesheet" href="assets/css/estilos2.css">
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
                <center> <h1>Consultar Usuario</h1></center>

                <center>
                    <form method="post" action="Usuario" >
                        <br>
                        <br>
                        <table  id="tablax" class="" >
                            <tr>

                                <th>
                                    Cédula<br>
                                    <input type="number" name="textDocumento"><br>


                                </th>
                            </tr>
                        </table><br>
                        <button class="btn btn-info btn-lg">Consultar</button>
                        <input type="hidden"  value="4" name="opcion">



                    </form>



                </center><br>



                <div>
                    <% if (request.getAttribute("mensajeError") != null) {%>
                    <div style="color:red;">${mensajeError}</div>
                    <%} else {%>
                    <div style="color: blue;">${mensajeÉxito}</div><%}%>
                </div><br><br>

                <form method="post" action="GenerarUsuarioPDF.jsp" target="_black">
                    <center>
                        <input type="submit"  class="btn btn-warning btn-lg" value="Generar en PDF">
                    </center>

                </form>
                <form method="post" action="Usuario">

                    <div class="mov" style="margin-left: 859px">
                        <input type="file" name="direccion"><br>
                        <button class="btn-warning">Subir Carga Mavisa</button>
                        <input type="hidden" value="6" name="opcion">

                    </div>




                </form>

                <form>
                    <table   id="tablax" class="table table-striped table-bordered" style="width:90%">
                        <tr>

                            <th>Alias</th>
                            <th>Nombre</th>
                            <th>Apelllido</th>
                            <th>Fecha Nacimiento</th>
                            <th>Correo</th>

                            <th>Tipo De documento</th>
                            <th>Numero De documento</th>
                            <th>Dirección</th>
                            <th>Teléfono</th>
                            <th>Cargo</th>
                            <th>Turno</th>
                        </tr>
                        <%

                            UsuarioVO UsuVO = new UsuarioVO();
                            UsuarioDAO UsuDAO = new UsuarioDAO(UsuVO);

                            ArrayList<UsuarioVO> listaUsuarios = UsuDAO.listar();
                            for (int i = 0; i < listaUsuarios.size(); i++) {
                                UsuVO = listaUsuarios.get(i);


                        %>
                        <tr>

                            <td><%=UsuVO.getAliasUsuario()%></td>
                            <td><%=UsuVO.getNombreUsuario()%></td>
                            <td><%=UsuVO.getApellidoUsuario()%></td>
                            <td><%=UsuVO.getFechaNacimiento()%></td>
                            <td><%=UsuVO.getCorreoUsuario()%></td>
                            <td><%=UsuVO.getTipoDocumento()%></td>
                            <td><%=UsuVO.getNumeroDocumento()%></td>
                            <td><%=UsuVO.getDireccionUsuario()%></td>
                            <td><%=UsuVO.getTelefono()%></td>
                            <td><%=UsuVO.getIdCargoFK()%></td>
                            <td><%=UsuVO.getIdTurnoFK()%></td>
                            <td>
                                <form method="post" action="Usuario">




                                    <input type="hidden" name="textEstado" value="<%=UsuVO.getEstado().equals("Activo") ? "Inactivo" : "Activo"%>">
                                    <input type="hidden" name="textId" value="<%=UsuVO.getIdUsuario()%>">
                                    <button value="5"  class=" btn btn-info btn-block"  name="opcion" id="adf"  >
                                        <%=UsuVO.getEstado().equals("Activo") ? "Inactivar" : "Activar"%>


                                        </div>





                                        <script src="assets/contador.js"></script>


                                </form>
                            </td>


                        </tr>
                        <% }%>
                    </table>
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

        <script>
            classboton = document.querySelector('#adf')
                    classboton.addEventListener('click', funtion(){
                    if (classboton == "Activar"){
                    classboton.classList.add('btn-success');
                    } else if (classboton == "Inactivar"){
                    classboton.classList.add(' btn-danger');
                    }
                    }
                    });
        </script>

 <div class="modal" id="modalExito" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                 <center>
                            <img style="border-radius: 10px;" src="img/Exito.PNG">
                        </center>
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Carga Masiva Completada <%=usuario%></h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
        <script>
            //$(function() {
            const error =<%=request.getParameter("mensaje1")%>;
            if (error) {
            $("#modalExito").modal("show");
            }
            const exito =<%=request.getParameter("mensaje2")%>;
            if (exito) {
            $("#modalExito").modal("show");
            }

//});
        </script>


    </body>
</html>