// Google Maps
function initMap() {
    var uluru = {
        lat: -23.1544823,
        lng: -46.9624864
    };
    var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 16,
        center: uluru
    });
    var marker = new google.maps.Marker({
        position: uluru,
        map: map,
        draggable: false
    });
}

// Owl Carousel
$('.owl-carousel').owlCarousel({
    loop: true,
    items: 1,
    singleItem: true,
    autoPlay: 3000
});


// To the top -- smooth scroll
$(window).scroll(function() {
    if ($(this).scrollTop() > 1500) {
        $('.scrolltop:hidden').stop(true, true).fadeIn();
    } else {
        $('.scrolltop').stop(true, true).fadeOut();
    }
});
$(function() {
    $(".scroll").click(function() {
        $("html, body").animate({
            scrollTop: $(".thetop").offset().top
        }, "1000");
        return false
    })
})

// Shows active on the page you are currently
$(document).ready(function() {
    $(document).on("scroll", onScroll);

    //smoothscroll
    $('a[href^="#"]').on('click', function(e) {
        e.preventDefault();
        $(document).off("scroll");

        $('a').each(function() {
            $(this).removeClass('active');
        })
        $(this).addClass('active');

        var target = this.hash,
            menu = target;
        $target = $(target);
        $('html, body').stop().animate({
            'scrollTop': $target.offset().top + 2
        }, 800, 'swing', function() {
            window.location.hash = target;
            $(document).on("scroll", onScroll);
        });
    });
});

function onScroll(event) {
    var scrollPos = $(document).scrollTop();
    $('#colorScrool a').each(function() {
        var currLink = $(this);
        var refElement = $(currLink.attr("href"));
        if (refElement.position().top <= scrollPos && refElement.position().top + refElement.height() > scrollPos) {
            $('#colorScrool ul li a').removeClass("active");
            currLink.addClass("active");
        } else {
            currLink.removeClass("active");
        }
    });
}
