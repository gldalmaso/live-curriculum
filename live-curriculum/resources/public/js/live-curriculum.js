(function($){
    
    var appendToItemsConhecimentos = function(item, items) {
	$('<span></span>').text(item.name).addClass(function(){
	    var classes = '';
	    for (var i = 0; i < item.categories.length; i++){
		classes += ' ' + item.categories[i];
	    }
	    return classes;
	}).wrap('<li></li>').parent().appendTo(items);
    };

    var appendToItemsExperiencia = function(item, items) {
	$('<li></li>').append('<h4>' + item.company + '</h4>'
			     ).append('<h5>' + item.position + '</h5>'
				     ).append('<span>' + item.inicio + ' - ' + item.fim + '</span>').appendTo(items);
    };

    var appendItemsFromJson = function(src, target, handler) {
	$.getJSON(src, function(data){
	    var appendToItems = handler;
	    var items = $(target);
	    if (data.length) {
		for (var i = 0; i < data.length; i++) {
		    appendToItems(data[i], items);
		}
	    } else {
		appendToItems(data, items);
	    }
	});
    }; 

    $(document).ready(function(){
	appendItemsFromJson('/json/principais', '.principais ul', appendToItemsConhecimentos);
	appendItemsFromJson('/json/complementares', '.complementares ul', appendToItemsConhecimentos);
	appendItemsFromJson('/json/experiencia', '.experiencia ul', appendToItemsExperiencia);
    });
})(jQuery);