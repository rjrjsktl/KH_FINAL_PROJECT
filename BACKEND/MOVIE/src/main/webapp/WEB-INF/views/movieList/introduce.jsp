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
                        <title>${MovieDetail.movieTitle}</title>
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
                                                <img src="${MovieDetail.movieImg2}" alt="">
                                            </div>
                                            <div class="swiper-slide">
                                                <img src="${MovieDetail.movieImg3}" alt="">
                                            </div>
                                            <div class="swiper-slide">
                                                <img src="${MovieDetail.movieImg4}" alt="">
                                            </div>
                                            <div class="swiper-slide">
                                                <img src="${MovieDetail.movieImg5}" alt="">
                                            </div>
                                            <div class="swiper-slide">
                                                <img src="${MovieDetail.movieImg6}" alt="">
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
                                            <a href=""><img src="${MovieDetail.movieImg1}" alt=""
                                                    class="movie-poster-img"></a>
                                        </div>

                                        <div class="detail-info-wrap">


                                            <p>
                                                <c:choose>
                                                    <c:when test="${fn:contains(MovieDetail.mgNo, '전체')}">
                                                        <img src="${contextPath}/resources/images/age/aage.png"
                                                            class="age-img-area">
                                                    </c:when>
                                                    <c:when test="${fn:contains(MovieDetail.mgNo, '12')}">
                                                        <img src="${contextPath}/resources/images/age/12age.png"
                                                            class="age-img-area">
                                                    </c:when>
                                                    <c:when test="${fn:contains(MovieDetail.mgNo, '15')}">
                                                        <img src="${contextPath}/resources/images/age/15age.png"
                                                            class="age-img-area">
                                                    </c:when>
                                                    <c:otherwise>
                                                        <img src="${contextPath}/resources/images/age/18age.png"
                                                            class="age-img-area">
                                                    </c:otherwise>
                                                </c:choose>
                                                <span>${MovieDetail.movieTitle}</span>
                                            </p>
                                            <ul>
                                                <li>관람객평점 <span>4.5</span>점</li>
                                                <li>예매율 <span>50</span>%</li>
                                                <li>누적관객수 <span>${MovieDetail.movieWatched}</span>명</li>
                                            </ul>

                                            <ul class="movie-makers-wrap">
                                                <li>장르<span>${MovieDetail.genreName}</span> <span>|</span>
                                                    <span>${MovieDetail.movieOpen}
                                                    </span><span>|</span><span>${MovieDetail.movieRuntime}</span>분
                                                </li>
                                                <li>감독<span>${MovieDetail.movieDirector}</span></li>
                                                <li class="actorList">주연
                                                    <ul>
                                                        <c:forTokens var="name" items="${MovieDetail.movieCast}"
                                                            delims=",">
                                                            <li>
                                                                <a href="">
                                                                    <c:out value="${name}" />
                                                                </a>
                                                            </li>
                                                        </c:forTokens>
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
                                                            <p><i class="fa-regular fa-share-from-square"></i>
                                                            </p>
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
                                            <p>${MovieDetail.movieTitle}</p>
                                            <div class="fold_wrap">
                                                <p class="fold_content">
                                                    <c:out value="${MovieDetail.movieContent}" escapeXml="false" />
                                                </p>
                                            </div>
                                            <div>
                                                <p class="more_btn">더보기</p>
                                            </div>


                                            <div class="steelcut_wrap">
                                                <p><span>스틸컷</span></p>




                                                <div class="swiper-container first">
                                                    <div class="swiper-wrapper">

                                                        <div class="swiper-slide">
                                                            <img src="${MovieDetail.movieImg2}" alt="">
                                                        </div>
                                                        <div class="swiper-slide">
                                                            <img src="${MovieDetail.movieImg3}" alt="">
                                                        </div>
                                                        <div class="swiper-slide">
                                                            <img src="${MovieDetail.movieImg4}" alt="">
                                                        </div>
                                                        <div class="swiper-slide">
                                                            <img src="${MovieDetail.movieImg5}" alt="">
                                                        </div>
                                                        <div class="swiper-slide">
                                                            <img src="${MovieDetail.movieImg6}" alt="">
                                                        </div>
                                                    </div>

                                                    <div class="swiper-button-next"></div>
                                                    <div class="swiper-button-prev"></div>

                                                </div>

                                                <div class="swiper-container second">
                                                    <div class="swiper-wrapper">

                                                        <div class="swiper-slide">
                                                            <img src="${MovieDetail.movieImg2}" alt="">
                                                        </div>
                                                        <div class="swiper-slide">
                                                            <img src="${MovieDetail.movieImg3}" alt="">
                                                        </div>
                                                        <div class="swiper-slide">
                                                            <img src="${MovieDetail.movieImg4}" alt="">
                                                        </div>
                                                        <div class="swiper-slide">
                                                            <img src="${MovieDetail.movieImg5}" alt="">
                                                        </div>
                                                        <div class="swiper-slide">
                                                            <img src="${MovieDetail.movieImg6}" alt="">
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
                                                        <c:forTokens var="directorName"
                                                            items="${MovieDetail.movieDirector}" delims=","
                                                            varStatus="status">
                                                            <li>
                                                                <div>
                                                                    <img src="${contextPath}/resources/images/profile/bono.jpg"
                                                                        alt="">
                                                                </div>
                                                                <div>
                                                                    <span>
                                                                        <c:out value="${directorName}" />
                                                                    </span>
                                                                    <span>감독</span>
                                                                </div>
                                                            </li>
                                                        </c:forTokens>

                                                        <c:forTokens var="actorName" items="${MovieDetail.movieCast}"
                                                            delims="," varStatus="status">
                                                            <li>
                                                                <div>
                                                                    <img src="${contextPath}/resources/images/profile/bono.jpg"
                                                                        alt="">
                                                                </div>
                                                                <div>
                                                                    <span>
                                                                        <c:out value="${actorName}" />
                                                                    </span>
                                                                    <span>배우 ${status.count}</span>
                                                                </div>
                                                            </li>
                                                        </c:forTokens>
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
                                    <div id="btnContainer">
                                        <input id="returnBtn" type="button" onclick="goBack()" value="목록으로">
                                    </div>
                            </main>

                        </div>

                        <jsp:include page="/WEB-INF/views/common/footer.jsp" />

                        </div>

                        <script src="https://code.jquery.com/jquery-3.6.0.min.js"
                            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
                            crossorigin="anonymous"></script>

                        <script src="${contextPath}/resources/js/main/header.js"></script>
                        <script src="${contextPath}/resources/js/introduce/introduce.js"></script>
                        </div>
                    </body>

                    </html>