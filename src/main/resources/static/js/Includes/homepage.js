/*-----------------------------------------------------------------------------------*/
/*	Homepage
/*-----------------------------------------------------------------------------------*/
var Homepage = function() {
    return {
        initialize : function() {

            this.loadMainCarouselBar();

        },
        loadMainCarouselBar : function() {

                $.getJSON('/home/main-carousel-bar', function(data) {
                        $.each(data.RESULTS, function(key, val) {
                                $('#home-slider').append('<div class="slider-item"><div class="img-cont"><img src="/public/images?path='+ val.imagePath +'" alt="'+ val.title +'" ></img></div></div>');
                        });
                        $("#home-slider").slick({
                            dots:!0,arrows:!1,
                            infinite:!0,speed:300,
                            autoplay:!0,autoplaySpeed:7e3,
                            slidesToShow:1
                        });

                        /*$('.jumbotron-slider').owlCarousel({
                                loop: true,
                                nav: false,
                                items: 1,
                                autoplay: true,
                                autoplayTimeout: 5000,
                                autoplayHoverPause: false
                        });*/
                });
        }
    }
}();
$(document).ready(function() {
	Homepage.initialize();
});
