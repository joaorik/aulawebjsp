<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="br">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta name="author" content="Joao">

    <title>Sinale Admin Painel</title>

    <link rel="icon" href="<c:url value="/favicon.ico" />">
    <!-- CSS -->
    <link href="<c:url value="/assets/css/admin.css" />" rel="stylesheet" type="text/css">
</head>

<body>

    <nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0">
        <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="<c:url value="/admin" />">Sinale Admin Painel</a>
        <ul class="navbar-nav px-3">
            <li class="nav-item text-nowrap">
                <a class="nav-link" href="<c:url value="/admin/logout" />">Logout</a>
            </li>
        </ul>
    </nav>

    <div class="container-fluid">
        <div class="row">
            <nav class="col-md-2 d-none d-md-block bg-light sidebar">
                <div class="sidebar-sticky">
                    <ul class="nav flex-column">
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/admin" />">
                                <span data-feather="home"></span> Dashboard
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/admin/clients" />">
                                <span data-feather="users"></span> Clientes
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/admin/galleries" />">
                                <span data-feather="airplay"></span> Galerias
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/admin/services" />">
                                <span data-feather="briefcase"></span> Serviços
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/admin/sliders" />">
                                <span data-feather="archive"></span> Sliders
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/admin/users" />">
                                <span data-feather="user-check"></span> Usuários
                            </a>
                        </li>
                    </ul>
                    <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
                        <span>Menu</span>
                    </h6>
                    <ul class="nav flex-column mb-2">
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/admin/logout" />">
                                <span data-feather="log-out"></span> Logout
                            </a>
                        </li>
                    </ul>
                </div>
            </nav>