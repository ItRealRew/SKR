var elements = $('.modal-overlay, .modal');

//$('.OpenModal').click(function(){
//    elements.addClass('active');
//});
//
//$('.close-modal').click(function(){
//    elements.removeClass('active');
//});

            $(function () {
                $('.OpenModal').click(function () {
                    var modal = $(this).data('modal');
                    $('#' + modal).addClass('active');
                    $('#' + modal).find('.modal').addClass('active');
                });
 
                $('.close-modal').click(function () {
                    $(this).parent().parent().removeClass('active');
                    $(this).parent().removeClass('active');
                });
            });