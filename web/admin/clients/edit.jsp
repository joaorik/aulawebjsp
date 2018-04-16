<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../header.jsp" %>

<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">

    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
        <h1 class="h2">Dashboard</h1>
    </div>

    <h5>Adicionar/Editar cliente</h5>
    <br>
    <form class="needs-validation" action="<c:url value="/admin/clients/edit" />" name="EditClient" method="POST">
        <input type="hidden" name="clientid" value="${client.clientid}">

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="name">Nome</label>
                <input type="text" class="form-control" id="name" name="name" value="${client.name}">
            </div>
            <div class="col-md-6 mb-3">
                <label for="address">Endereço</label>
                <input type="text" class="form-control" id="address" name="address" value="${client.address}">
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="cellphone">Celular</label>
                <input type="text" class="form-control" id="cellphone" name="cellphone" value="${client.cellphone}">
            </div>
            <div class="col-md-6 mb-3">
                <label for="email">E-mail</label>
                <input type="text" class="form-control" id="email" name="email" value="${client.email}">
            </div>
        </div>

        <div class="row">
            <div class="col-md-5 mb-3">
                <label for="city">Cidade</label>
                <input type="text" class="form-control" id="city" name="city" value="${client.city}">
            </div>
            <div class="col-md-4 mb-3">
                <label for="estate">Estado</label>
                <input type="text" class="form-control" id="estate" name="estate" value="${client.estate}">
            </div>
            <div class="col-md-3 mb-3">
                <label for="zip">CEP</label>
                <input type="text" class="form-control" id="zip" name="zip" value="${client.zip}">
            </div>
        </div>

        <div class="row">
            <div class="col-md-5 mb-3">
                <label for="addr_number">Número</label>
                <input type="text" class="form-control" id="addr_number" name="addr_number" value="${client.addr_number}">
            </div>
            <div class="col-md-4 mb-3">
                <label for="neighborhood">Bairro</label>
                <input type="text" class="form-control" id="neighborhood" name="neighborhood" value="${client.neighborhood}">
            </div>
            <div class="col-md-3 mb-3">
                <label for="phone">Telefone</label>
                <input type="text" class="form-control" id="phone" name="phone" value="${client.phone}">
            </div>
        </div>

        <hr class="mb-4">

        <button class="btn btn-success" type="submit">Enviar</button>
    </form>

</main>

<%@include file="../footer.jsp" %>
