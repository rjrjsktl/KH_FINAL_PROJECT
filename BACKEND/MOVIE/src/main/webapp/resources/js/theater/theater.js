$(document).ready(function () {
  $(".location").click(function () {
    $(this).parent().css("background-color", "#484848");
    $(this).css("color", "#FCC400");
    $(".location").not(this).parent().css("background-color", "transparent");
    $(".location").not(this).css("color", "white");
  });

  function getCinemaNames(area) {
    $.ajax({
      url: "/movie/theater/normalTheater/selectArea",
      type: "GET",
      data: { area: area },
      success: function (response) {
        // clear cname-wrap
        $(".cname-wrap").empty();
        // iterate over response.cinemaNameList
        for (var i = 0; i < response.cinemaNameList.length; i++) {
          // create new anchor element with cinema name and href attribute
          var cinemaNameAnchor = $("<a class='gogo'></a>")
            .attr("href", "/movie/reserve/choicePlay")
            .text(response.cinemaNameList[i].cinemaName + "점");
          // create new span element and append the anchor
          var cinemaNameSpan = $("<span></span>").append(cinemaNameAnchor);
          // append span to cname-wrap
          $(".cname-wrap").append(cinemaNameSpan);
        }
      },
      error: function () {},
    });
  }

  // When a location is clicked, request cinema names for that location
  $(".location").click(function () {
    var area = $(this).text();
    getCinemaNames(area);
  });

  // When the page loads, request cinema names for the first location
  var firstArea = $(".location").first().text();
  getCinemaNames(firstArea);
});
