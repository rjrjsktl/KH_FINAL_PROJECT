<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
            <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
                <%@ page session="false" %>

                    <!DOCTYPE html>
                    <html lang="en">

                    <head>
                        <meta charset="UTF-8">
                        <meta http-equiv="X-UA-Compatible" content="IE=edge">
                        <meta name="viewport" content="width=device-width, initial-scale=1.0">
                        <title>상품상세</title>
                        <link rel="stylesheet" href="${contextPath}/resources/css/common/outline.css">
                        <link rel="stylesheet" href="${contextPath}/resources/css/movieList/introduce.css">
                        <script src="https://kit.fontawesome.com/dc6e43e0ad.js" crossorigin="anonymous"></script>

                        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css" />
                        <script src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"></script>

                    </head>

                    <body>
                        <div id="wrap">

                            <jsp:include page="/WEB-INF/views/common/header.jsp" />

                            <main>

                                <section>
                                    <div class="swiper-container zeroOne">
                                        <div class="swiper-wrapper">
                                            <div class="swiper-slide">
                                                <img src="${detail.추가이미지 1}" alt="">
                                            </div>
                                            <div class="swiper-slide">
                                                <img src="${detail.추가이미지 2}" alt="">
                                            </div>
                                            <div class="swiper-slide">
                                                <img src="${detail.추가이미지 3}" alt="">
                                            </div>
                                            <div class="swiper-slide">
                                                <img src="${detail.추가이미지 4}" alt="">
                                            </div>
                                            <div class="swiper-slide">
                                                <img src="${detail.추가이미지 5}" alt="">
                                            </div>
                                        </div>

                                    </div>
                                    <div class="swiper-button-next"></div>
                                    <div class="swiper-button-prev"></div>

                                </section>

                                <div class="movie-detail-wrap">
                                    <div>
                                        <div>
                                            <!-- 이미지 205px 292px -->
                                            <a href=""><img src="${detail.추가이미지 1}" alt="" class="movie-poster-img"></a>
                                        </div>

                                        <div class="detail-info-wrap">
                                            <p><img src="${detail.메인이미지}"
                                                    class="age-img-area"><span>${detail.영화제목}</span></p>
                                            <ul>
                                                <li>관람객평점 <span>4.5</span>점</li>
                                                <li>예매율 <span>50</span>%</li>
                                                <li>누적관객수 <span>3</span>명</li>
                                            </ul>

                                            <ul class="movie-makers-wrap">
                                                <li>장르<span>${detail.영화장르}</span> <span>|</span> <span>${detail.영화등록일}
                                                    </span><span>|</span><span>${detail.영화상영시간}</span>분
                                                </li>
                                                <li>감독<span>${detail.감독이름}</span></li>
                                                <li class="actorList">주연<ul>
                                                        <li><a href="">${detail.배우}</a></li>
                                                        <li><a href="">지훈지훈,</a></li>
                                                        <li><a href="">지훈지훈,</a></li>
                                                        <li><a href="">지훈지훈,</a></li>
                                                        <li><a href="">지훈지훈,</a></li>
                                                        <li><a href="">지훈지훈,</a></li>
                                                        <li><a href="">지훈지훈,</a></li>
                                                        <li><a href="">지훈지훈</a></li>
                                                    </ul>


                                                </li>
                                            </ul>

                                            <div class="reservePageMove-wrap">
                                                <div>
                                                    <!-- 더미div -->
                                                </div>
                                                <div>
                                                    <ul>
                                                        <li>
                                                            <p><i class="fa-regular fa-share-from-square"></i></p>
                                                        </li>
                                                        <li>
                                                            <p><i class="fa-regular fa-thumbs-up"></i></p>
                                                        </li>
                                                        <li><a href="../reserve/reserve.html">예매하기</a></li>
                                                    </ul>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                </div>

                                <div class="steal-reply-wrap">
                                    <div>
                                        <div class="movide-expalin-wrap">
                                            <p class="info-btn">영화정보</p>
                                            <p class="star-btn">평점 및 관람평</p>
                                        </div>
                                        <!-- 영화정보 -->
                                        <div class="movie-detail">
                                            <p>${detail.영화제목}</p>
                                            <div class="fold_wrap">
                                                ${detail.줄거리}
                                            </div>
                                            <div>
                                                <p class="more_btn">더보기</p>
                                            </div>


                                            <div class="steelcut_wrap">
                                                <p><span>스틸컷</span></p>




                                                <div class="swiper-container first">
                                                    <div class="swiper-wrapper">

                                                        <div class="swiper-slide">
                                                            <img src="${detail.추가이미지 1}" alt="">
                                                        </div>
                                                        <div class="swiper-slide">
                                                            <img src="${detail.추가이미지 2}" alt="">
                                                        </div>
                                                        <div class="swiper-slide">
                                                            <img src="${detail.추가이미지 3}" alt="">
                                                        </div>
                                                        <div class="swiper-slide">
                                                            <img src="${detail.추가이미지 4}" alt="">
                                                        </div>
                                                        <div class="swiper-slide">
                                                            <img src="${detail.추가이미지 5}" alt="">
                                                        </div>
                                                    </div>

                                                    <div class="swiper-button-next"></div>
                                                    <div class="swiper-button-prev"></div>

                                                </div>

                                                <div class="swiper-container second">
                                                    <div class="swiper-wrapper">

                                                        <div class="swiper-slide">
                                                            <img src="${detail.추가이미지 1}" alt="">
                                                        </div>
                                                        <div class="swiper-slide">
                                                            <img src="${detail.추가이미지 2}" alt="">
                                                        </div>
                                                        <div class="swiper-slide">
                                                            <img src="${detail.추가이미지 3}" alt="">
                                                        </div>
                                                        <div class="swiper-slide">
                                                            <img src="${detail.추가이미지 4}" alt="">
                                                        </div>
                                                        <div class="swiper-slide">
                                                            <img src="${detail.추가이미지 5}" alt="">
                                                        </div>
                                                    </div>

                                                    <div class="swiper-button-next"></div>
                                                    <div class="swiper-button-prev"></div>

                                                </div>


                                            </div>

                                            <div class="actor_wrap">
                                                <p>출연자</p>
                                                <div>
                                                    <ul>
                                                        <li>
                                                            <div>
                                                                <img src="../../images/detail_movie_img/criminalCity-actor/72346_107_1.jpg"
                                                                    alt="">
                                                            </div>
                                                            <div><span>이상용</span><span>감독</span></div>
                                                        </li>
                                                        <li>
                                                            <div>
                                                                <img src="../../images/detail_movie_img/criminalCity-actor/73136_107_3.jpg"
                                                                    alt="">
                                                            </div>
                                                            <div><span>마동석</span>
                                                                <span>마석도</span>
                                                            </div>
                                                        </li>
                                                        <li>
                                                            <div>
                                                                <img src="../../images/detail_movie_img/criminalCity-actor/94130_107_2.jpg"
                                                                    alt="">
                                                            </div>
                                                            <div><span>전석호</span><span>김양호</span></div>
                                                        </li>
                                                        <li>
                                                            <div>
                                                                <img src="../../images/detail_movie_img/criminalCity-actor/70819_107_4.jpg"
                                                                    alt="">
                                                            </div>
                                                            <div><span>아오키 무네타카</span><span>리키</span></div>
                                                        </li>
                                                        <li>
                                                            <div>
                                                                <img src="../../images/detail_movie_img/criminalCity-actor/75521_107_5.jpg"
                                                                    alt="">
                                                            </div>
                                                            <div><span>고규필</span><span>초롱이</span></div>
                                                        </li>
                                                        <li>
                                                            <div>
                                                                <img src="../../images/detail_movie_img/criminalCity-actor/102522_107_6.jpg"
                                                                    alt="">
                                                            </div>
                                                            <div><span>이지훈</span><span>양종수</span></div>
                                                        </li>
                                                        <li>
                                                            <div>
                                                                <img src="../../images/detail_movie_img/criminalCity-actor/28736_107_4.jpg"
                                                                    alt="">
                                                            </div>
                                                            <div><span>이준혁</span><span>주성철</span></div>
                                                        </li>
                                                        <li>
                                                            <div>
                                                                <img src="../../images/detail_movie_img/criminalCity-actor/683_107_2.jpg"
                                                                    alt="">
                                                            </div>
                                                            <div><span>이범수</span><span>장태수</span></div>
                                                        </li>
                                                        <li>
                                                            <div>
                                                                <img src="../../images/detail_movie_img/criminalCity-actor/84891_107_5.jpg"
                                                                    alt="">
                                                            </div>
                                                            <div><span>김민재</span><span>김민재</span></div>
                                                        </li>




                                                    </ul>
                                                </div>
                                            </div>

                                        </div>

                                        <div class="movie-reply" style="display:none">

                                            <div class="replywritewrap">
                                                <span>평점 관람평 작성</span>
                                                <div class="star-wrapper">


                                                    <p class="star_rating">
                                                        <a class="on">★</a>
                                                        <a>★</a>
                                                        <a>★</a>
                                                        <a>★</a>
                                                        <a>★</a>
                                                    </p>

                                                </div>
                                                <div>
                                                    <form action="" class="replywrite">
                                                        <textarea name="" id="" cols="30" rows="3"></textarea>
                                                        <div class="replyBtn">관람평작성</div>
                                                    </form>
                                                </div>
                                            </div>

                                            <div class="replywrap">
                                                <div>
                                                    <p>관람객 관람평</p>
                                                    <div>

                                                        <ul>
                                                            <li>
                                                                <input type="radio" id="latest" name="choice">
                                                                <label for="latest"><span>최신순</span></label>
                                                            </li>
                                                            <li>
                                                                <input type="radio" id="popular" name="choice">
                                                                <label for="popular"><span>따봉순</span></label>
                                                            </li>
                                                        </ul>

                                                    </div>
                                                </div>
                                            </div>

                                            <div class="replyList">


                                                <ul>
                                                    <li class="review" style="display: none;"><span>
                                                            <img src="" alt="이미지">
                                                        </span>
                                                        <div>
                                                            <span>씨*럼</span>
                                                            <span>2023.05.24</span>
                                                            <span>★★★★★</span>
                                                            <span>5</span>
                                                        </div>
                                                        <div>
                                                            이제 다리안아픔 개꿀띠임 역시 현대의학 개좆지리누<br>
                                                            ㅋㅋㄹㅃㅃ<br>
                                                        </div>
                                                    </li>
                                                    <li class="review" style="display: none;"><span>
                                                            <img src="" alt="이미지">
                                                        </span>
                                                        <div>
                                                            <span>씨*럼</span>
                                                            <span>2023.05.24</span>
                                                            <span>★★★★★</span>
                                                            <span>5</span>
                                                        </div>
                                                        <div>
                                                            이제 다리안아픔 개꿀띠임 역시 현대의학 개좆지리누<br>
                                                            ㅋㅋㄹㅃㅃ<br>
                                                        </div>
                                                    </li>
                                                    <li class="review" style="display: none;"><span>
                                                            <img src="" alt="이미지">
                                                        </span>
                                                        <div>
                                                            <span>씨*럼</span>
                                                            <span>2023.05.24</span>
                                                            <span>★★★★★</span>
                                                            <span>5</span>
                                                        </div>
                                                        <div>
                                                            이제 다리안아픔 개꿀띠임 역시 현대의학 개좆지리누<br>
                                                            ㅋㅋㄹㅃㅃ<br>
                                                        </div>
                                                    </li>
                                                    <li class="review" style="display: none;"><span>
                                                            <img src="" alt="이미지">
                                                        </span>
                                                        <div>
                                                            <span>씨*럼</span>
                                                            <span>2023.05.24</span>
                                                            <span>★★★★★</span>
                                                            <span>5</span>
                                                        </div>
                                                        <div>
                                                            이제 다리안아픔 개꿀띠임 역시 현대의학 개좆지리누<br>
                                                            ㅋㅋㄹㅃㅃ<br>
                                                        </div>
                                                    </li>
                                                    <li class="review" style="display: none;"><span>
                                                            <img src="" alt="이미지">
                                                        </span>
                                                        <div>
                                                            <span>씨*럼</span>
                                                            <span>2023.05.24</span>
                                                            <span>★★★★★</span>
                                                            <span>5</span>
                                                        </div>
                                                        <div>
                                                            이제 다리안아픔 개꿀띠임 역시 현대의학 개좆지리누<br>
                                                            ㅋㅋㄹㅃㅃ<br>
                                                        </div>
                                                    </li>
                                                    <li class="review" style="display: none;"><span>
                                                            <img src="" alt="이미지">
                                                        </span>
                                                        <div>
                                                            <span>씨*럼</span>
                                                            <span>2023.05.24</span>
                                                            <span>★★★★★</span>
                                                            <span>5</span>
                                                        </div>
                                                        <div>
                                                            이제 다리안아픔 개꿀띠임 역시 현대의학 개좆지리누<br>
                                                            ㅋㅋㄹㅃㅃ<br>
                                                        </div>
                                                    </li>



                                                </ul>
                                            </div>
                                            <div class="morePage">더보기</div>

                                        </div>

                                    </div>
                                    </section>

                            </main>

                        </div>

                        <jsp:include page="/WEB-INF/views/common/footer.jsp" />

                        </div>

                        <div id="myModal" class="modal">
                            <div class="modal-content">
                                <div class="close-button">&times;</div>
                                <iframe src="../login/login.html" frameborder="0" width="500px" height="500px"></iframe>
                            </div>
                        </div>
                        <script src="https://code.jquery.com/jquery-3.6.0.min.js"
                            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
                            crossorigin="anonymous"></script>

                        <script src="${contextPath}/resources/js/main/header.js"></script>
                        <script src="${contextPath}/resources/js/introduce/introduce.js"></script>
                        </div>
                    </body>

                    </html>