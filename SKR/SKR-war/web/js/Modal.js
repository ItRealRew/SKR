var elements = $('.modal-overlay, .modal');

$('.OpenModal').click(function(){
    elements.addClass('active');
});

$('.close-modal').click(function(){
    elements.removeClass('active');
});