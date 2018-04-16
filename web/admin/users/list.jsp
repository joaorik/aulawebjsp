<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../header.jsp" %>


<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">

    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
        <h1 class="h2">Dashboard</h1>
    </div>

    <h5>Usuários</h5>
    <p><a href="<c:url value="/admin/users/add" />">Adicionar cliente</a></p>
    <div class="table-responsive">
        <table class="table table-striped table-sm">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Usuário</th>
                    <th>E-mail</th>
                    <th colspan="2">Opções</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td> <c:out value="${user.userid}" /> </td>
                        <td> <c:out value="${user.username}" /> </td>
                        <td> <c:out value="${user.email}" /> </td>
                        <td><a href="<c:url value="/admin/users/edit?userId=" />${user.userid}">Atualizar</a></td>
                        <td><a href="<c:url value="/admin/users/delete?userId=" />${user.userid}">Deletar</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</main>

<%@include file="../footer.jsp" %>
