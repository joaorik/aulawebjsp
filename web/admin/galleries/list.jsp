<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../header.jsp" %>

<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">

    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
        <h1 class="h2">Dashboard</h1>
    </div>

    <h5>Galerias</h5>
    <p><a href="<c:url value="/admin/galleries/add" />">Adicionar imagem</a></p>
    <div class="table-responsive">
        <table class="table table-striped table-sm">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Imagem</th>
                    <th>Subtítulo</th>
                    <th colspan="2">Opções</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${galleries}" var="gallery">
                    <tr>
                        <td> <c:out value="${gallery.galleryid}" /> </td>
                        <td> <img src="<c:out value="/uploads/galleries/" />${gallery.image}" alt="Gallery image-${gallery.galleryid}" width="60px" height="60px"/> </td>
                        <td> <c:out value="${gallery.caption}" /> </td>
                        <td> <a href="<c:url value="/admin/galleries/edit?galleryId=" />${gallery.galleryid}">Atualizar</a> </td>
                        <td> <a href="<c:url value="/admin/galleries/delete?galleryId=" />${gallery.galleryid}">Deletar</a> </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</main>

<%@include file="../footer.jsp" %>
