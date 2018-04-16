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

        <title>Sinale - Login</title>

        <link rel="icon" href="<c:url value="/favicon.ico" />">
        <!-- CSS -->
        <link href="<c:url value="/assets/css/login.css" />" rel="stylesheet">
    </head>

    <body>

        <form class="form-signin" action="<c:url value="/admin/login" />" method="POST">
            <div class="text-center mb-4">
                <img class="mb-4" src="<c:url value="/assets/imgs/logo.png" />" alt="Logo">
                <h1 class="h3 mb-3 font-weight-normal">Login area</h1>
                <p>Área Restrita - Clique <a href="<c:url value="/" />" class="text-primary m-l-5"><b>aqui</b></a> para voltar à Home</p>
                <p> <font color="red">${errorMessage}</font> </p>
            </div>

            <div class="form-label-group">
                <input type="email" id="email" name="email" class="form-control" placeholder="E-mail" required>
                <label for="email">E-mail</label>
            </div>

            <div class="form-label-group">
                <input type="password" id="passwd" name="passwd" class="form-control" placeholder="Senha" required>
                <label for="passwd">Senha</label>
            </div>

            <div class="checkbox mb-3">
                <label>
                    <input type="checkbox" value="remember-me"> Lembrar-me
                </label>
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
            <p class="mt-5 mb-3 text-muted text-center">&copy; 2018</p>
        </form>

    </body>
</html>