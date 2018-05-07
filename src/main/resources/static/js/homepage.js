/*-----------------------------------------------------------------------------------*/
/*	Homepage
/*-----------------------------------------------------------------------------------*/
var Homepage = function() {
    return {
		initialize : function() {
			var _this = this;
			var pathname = window.location.pathname;
			if(pathname.indexOf('/partner') > 0) {
				this.loadPartner();
			} else {
				this.loadTopMenu();
				this.loadHomeSlider();
				this.loadPartnerSection();
				this.loadStepSection();
				this.loadPackageSection();
				this.loadDonasiSection();
			}
			this.loadFooterFirstSection();
			this.loadFooterSecondSection();
			this.loadFooterActionSection();
			this.loadFooterIdentitySection();
			$('#register_form').submit(function() {
				if(pathname.indexOf('/partner') > 0) {
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
				var smWidth = Math.ceil(24/data.RESULTS.length);
				$.each(data.RESULTS, function(key, val) {
					$('#section-partner-points-header').html(val.title);
					$('#section-partner-points-body').append('<div class="col-md-'+ mdWidth +' col-sm-'+ smWidth +' col-xs-'+ smWidth +'"><div class="img-cont"><img src="'+ val.imagePath +'" alt="'+ val.shortDescription +'"/></div><div class="text-cont">'+ val.description +'</div></div>');
				});
			});
		},
		loadStepSection : function() {
			$.getJSON('home/list-menus/STEP-SECTION', function(data) {
				var partial = false;
				var hrefStart = '<a data-toggle="modal" data-target="#modalform">';
				var hrefEnd = '</a>';
				var section = '';
				var header = '';
				$.each(data.RESULTS, function(key, val) {
					header = val.title;
					if(val.shortDescription && !partial) {
						section += '<div class="col-xs-12 margin-bottom20"><div class="row no-margin"><div class="col-xs-6 no-padding"><div class="img-cont">'+ (val.dataHref ? hrefStart : '') +'<div class="text-cont '+ (val.dataHref ? 'type2' : '') +'">'+ val.title +'</div><img src="'+ val.imagePath +'" alt=""/></div>'+ (val.dataHref ? hrefEnd : '') +'</div>';
						partial = true;
					} else if(val.shortDescription && partial) {
						section += '<div class="col-xs-6 no-padding"><div class="img-cont">'+ (val.dataHref ? hrefStart : '') +'<div class="text-cont '+ (val.dataHref ? 'type2' : '') +'">'+ val.title +'</div><img src="'+ val.imagePath +'" alt=""/></div></div>'+ (val.dataHref ? hrefEnd : '') +'</div></div>';
						partial = false;
					} else {
						section += '<div class="col-xs-12 margin-bottom20"><div class="img-cont">'+ (val.dataHref ? hrefStart : '') +'<div class="text-cont '+ (val.dataHref ? 'type2' : '') +'">'+ val.title +'</div><img src="'+ val.imagePath +'" alt=""/></div>'+ (val.dataHref ? hrefEnd : '') +'</div>';
					}
				});
				$('#step-section-points-header').html(header);
				$('#step-section-points-body').append(section);
			});
		},
		loadPackageSection : function() {
			var firstPackageElm = $('#first-package');
			var firstPackageContent = '<div class="content">';
			var initBerkah = true;
			var secondPackageElm = $('#second-package');
			var secondPackageContent = '<div class="content">';
			var secondPackageTextContent = '<div class="text-info"><ul>';
			var initHaji = true;
			$.getJSON('home/list-menus/PACKAGE-SECTION', function(data) {
				var i = 1;
				$.each(data.RESULTS, function(key, val) {
					if(val.title == 'Paket Berkah') {
						if(initBerkah) {
							firstPackageElm.append('<div class="title bg-orange">'+ val.title +'</div>');
							initBerkah = false;
						}
						firstPackageContent += '<div class="content-list"><div class="number">Berkah <span>'+ val.orders +'</span></div><div class="right">'+ val.description +'</div></div>';
					} else {
						if(initHaji) {
							secondPackageElm.append('<div class="title bg-tosca">'+ val.title +'</div>');
							secondPackageContent += '<div class="orange-box"><div class="row no-margin">';
							initHaji = false;
						}
						if(val.description) {
							secondPackageContent += i % 2 == 1 ? '<div class="col-sm-4 list"><div class="row no-padding"><div class="col-xs-4 no-padding"><img src="'+ val.imagePath +'" alt=""/></div><div class="col-xs-8 "><div class="text-cont">'+ val.description +'</div></div></div></div>' : '<div class="col-sm-8 list"><div class="row no-padding"><div class="col-sm-2 col-xs-4 no-padding"><img src="'+ val.imagePath +'" alt=""/></div><div class="col-sm-10 col-xs-8 no-padding"><div class="text-cont type2">'+ val.description +'</div></div></div></div>';
							i++;
						}
						if(val.shortDescription) {
							secondPackageTextContent += '<li>'+ val.shortDescription +'</li>';
						}
					}
				});
				firstPackageContent += '</div>';
				firstPackageElm.append(firstPackageContent);
				secondPackageContent += '</div></div>';
				secondPackageTextContent += '</ul></div></div>';
				secondPackageElm.append(secondPackageContent + secondPackageTextContent);
			});
		},
		loadDonasiSection : function() {
			$.getJSON('home/list-menus/DONASI-SECTION', function(data) {
				$.each(data.RESULTS, function(key, val) {
					$('#section-donasi-header').html(val.title);
					$('#section-donasi-body').append('<div class="row border-box bg-blue"><div class="col-sm-4 left"><div class="img-cont"><img src="'+ val.imagePath +'" alt=""/></div></div><div class="col-sm-8"><p>'+ val.description +'</p></div></div>');
				});
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
					$.ajax({
						'dataType' : 'json',
						'contentType' : 'application/json',
						'type' : 'POST',
						'url' : 'home/add-customer?g-recaptcha-response='+ captcha +'&_csrf='+ csrf,
						'data' : data,
						'success' : function(data) {
							$('#modalthanks').modal('show');
							$('#modalform').modal('hide');
						},
						'error' : function(data) {
							$('#modalfailed').modal('show');
							$('#modalform').modal('hide');
						}
					});
				}
				$('#submit_form').hide();
				$('#form_loader').show();
				saving();
				$('#submit_form').show();
				$('#form_loader').hide();
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
					$.ajax({
						'dataType' : 'json',
						'contentType' : 'application/json',
						'type' : 'POST',
						'url' : 'home/add-partner?g-recaptcha-response='+ captcha +'&_csrf='+ csrf,
						'data' : data,
						'success' : function(data) {
							$('#modalpartnerthanks').modal('show');
							$('#modalpartnerform').modal('hide');
						},
						'error' : function(data) {
							$('#modalfailed').modal('show');
							$('#modalpartnerform').modal('hide');
						}
					});
				}
				$('#submit_form').hide();
				$('#form_loader').show();
				saving();
				$('#submit_form').show();
				$('#form_loader').hide();
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
    }
}();
$(document).ready(function() {
	Homepage.initialize();
});
