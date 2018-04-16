<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../header.jsp" %>

<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">

    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
        <h1 class="h2">Dashboard</h1>
    </div>

    <h5>Clientes</h5>
    <p><a href="<c:url value="/admin/clients/add" />">Adicionar cliente</a></p>
    <div class="table-responsive">
        <table class="table table-striped table-sm">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Nome</th>
                    <th>Cidade</th>
                    <th>Numero</th>
                    <th>Bairro</th>
                    <th>Telefone</th>
                    <th>Celular</th>
                    <th>E-mail</th>
                    <th>Cadastrado em</th>
                    <th colspan="2">Opções</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${clients}" var="client">
                    <tr>
                        <td> <c:out value="${client.clientid}" /> </td>
                        <td> <c:out value="${client.name}" /> </td>
                        <td> <c:out value="${client.city}" /> </td>
                        <td> <c:out value="${client.addr_number}" /> </td>
                        <td> <c:out value="${client.neighborhood}" /> </td>
                        <td> <c:out value="${client.phone}" /> </td>
                        <td> <c:out value="${client.cellphone}" /> </td>
                        <td> <c:out value="${client.email}" /> </td>
                        <td> <fmt:formatDate pattern="dd-MM-Y" value="${client.created_at}" /> </td>
                        <td> <a href="<c:url value="/admin/clients/edit?clientId=" />${client.clientid}">Atualizar</a> </td>
                        <td> <a href="<c:url value="/admin/clients/delete?clientId=" />${client.clientid}">Deletar</a> </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</main>

<%@include file="../footer.jsp" %>
