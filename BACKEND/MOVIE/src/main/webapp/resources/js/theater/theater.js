

$(document).ready(function() {
    $(".area-name").click(function() {
        var index = $(this).index();

        $(".list-detail").addClass("none");

        $(this).find(".list-detail").removeClass("none").css("left", -(index * 97.51) + "px");
    });
});

$(document).ready(function() {
    $('.location').click(function() {
      $('.location').removeClass('yellowCol');
      
      $(this).addClass('yellowCol');
    });
  });