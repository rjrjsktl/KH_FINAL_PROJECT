/*
$(document).ready(function() {
  var modal = $('#myModal');
  var btn = $('#myBtn');
  var span = $('.close-button').eq(0);

  btn.click(function() {
    modal.css('display', 'block');
  });

  span.click(function() {
    modal.css('display', 'none');
  });

  $(window).click(function(event) {
    if (event.target == modal[0]) {
      modal.css('display', 'none');
    }
  });
});


//   span.click(function() {
//     modal.css('display', 'none');
//   });


window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}
*/

// 메뉴창 하버
$(document).ready(function () {
  $(".navBar, .dummy").hover(
    function () {
      $(".navBar ul").stop().slideDown(150);
      $(".dummy").css("display", "flex");
    },
    function () {
      $(".navBar ul").stop().slideUp(150);
      $(".dummy").css("display", "none");
    }
  );

  // 검색
  $(".submitBTN").click(function () {
    var keyword = $("input[name='keyword']").val();
  });
});
