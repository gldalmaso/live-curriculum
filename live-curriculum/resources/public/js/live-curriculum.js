(function($){
    
    var appendToItemsConhecimentos = function(item, items) {
	
	$('<span></span>').text(item.name).wrap('<div></div>').parent().addClass(function(){
	    var classes = 'untoggled';
	    for (var i = 0; i < item.categories.length; i++){
		classes += ' ' + item.categories[i];
		updateCategoryButtons(item.categories[i]);
	    }
	    return classes;
	}).appendTo(items);
    };

    var appendToItemsExperiencia = function(item, items) {
	$('<li></li>').append('<h4>' + item.company + '</h4>'
			     ).append('<h5>' + item.position + '</h5>'
				     ).append('<span>' + item.inicio + ' - ' + item.fim + '</span>').appendTo(items);
    };

    var categories = [];
    var updateCategoryButtons = function(category) {
	if ($.inArray(category, categories) < 0) {
	    categories.push(category);
	    var button = '<input type="checkbox" name="categorias" class="' + category + '" id="ck' + category + '">' + 
		'<label for="ck' + category + '">' + category + '</label></input>';
	    $('#categorias').append(button).children().filter('input').last().bind('click', (function(category){
		return function(){
		    if ($('.' + category).filter('input[name="categorias"]').attr('checked')) {
			$('.' + category).filter('div').toggleClass('ui-state-highlight', 500);
		    } else {
			$('.' + category).filter('div').toggleClass('ui-state-highlight', 500);
		    }
		};
	    })(category));
	    $('#ck' + category).button();
	}
    }

    var appendItemsFromJson = function(src, target, handler, callback) {
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
	appendItemsFromJson('/json/principais', '.principais div', appendToItemsConhecimentos);
	appendItemsFromJson('/json/complementares', '.complementares div', appendToItemsConhecimentos);
	appendItemsFromJson('/json/experiencia', '.experiencia ul', appendToItemsExperiencia);
    });
})(jQuery);