$(document).ready(function () {
  $(".area-name").click(function () {
    var index = $(this).index();

    $(".list-detail").addClass("none");

    $(this)
      .find(".list-detail")
      .removeClass("none")
      .css("left", -(index * 97.51) + "px");
  });

  $(".location").click(function () {
    var area = $(this).text();
    console.log(area);
    $.ajax({
      url: "/movie/theater/normalTheater/selectArea",
      type: "GET",
      data: { area: area },
      success: function (response) {
        console.log(response);
        $(".list-detail").html();
      },
      error: function () {},
    });
  });
});
