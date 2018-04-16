<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../header.jsp" %>


<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">

    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
        <h1 class="h2">Dashboard</h1>
    </div>

    <h5>Sliders</h5>
    <p><a href="<c:url value="/admin/services/add" />">Adicionar slider</a></p>
    <div class="table-responsive">
        <table class="table table-striped table-sm">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Imagem</th>
                    <th colspan="2">Opções</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${sliders}" var="slider">
                    <tr>
                        <td> <c:out value="${slider.sliderid}" /></td>
                        <td> <img src="<c:out value="/uploads/sliders/" />${slider.image}" alt="Slider image-${slider.sliderid}" width="60px" height="60px"/> </td>
                        <td> <a href="<c:url value="/admin/sliders/edit?sliderId=" />${slider.sliderid}">Atualizar</a> </td>
                        <td> <a href="<c:url value="/admin/sliders/delete?sliderId=" />${slider.sliderid}">Deletar</a> </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</main>

<%@include file="../footer.jsp" %>
