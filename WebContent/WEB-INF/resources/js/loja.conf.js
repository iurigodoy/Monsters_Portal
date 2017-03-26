
//Configuração para Acordião
$(function() {
    $( "#tabs" ).tabs();
});

//Configuração para Acordião
$(function() {
    $( "#tabs2" ).tabs();
});

//Configuração para Acordião
$(function() {
  $( "#tabs3" ).tabs();
});

$(function() {
    $(document).on('mouseenter.collapse', '[data-toggle=collapse]', function(e) {
        var $this = $(this),
            href, target = $this.attr('data-target') || e.preventDefault() || (href = $this.attr('href')) && href.replace(/.*(?=#[^\s]+$)/, '')
            ,
            option = $(target).hasClass('in') ? 'hide' : "show";
            $('.panel-collapse').not(target).collapse("hide");
            $(target).collapse(option);
    })
});
