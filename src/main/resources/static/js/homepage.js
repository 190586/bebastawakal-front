/*-----------------------------------------------------------------------------------*/
/*	Homepage
/*-----------------------------------------------------------------------------------*/
var Homepage = function() {
    return {
		initialize : function() {
			var _this = this;
			var pathname = window.location.pathname;
			if(pathname.indexOf('/partner') >= 0) {
				this.loadPartner();
			} else {
				this.loadHomeSlider();
				this.loadPartnerSection();
				this.loadStepSection();
				this.loadPackageSection();
				this.loadDonationSection();
			}
			this.loadTopMenu();
			this.loadFooterFirstSection();
			this.loadFooterSecondSection();
			this.loadFooterActionSection();
			this.loadFooterIdentitySection();
			$('#register_form').submit(function() {
				if(pathname.indexOf('/partner') >= 0) {
					_this.submitPartner(this);
				} else {
					_this.submitCustomer(this);
				}
				return false;
			});
		},
		loadTopMenu : function() {
			$.getJSON('home/list-menus/TOP-MENU', function(data) {
				var i = 0;
				$.each(data.RESULTS, function(key, val) {
					if(i > 0) {
						$('#menu-top').append('<span> | </span>');
					}
					$('#menu-top').append('<a href="'+ val.url +'">'+ val.title +'</a>');
					i++;
				});
			});
		},
        loadHomeSlider : function() {
			$.getJSON('home/home-slider', function(data) {
				$.each(data.RESULTS, function(key, val) {
					$('#home-slider').append('<div class="slider-item"><div class="img-cont"><img src="'+ val.imagePath +'" alt="'+ val.title +'" ></img></div></div>');
				});
				$('#home-slider').slick({
					dots:!0,arrows:!1,
					infinite:!0,speed:300,
					autoplay:!0,autoplaySpeed:7e3,
					slidesToShow:1
				});
			});
        },
		loadPartnerSection : function() {
			$.getJSON('home/list-menus/PARTNER-SECTION', function(data) {
				var mdWidth = Math.ceil(12/data.RESULTS.length);
				var smWidth = Math.ceil(12/data.RESULTS.length);
				$.each(data.RESULTS, function(key, val) {
					var titles = val.title.split(' ');
					var title1 = '', title2 = '';
					for(var i=0;i<titles.length;i++) {
						if(i < titles.length/2) {
							title1 += titles[i] +' ';
						} else {
							title2 += titles[i] +' ';
						}
					}
					title1 = '<span class="font-orange">'+ title1 +'</span>';
					$('#section-partner-points-header').html(title1 + title2);
					$('#section-partner-points-body').append('<div class="col-md-'+ mdWidth +' col-sm-'+ smWidth +' col-xs-'+ smWidth +'"><div class="img-cont"><img src="'+ val.imagePath +'" alt="'+ val.shortDescription +'"/></div><div class="text-cont">'+ val.description +'</div></div>');
				});
			});
		},
		loadStepSection : function() {
			$.getJSON('home/list-menus/STEP-SECTION', function(data) {
				var partial = false;
				var hrefStart = '', hrefEnd = '</a>', section = '', header = '';
				$.each(data.RESULTS, function(key, val) {
					header = val.title;
					if(val.url) {
						if(val.dataHref) {
							hrefStart = '<a data-toggle="modal" data-target="'+ val.url +'">';
						} else {
							hrefStart = '<a href="'+ val.url +'">';
						}
					}
					if(val.shortDescription && !partial) {
						section += '<div class="col-xs-12 margin-bottom20"><div class="row no-margin"><div class="col-xs-6 no-padding"><div class="img-cont">'+ (val.url ? hrefStart : '') +'<div class="text-cont">'+ val.shortDescription +'</div><img src="'+ val.imagePath +'" alt=""/></div>'+ (val.url ? hrefEnd : '') +'</div>';
						partial = true;
					} else if(val.shortDescription && partial) {
						section += '<div class="col-xs-6 no-padding"><div class="img-cont">'+ (val.url ? hrefStart : '') +'<div class="text-cont">'+ val.shortDescription +'</div><img src="'+ val.imagePath +'" alt=""/></div></div>'+ (val.url ? hrefEnd : '') +'</div></div>';
						partial = false;
					} else {
						section += '<div class="col-xs-12 margin-bottom20"><div class="img-cont">'+ (val.url ? hrefStart : '') +'<div class="text-cont">'+ val.description +'</div><img src="'+ val.imagePath +'" alt=""/></div>'+ (val.url ? hrefEnd : '') +'</div>';
					}
				});
				$('#step-section-points-header').html(header);
				$('#step-section-points-body').append(section);
			});
		},
		loadPackageSection : function() {
			var packageElm = $('#package-section');
			var packageContent = '<div class="content">';
			$.getJSON('home/list-menus/PACKAGE-SECTION', function(data) {
				var i = 1;
				$.each(data.RESULTS, function(key, val) {
					if(i == 1) {
						packageElm.append('<div class="title bg-orange">'+ val.title +'</div>');
					}
					packageContent += '<div class="content-list"><div class="number">Barakah <span>'+ val.orders +'</span></div><div class="right">'+ val.description +'</div></div>';				
					i++;
				});
				packageContent += '</div>';
				packageElm.append(packageContent);
			});
		},
		loadDonationSection : function() {
			var donationElm = $('#donation-section');
			var donationContent = '<div class="content">';
			$.getJSON('home/list-menus/DONATION-SECTION', function(data) {
				var i = 1;
				$.each(data.RESULTS, function(key, val) {
					if(i == 1) {
						donationElm.append('<div class="title bg-tosca">'+ val.title +'</div>');
					}
					donationContent += '<div class="logo-box text-center margin-bottom50"><div class="img-cont for__dompetduafa"><img src="'+ val.imagePath +'" alt=""></div></div>';
					donationContent += '<div class="orange-box"><div class="text-box"><p>'+ val.description +'</p></div></div>';
					i++;
				});
				donationContent += '</div>';
				donationElm.append(donationContent);
			});
		},
		loadFooterFirstSection : function() {
			$.getJSON('home/list-menus/FOOTER-FIRST-SECTION', function(data) {
				var first = true;
				var content = '';
				$.each(data.RESULTS, function(key, val) {
					if(first) {
						$('#footer-first-section').append('<h3 class="footer-title">'+ val.title +'</h3>');
						content += '<ul class="footer-links">';
						first = false;
					} else {
						content += '<li>'+ (val.url != null ? '<a href="'+ val.url +'">' : '') + val.title + (val.url != null ? '</a>' : '') +'</li>';
					}
				});
				content += '</ul>';
				$('#footer-first-section').append(content);
			});
		},
		loadFooterSecondSection : function() {
			$.getJSON('home/list-menus/FOOTER-SECOND-SECTION', function(data) {
				var first = true;
				var content = '';
				$.each(data.RESULTS, function(key, val) {
					if(first) {
						$('#footer-second-section').append('<h3 class="footer-title">'+ val.title +'</h3>');
						content += '<ul class="footer-links">';
						first = false;
					} else {
						content += '<li>'+ (val.url != null ? '<a href="'+ val.url +'">' : '') + val.title + (val.url != null ? '</a>' : '') +'</li>';
					}
				});
				content += '</ul>';
				$('#footer-second-section').append(content);
			});
		},
		loadFooterActionSection : function() {
			$.getJSON('home/list-menus/FOOTER-ACTION-SECTION', function(data) {
				$.each(data.RESULTS, function(key, val) {
					$('#footer-action-section').append('<div class="footer-item"><h3 class="footer-title">'+ val.title +'</h3><ul class="footer-links"><li><a href="'+ val.url +'">'+ val.shortDescription +'</a></li></ul></div>');
				});
			});
		},
		loadFooterIdentitySection : function() {
			var social = '<div class="footer-item"><ul class="footer-social">';
			$.getJSON('home/list-menus/FOOTER-IDENTITY-SECTION', function(data) {
				$.each(data.RESULTS, function(key, val) {
					if(val.imagePath) {
						social += '<li><a href="'+ val.url +'" target="_blank"><i class="'+ val.imagePath +'"></i></a></li>';
					} else {
						$('#footer-identity-section').append('<div class="footer-item"><h3 class="footer-title">'+ val.title +'</h3><ul class="footer-links"><li><p>'+ val.shortDescription +'</p></li></ul></div>');
					}
				});
				social += '</ul></div>';
				$('#footer-identity-section').append(social);
			});
		},
		initCustomer : function() {
			$('#input_name').val('');
			$('span.help-block.form-error.name-error').html('');
			$('#input_phone').val('');
			$('span.help-block.form-error.phone-error').html('');
			$('#input_email').val('');
			$('span.help-block.form-error.email-error').html('');
			$('#submit_form').show();
			$('#form_loader').hide();
			$('#modalform').modal('show');
		},
		submitCustomer : function(form) {
			var data = {};
			var captcha = '', csrf = '';
			$(form).serializeArray().map(function(x){if(x.name=='g-recaptcha-response'){captcha=x.value;}else if(x.name=='_csrf'){csrf=x.value;}else{data[x.name] = x.value;}});
			if(data.name && data.phone && data.email && grecaptcha.getResponse()) {
				data = JSON.stringify(data);
				var saving = function() {
					$('#submit_form').hide();
					$('#form_loader').show();
					$.ajax({
						'dataType' : 'json',
						'contentType' : 'application/json',
						'type' : 'POST',
						'url' : 'home/add-customer?g-recaptcha-response='+ captcha +'&_csrf='+ csrf,
						'data' : data,
						'success' : function(data) {
							$('#submit_form').show();
							$('#form_loader').hide();
							$('#modalthanks').modal('show');
							$('#modalform').modal('hide');
						},
						'error' : function(data) {
							$('#modalfailed').modal('show');
							$('#modalform').modal('hide');
						}
					});
				}
				saving();
			} else {
				if(!data.name) {
					$('span.help-block.form-error.name-error').html('Nama Harus Dimasukkan');
				} else {
					$('span.help-block.form-error.name-error').html('');
				}
				if(!data.phone) {
					$('span.help-block.form-error.phone-error').html('Telepon Harus Dimasukkan');
				} else {
					$('span.help-block.form-error.phone-error').html('');
				}
				if(!data.email) {
					$('span.help-block.form-error.email-error').html('Email Harus Dimasukkan');
				} else {
					$('span.help-block.form-error.email-error').html('');
				}
				if(grecaptcha.getResponse()) {
					$('span.help-block.form-error.captcha-error').html('Captcha Harus Dipilih');
				}
			}
		},
		loadPartner : function() {
			$.getJSON('home/list-partner', function(data) {
				$.each(data.RESULTS, function(key, val) {
					$('#avatar-path').append('<img src="'+ val.avatarPath +'" alt="" />');
					$('#content').html(val.content);
					$('#address').html(val.address);
				});
			});
		},
		initPartner : function() {
			$('#name').val('');
			$('span.help-block.form-error.name-error').html('');
			$('#companyName').val('');
			$('span.help-block.form-error.companyname-error').html('');
			$('#phone').val('');
			$('span.help-block.form-error.phone-error').html('');
			$('#email').val('');
			$('span.help-block.form-error.email-error').html('');
			$('#submit_form').show();
			$('#form_loader').hide();
			$('#modalpartnerform').modal('show');
		},
		submitPartner : function(form) {
			var data = {};
			var captcha = '', csrf = '';
			$(form).serializeArray().map(function(x){if(x.name=='g-recaptcha-response'){captcha=x.value;}else if(x.name=='_csrf'){csrf=x.value;}else{data[x.name] = x.value;}});
			if(data.name && data.companyName && data.phone && data.email && grecaptcha.getResponse()) {
				data = JSON.stringify(data);
				var saving = function() {
					$('#submit_form').hide();
					$('#form_loader').show();
					$.ajax({
						'dataType' : 'json',
						'contentType' : 'application/json',
						'type' : 'POST',
						'url' : 'home/add-partner?g-recaptcha-response='+ captcha +'&_csrf='+ csrf,
						'data' : data,
						'success' : function(data) {
							$('#submit_form').show();
							$('#form_loader').hide();
							$('#modalpartnerthanks').modal('show');
							$('#modalpartnerform').modal('hide');
						},
						'error' : function(data) {
							$('#submit_form').show();
							$('#form_loader').hide();
							$('#modalfailed').modal('show');
							$('#modalpartnerform').modal('hide');
						}
					});
				}
				saving();
			} else {
				if(!data.name) {
					$('span.help-block.form-error.name-error').html('Nama Harus Dimasukkan');
				} else {
					$('span.help-block.form-error.name-error').html('');
				}
				if(!data.companyName) {
					$('span.help-block.form-error.companyname-error').html('Nama Perusahaan Harus Dimasukkan');
				} else {
					$('span.help-block.form-error.companyname-error').html('');
				}
				if(!data.phone) {
					$('span.help-block.form-error.phone-error').html('Telepon Harus Dimasukkan');
				} else {
					$('span.help-block.form-error.phone-error').html('');
				}
				if(!data.email) {
					$('span.help-block.form-error.email-error').html('Email Harus Dimasukkan');
				} else {
					$('span.help-block.form-error.email-error').html('');
				}
				if(grecaptcha.getResponse()) {
					$('span.help-block.form-error.captcha-error').html('Captcha Harus Dipilih');
				}
			}
		},
		floatingButton : function() {
			var pathname = window.location.pathname;
			if(pathname.indexOf('/partner') >= 0) {
				var topoff=$('#site-container').offset() ? $('#site-container').offset().top : 0;
				var butt=$('#add-partner-button');
				if($(window).scrollTop()<=20) {
					if(!butt.hasClass('is-absolute')) {
						butt.addClass('is-absolute');
					}
				} else {
					if(butt.hasClass('is-absolute')) {
						butt.removeClass('is-absolute');
					}
				}
			} else {
				var l=$('.section-partner').offset() ? $('.section-partner').offset().top : 0;
				var e=$(window);
				e.scroll(
					function(){
						if(e.scrollTop()>=l)
							$('.float').removeClass('is-absolute');
						else
							$('.float').addClass('is-absolute');
					}
				);
			}
		}
    }
}();
$(document).ready(function() {
	Homepage.initialize();
});

$(window).scroll(function() {
	Homepage.floatingButton();
});