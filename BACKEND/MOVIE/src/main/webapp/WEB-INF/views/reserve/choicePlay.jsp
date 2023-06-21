<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>예매선택 페이지</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/reserve/choicePlay.css">
    <link rel="stylesheet"	href="${contextPath}/resources/css/common/outline.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css" />  
    <script src="https://kit.fontawesome.com/dc6e43e0ad.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"></script>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <script src="${contextPath}/resources/js/reserve/choicePlay.js" defer></script>

</head>

<body>
    <div id="wrap">
        <jsp:include page="/WEB-INF/views/common/header.jsp" />

        <!-- 예매 페이지  -->

        <!-- 예매 페이지  -->

        <main>
          <section>

              <div>
                  <div>
                    <p id="cinema_select">극장 선택</p>
                  </div>
                  <div>Tab</div>
                  <div>
                      <div>
                          <ul id="area_list">
                              <li><a href="#none" class="clicked">서울</a></li>
                              <li><a href="#none">인천 경기</a></li>
                              <li><a href="#none">대전 충남 충북</a></li>
                              <li><a href="#none">광주 전남 전북</a></li>
                              <li><a href="#none">부산 울산 경남</a></li>
                              <li><a href="#none">대구 경북</a></li>
                              <li><a href="#none">강원</a></li>
                              <li><a href="#none">제주</a></li>
                          </ul>
                          <ul id="special_list" style="display: none">
                            
                          </ul>
                      </div>
                      <div>
                          <ul id="cinema_list">
                            <c:forEach var="cinema" items="${reserveMap['cinemaList']}">
                              <li><a href="#none">${cinema['cinemaName']}</a></li>
                            </c:forEach>
                          </ul>
                      </div>
                      
                  </div>
              </div>
              <div>
                  <div>
                    <p id="movie_select">영화 선택</p>
                  </div>
                  <div>
                    <div><a href="#none" id="movie_option1">영화명 순</a></div>
                    <div><a href="#none" id="movie_option2" class="clicked">예매율 순</a></div>
                  </div>
                  <div>
                    <ul class="movielist" id="movielist_text">
                      <c:forEach var="movie" items="${reserveMap['movieList']}">
                        <li><a href="#none">
                           <c:choose>
                             <c:when test="${fn:contains(movie['mgNo'], '전체')}">
                               <div class="age00">All</div>
                             </c:when>
                             <c:when test="${fn:contains(movie['mgNo'], '12')}">
                               <div class="age12">12</div>
                             </c:when>
                             <c:when test="${fn:contains(movie['mgNo'], '15')}">
                               <div class="age15">15</div>
                             </c:when>
                             <c:otherwise>
                               <div class="age18">18</div>
                             </c:otherwise>
                           </c:choose> 
                           <div><span class="movie_name">${movie['movieTitle']}</span></div>
                           
                        </a></li>
                      </c:forEach>
                    </ul>
                 
                    <ul class="movielist" id="movielist_thumb">
                      <c:forEach var="movie" items="${reserveMap['thumbList']}" varStatus="status">
                        <li><a href="#none">
                          <div>
                            <img src="${movie['movieImg1']}"/>
                            <span>${status.count}</span>
                          </div>
                          <div>
                            <div>
                              <c:choose>
                                <c:when test="${fn:contains(movie['mgNo'], '전체')}">
                                  <div class="age00">All</div>
                                </c:when>
                                <c:when test="${fn:contains(movie['mgNo'], '12')}">
                                  <div class="age12">12</div>
                                </c:when>
                                <c:when test="${fn:contains(movie['mgNo'], '15')}">
                                  <div class="age15">15</div>
                                </c:when>
                                <c:otherwise>
                                  <div class="age18">18</div>
                                </c:otherwise>
                              </c:choose> 
                              <div><span class="movie_name">${movie['movieTitle']}</span></div>
                            </div>
                            <div>
                              <div>
                                <div>예매율 : <strong><span>10.0</span>%</strong></div>
                                <div><i class="fa solid fa-star"></i><strong><span>9.0</span></strong></div>
                              </div>
                              <div>개봉일 : <span>${movie['movieOpen']}</span></div>
                            </div>
                          </div>
                        </a></li>
                      </c:forEach>
                    </ul>
                    
                      
                    
                  </div>
              </div>
              <div>
                  <div>
                    <p id="play_select">상영 선택</p>
                  </div>
                  <div>
                    <div class="swiper mySwiper">
                      <div class="swiper-wrapper">
                        <button class="swiper-slide date"></button>
                        <button class="swiper-slide date"></button>
                        <button class="swiper-slide date"></button>
                        <button class="swiper-slide date"></button>
                        <button class="swiper-slide date"></button>
                        <button class="swiper-slide date"></button>
                        <button class="swiper-slide date"></button>
                        <button class="swiper-slide date"></button>
                        <button class="swiper-slide date"></button>
                        <button class="swiper-slide date"></button>
                        <button class="swiper-slide date"></button>
                        <button class="swiper-slide date"></button>
                        <button class="swiper-slide date"></button>
                        <button class="swiper-slide date"></button>
                        <button class="swiper-slide date"></button>
                        <button class="swiper-slide date"></button>
                      </div>
                      
                    </div>
                    <div class="swiper-button-prev"></div>
                    <div class="swiper-button-next"></div>
                    
                  </div>
                  
                  <div>
                    <ul id="total_play">
                      <li class="movie_play" data-movie="메이플스토리">
                        <div>메이플스토리</div>
                        <div><ul class="playlist">
                          <li id="origin_play"><a href="#none">
                            <div>
                              <div>
                                <strong>
                                  <span class="open_hour">14</span>&nbsp;:&nbsp;<span class="open_minute">30</span>
                                </strong>
                              </div>
                              <div>
                                <div>
                                  <span class="empty_seat">68</span>&nbsp;/&nbsp;<span class="entire_seat">180</span>
                                </div>
                                <div>
                                  <span class="cinema_room">3</span><span>관</span>
                                </div>
                              </div>
                            </div>
                            <div>
                              종료&nbsp;<span>16</span>&nbsp;:&nbsp;<span>50</span>
                            </div>
                          </a></li>
                        </ul></div>
                      </li>
                      
                    </ul>

                  </div>
              </div>  
          </section>
          <section>
              <div>
                    <div id="movie_thumb"></div>
                    <div id="movie_detail">
                      <div>
                        <div class="age00">All</div>
                        <div><span id="movie_name">원신: 신들의 마지막 전쟁</span></div>
                      </div>
                      <div id="play_date">2023년 05월 20일 토요일</div>
                      <div id="play_time">16시 10분 &#126; 18시 05분</div>
                    </div>
                  </div>
                  <div>
                    <div>강남 1관 일반석</div>
                    <div id="seat_code">
                      <div></div> 
                      <div></div>
                    </div>
                  </div>
                  <div id="price_calc">
                    <div>
                      성인
                      <div>
                        <span id="adult_price"></span>원 &times; <span id="adult_pick"></span>
                      </div>
                    </div>
                    <div>
                      청소년
                      <div>
                        <span id="youth_price"></span>원 &times; <span id="youth_pick"></span>
                      </div>
                    </div> 
                    <div>
                      경로
                      <div>
                        <span id="senior_price"></span>원 &times; <span id="senior_pick"></span>
                      </div>
                    </div>
                    <div>
                      우대
                      <div>
                        <span id="special_price"></span>원 &times; <span id="special_pick"></span>
                      </div> 
                    </div>
                    <div>
                      합계
                      <div style="color: crimson">
                        <span id="total_price" style="color: crimson"></span>원
                      </div>
                    </div>
                  </div>
                  <div><a href="#none">좌석 선택</a></div>
          </section>
        </main>

    </div>
    
    <jsp:include page="/WEB-INF/views/common/footer.jsp" />
    
    

</body>

</html>