<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="br">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta name="author" content="Joao">
    
    <title>Sinale</title>
    
    <!-- CSS -->
    <link href="<c:url value="/vendors/fontawesome/css/fontawesome-all.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value="/vendors/lightbox2/dist/css/lightbox.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value="/vendors/owlcarousel2/dist/assets/owl.carousel.min.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value="/vendors/owlcarousel2/dist/assets/owl.theme.default.min.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value="/assets/css/site.css" />" rel="stylesheet" type="text/css" />
</head>

<body>

    <!-- Header -->
    <header class="thetop">
        <nav class="navbar navbar-expand-lg fixed-top">
            <a class="navbar-brand" href="<c:url value="/" />">Sinale</a>
            <div class="esconde-nav" id="colorScrool">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item"> <a class="nav-link" href="#home">Home</a> </li>
                    <li class="nav-item"> <a class="nav-link" href="#servicos">Serviços</a> </li>
                    <li class="nav-item"> <a class="nav-link" href="#galeria">Galeria</a> </li>
                    <li class="nav-item"> <a class="nav-link" href="#contato">Contato</a> </li>
                </ul>
            </div>
            <div class="flex-center">
                <div class="top-right login">
                    <a href="<c:url value="/admin" />">Login</a>
                </div>
            </div>
        </nav>
    </header>

    <!-- Content -->
    <main role="main" id="home">

        <!-- Carousel -->
        <div id="owlCarousel" class="owl-carousel owl-theme">
            <jsp:useBean id="sliders" class="org.aulaweb.dao.SliderDAO"></jsp:useBean>
            <c:forEach items="${sliders.sliders}" var="slider">
                <div class="item"> <img src="<c:url value="/uploads/sliders/" />${slider.image}" alt="Slider-${slider.sliderid}"> </div>
            </c:forEach>
        </div>

        <!-- Services -->
        <div class="container servicos" id="servicos">
            <div class="row">
                <div class="col-md-12">
                    <h2 class="featurette-servico text-center"><span class="text-muted">Serviços</span></h2>
                    <p class="lead text-center">Com profissionais treinados e qualificados, a Sinale fornece um excelente atendimento com os melhores resultados para o todo tipo de pequenos reparos e serviços especializados de reforma e manutenção tais como pedreiros, pintores, eletricistas, encanadores, marcenaria rápida, gesseiros, jardineiros e muito outros serviços.</p>
                </div>

                <hr class="featurette-divider">
                
                <jsp:useBean id="services" class="org.aulaweb.dao.ServiceDAO"></jsp:useBean>
                <c:forEach items="${services.services}" var="service">
                    <div class="col-lg-4">
                        <img class="servicos-circle" src="<c:url value="/uploads/services/" />${service.image}" alt="${service.title}" width="140" height="140">
                    <h2>${service.title}</h2>
                    <p>${service.content}</p>
                </div>
                </c:forEach>
                
            </div>
        </div>

        <!-- Gallery -->
        <div class="album py-5 bg-light" id="galeria">
            <div class="container">

                <div class="col-md-12">
                    <h2 class="featurette-servico text-center"><span class="text-muted">Galeria</span></h2>
                    <p class="lead text-center">Fotos referentes a nossos serviços. Clique na imagem que deseja para visualizar a foto! Saiba mais sobre todos os nossos serviços. Aproveite e Faça um orçamento conosco.</p>
                </div>

                <div class="row">
                
                    <jsp:useBean id="galleries" class="org.aulaweb.dao.GalleryDAO"></jsp:useBean>
                    <c:forEach items="${galleries.galleries}" var="gallery">
                        <div class="col-md-4">
                        <div class="card mb-4 box-shadow">
                            <a href="<c:url value="/uploads/galleries/" />${gallery.image}" data-lightbox="roadtrip" data-title="${gallery.caption}">
                                <img class="card-img-top" src="<c:url value="/uploads/galleries/" />${gallery.image}" alt="Gallery-${gallery.galleryid}">
                            </a>
                        </div>
                    </div>
                    </c:forEach>
                    
                </div>
            </div>
        </div>

        <!-- Google Maps -->
        <div id="map"></div>

        <!-- Contact -->
        <div class="container contato-info" id="contato">
            <div class="row">
                <div class="col-md-12 text-center">
                    <h2 class="featurette-servico text-center"><span class="text-muted">Contato</span></h2>
                    <p class="lead text-center">Você pode entrar em contato ou nos visitar em nosso escritório de segunda a sexta das 8:00 - 17:00.</p>
                </div>
                <div class="text-center contact-info col-md-4 container">
                    <ul class="information-list">
                        <li><i class="fas fa-map-marker"></i><span>Rua João Manzan, 316, Jardim das Tulipas, <br> Jundiaí-SP</span></li>
                        <li><i class="fas fa-phone"></i><span><a href="tel:01148060559">(11) 4806-0559</a></span></li>
                        <li><i class="fas fa-envelope-open"></i><a href="mailto:contato@sinale.com.br">contato@sinale.com.br</a></li>
                    </ul>
                </div>
            </div>

            <!-- Contact Form -->
            <div class="col-md-12 contato-info">
                <h4 class="mb-3 text-center">Formulário de contato</h4>
                <p class="lead text-center">Deixei sua sugestão, dúvida ou crítica e responderemos o mais breve possível.</p>
                <form class="needs-validation" action="#" method="post">
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="nome">Nome</label>
                            <input type="text" class="form-control" id="nome" placeholder="Nome" required>
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="email">E-mail</label>
                            <input type="email" class="form-control" id="email" placeholder="E-mail" required>
                        </div>
                    </div>

                    <div class="mb-3">
                        <label for="mensagem">Mensagem</label>
                        <div class="input-group">
                            <textarea class="form-control" id="mensagem" rows="5" name="mensagem" placeholder="Mensagem" required></textarea>
                        </div>
                    </div>

                    <button class="btn enviar" type="submit">Enviar</button>
                </form>
            </div>
        </div>

        <!-- To top -->
        <div class="scrolltop">
            <div class="scroll icon"><i class="fa fa-4x fa-angle-up"></i></div>
        </div>

        <!-- Footer -->
        <footer class="page-footer">
            <!-- Social links -->
            <div class="container">
                <div class="row" style="padding-top: 15px;">
                    <div class="col-md-12 py-3">
                        <div class="text-center">
                            <!--Facebook-->
                            <a class="fb-ic links" href="#" target="_blank">
                                <i class="fab fa-facebook-square fa-lg mr-md-5 mr-3 fa-2x"> </i>
                            </a>
                            <!--Twitter-->
                            <a class="tw-ic links" href="#" target="_blank">
                                <i class="fab fa-twitter-square fa-lg mr-md-5 mr-3 fa-2x"> </i>
                            </a>
                            <!--Google +-->
                            <a class="gplus-ic links" href="#" target="_blank">
                                <i class="fab fa-google-plus fa-lg mr-md-5 mr-3 fa-2x"> </i>
                            </a>
                            <!--Linkedin-->
                            <a class="li-ic links" href="#" target="_blank">
                                <i class="fab fa-linkedin fa-lg mr-md-5 mr-3 fa-2x"> </i>
                            </a>
                            <!--Instagram-->
                            <a class="ins-ic links" href="#" target="_blank">
                                <i class="fab fa-instagram fa-lg mr-md-5 mr-3 fa-2x"> </i>
                            </a>
                            <!--Pinterest-->
                            <a class="pin-ic links" href="#" target="_blank">
                                <i class="fab fa-pinterest fa-lg fa-2x"> </i>
                            </a>
                        </div>
                    </div>
                </div>
            </div>

            <!--Copyright-->
            <div class="footer-copyright py-3 text-center text-white">
                © 2018 Copyright <a href="#">Sinale</a>
            </div>
        </footer>
    </main>

    <!-- Javascript -->
    <script src="<c:url value="/vendors/jquery/jquery-3.3.1.min.js" />" type="text/javascript"></script>
    <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBI6yreMxqsm-wuLrBIdNvawJcbkyAOnj8&callback=initMap" type="text/javascript"></script>
    <script src="<c:url value="/vendors/lightbox2/dist/js/lightbox.js" />" type="text/javascript"></script>
    <script src="<c:url value="/vendors/owlcarousel2/dist/owl.carousel.min.js" />" type="text/javascript"></script>
    <script src="<c:url value="/assets/js/site.js" />" type="text/javascript"></script>

</body>
</html>
