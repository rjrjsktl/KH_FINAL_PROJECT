
	$(document).ready(function() {
	    $(".btn_wraper button").hover(function() {
	        $(this).find("a").addClass("hover");
	    }, function() {
	        $(this).find("a").removeClass("hover");
	    });
	});

