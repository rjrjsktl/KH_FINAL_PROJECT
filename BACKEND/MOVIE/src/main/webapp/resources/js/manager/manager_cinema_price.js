$(document).ready(function () {

  const submitBtn = $('.bottom_Submit');


  submitBtn.on('click', () => {
    console.log('상영 영화관 : ' + cinema_Arr);
    console.log('상영 영화 : ' + movie_Arr);
    console.log('상영 시작일 : ' + startDate.val());
    console.log('상영 종료일 : ' + endDate.val());
    console.log('상영 시간 : ' + time_Arr);
  });

});
