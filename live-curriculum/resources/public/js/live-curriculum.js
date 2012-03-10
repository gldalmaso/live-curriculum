(function($){
    $(document).ready(function(){
	$.getJSON('/json/principais', function(data){
	    $('.principais').html(data.toString());
	});
    });
})(jQuery);