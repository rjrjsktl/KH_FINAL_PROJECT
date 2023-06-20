<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>돌비</title>
    
        <link rel="stylesheet" href="${contextPath}/resources/css/common/outline.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/theater/theaterS2.css">
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"
        integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

</head>

<body>
    <div id="wrap">
    
        <jsp:include page="/WEB-INF/views/common/header.jsp" />

        <main>
            <div>
                <!-- 백그라운드이미지로 처리 -->
                <div>
                                      <ul>
                            <li> <a href="${contextPath}/theater/theaterS"> KMAX </li>
                            <li><a href="${contextPath}/theater/theaterS5">DOLBY</a> </li>
                            <li><a href="${contextPath}/theater/theaterS3">DISH & WINE</a> </li>
                            <li><a href="${contextPath}/theater/theaterS4">WITH A PUPPY</a> </li>
                            <li><a href="${contextPath}/theater/theaterS2">KIDS</a> </li>
                        </ul>
                </div>
            </div>

            <!-- 두번째 영역 -->
            <div>
                <div>
                    <div class="left_stheaterwrap">
                        <span>DOLBY</span>
                        <span>입체적 사운드, 단 하나의 시네마 </span>
                    </div>


                </div>
            </div>

            <div>
                <div>
                    <img src="${contextPath}/resources/images/teater_special/dolby_01.png" alt="">
                    <p>Dolby Atmos<br>
                        at the movies</p>
                </div>
            </div>
            <!-- 5 -->

            <div>
                <div>
                    <div><img src="${contextPath}/resources/images/teater_special/img-theater-db-view02.png">
                        <div>
                            <p style="font-size:1.5rem">DRAMATIC<br>
                                <strong style="font-size:2rem">IMAGING</strong>
                            </p>
                            <span>
                                본연의 색 그대로를 구현
                                <br>
                                작은 디테일도 놓치지 않는
                                <br>
                                영화의 리얼리티 극대화

                                <br>

                            </span>
                        </div>
                    </div>
                    <div><img src="${contextPath}/resources/images/teater_special/img-theater-db-view03.png">
                        <div><span>
                                <p style="font-size:1.5rem">MOVING <br>
                                    <strong style="font-size:2rem">AUDIO</strong>
                                </p>
                                Dolby Atmos의
                                <br>
                                역동적이고 입체적인 사운드로
                                <br>
                                마치 영화 속에 있는 듯한 경험

                                <br>
                            </span></div>
                    </div>
                    <div><img src="${contextPath}/resources/images/teater_special/img-theater-db-view04.png">
                        <div><span>
                                <p style="font-size:1.5rem">INSPIRED <br>
                                    <strong style="font-size:2rem">SPACE</strong>
                                </p>
                                어느 자리에서도
                                <br>
                                스크린 시야각에 방해 받지않는
                                <br>
                                매트 블랙 디자인<br>
                            </span></div>
                    </div>
                </div>
            </div>

            <!-- 6 -->
            <div>
                <div>
                    <img src="${contextPath}/resources/images/teater_special/img-theater-db-view05.png" alt="">
                    <p>몰입감 넘치는 사운드<br>DOLBY</p>
                </div>

            </div>
            <!-- 7 -->
            <div>
                <div>
                    <img src="${contextPath}/resources/images/teater_special/wp8869072-dolby-atmos-wallpapers.jpg" alt="">
                    <p>드라마틱한 이미지<br>
                        입체적인 사운드</p>
                </div>
            </div>

            <!-- 7-- -->
            <div>
                <div>
                    <p>KMAX 상영관</p>

                    <div class="stheater_wrap">
                        <ul>
                            <li><a href="#">DOLBY<span>건대</span></a></li>
                            <li><a href="#">DOLBY<span>신촌</span></a></li>
                            <li><a href="#">DOLBY<span>상암</span></a></li>
                            <li><a href="#">DOLBY<span>성남</span></a></li>
                            <li><a href="#">DOLBY<span>서면</span></a></li>
                            <li><a href="#">DOLBY<span>충남</span></a></li>
                            <li><a href="#">DOLBY<span>광주</span></a></li>

                        </ul>
                    </div>

                </div>
            </div>

            <!-- 8 -->
              <div>
                <div>
                    <!-- TOP3만 올리세요 스와이퍼넣기싫어 귀찮아 제발.. -->
                    <p>DOLBY 추천영화</p>
                    <div class="top3-wrap">
                        <div>
                            <a href="#"><img src="${contextPath}/resources/images/movieList/movie_01.jpg"></a>
                            <button>예매하기</button>
                        </div>
                        <div>
                            <a href="#"><img src="${contextPath}/resources/images/movieList/movie_01.jpg"></a>
                            <button>예매하기</button>
                        </div>
                        <div>
                            <a href="#"><img src="${contextPath}/resources/images/movieList/movie_01.jpg"></a>
                            <button>예매하기</button>
                        </div>
                    </div>
                </div>
            </div>


        </main>

    </div>
    
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />

  
    <script src="${contextPath}/resources/js/common/header.js"></script>
    <script src="${contextPath}/resources/js/theater/special-detail.js"></script>
</body>

</html>