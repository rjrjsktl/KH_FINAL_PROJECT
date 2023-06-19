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
                              <li><a href="#none">대전 충청</a></li>
                              <li><a href="#none">광주 전라</a></li>
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
                    <div><a href="#none" id="movie_option2">예매율 순</a></div>
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
                               <div class="age19">19</div>
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
                                  <div class="age19">19</div>
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
                    <ul>
                      <li class="movie_play" data-movie="메이플스토리">
                        <div>메이플스토리</div>
                        <div><ul class="playlist">
                          <li><a href="#none">
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
                          <li><a href="#none">
                            <div>
                              <div>
                                <strong>
                                  <span class="open_hour">15</span>&nbsp;:&nbsp;<span class="open_minute">00</span>
                                </strong>
                              </div>
                              <div>
                                <div>
                                  <span class="empty_seat">81</span>&nbsp;/&nbsp;<span class="entire_seat">200</span>
                                </div>
                                <div>
                                  <span class="cinema_room">4</span><span>관</span>
                                </div>
                              </div>
                            </div>
                            <div>
                              종료&nbsp;<span>17</span>&nbsp;:&nbsp;<span>20</span>
                            </div>
                          </a></li>
                          <li><a href="#none">
                            <div>
                              <div>
                                <strong>
                                  <span class="open_hour">17</span>&nbsp;:&nbsp;<span class="open_minute">00</span>
                                </strong>
                              </div>
                              <div>
                                <div>
                                  <span class="empty_seat">102</span>&nbsp;/&nbsp;<span class="entire_seat">180</span>
                                </div>
                                <div>
                                  <span class="cinema_room">3</span><span>관</span>
                                </div>
                              </div>
                            </div>
                            <div>
                              종료&nbsp;<span>19</span>&nbsp;:&nbsp;<span>20</span>
                            </div>
                          </a></li>
                          <li><a href="#none">
                            <div>
                              <div>
                                <strong>
                                  <span class="open_hour">17</span>&nbsp;:&nbsp;<span class="open_minute">30</span>
                                </strong>
                              </div>
                              <div>
                                <div>
                                  <span class="empty_seat">123</span>&nbsp;/&nbsp;<span class="entire_seat">200</span>
                                </div>
                                <div>
                                  <span class="cinema_room">4</span><span>관</span>
                                </div>
                              </div>
                            </div>
                            <div>
                              종료&nbsp;<span>19</span>&nbsp;:&nbsp;<span>50</span>
                            </div>
                          </a></li>
                          <li><a href="#none">
                            <div>
                              <div>
                                <strong>
                                  <span class="open_hour">19</span>&nbsp;:&nbsp;<span class="open_minute">30</span>
                                </strong>
                              </div>
                              <div>
                                <div>
                                  <span class="empty_seat">129</span>&nbsp;/&nbsp;<span class="entire_seat">180</span>
                                </div>
                                <div>
                                  <span class="cinema_room">3</span><span>관</span>
                                </div>
                              </div>
                            </div>
                            <div>
                              종료&nbsp;<span>21</span>&nbsp;:&nbsp;<span>50</span>
                            </div>
                          </a></li>
                          <li><a href="#none">
                            <div>
                              <div>
                                <strong>
                                  <span class="open_hour">20</span>&nbsp;:&nbsp;<span class="open_minute">00</span>
                                </strong>
                              </div>
                              <div>
                                <div>
                                  <span class="empty_seat">169</span>&nbsp;/&nbsp;<span class="entire_seat">200</span>
                                </div>
                                <div>
                                  <span class="cinema_room">4</span><span>관</span>
                                </div>
                              </div>
                            </div>
                            <div>
                              종료&nbsp;<span>22</span>&nbsp;:&nbsp;<span>20</span>
                            </div>
                          </a></li>
                          <li><a href="#none">
                            <div>
                              <div>
                                <strong>
                                  <span class="open_hour">22</span>&nbsp;:&nbsp;<span class="open_minute">00</span>
                                </strong>
                              </div>
                              <div>
                                <div>
                                  <span class="empty_seat">72</span>&nbsp;/&nbsp;<span class="entire_seat">180</span>
                                </div>
                                <div>
                                  <span class="cinema_room">3</span><span>관</span>
                                </div>
                              </div>
                            </div>
                            <div>
                              종료&nbsp;<span>24</span>&nbsp;:&nbsp;<span>20</span>
                            </div>
                          </a></li>
                        </ul></div>
                      </li>
                      <li class="movie_play" data-movie="던전앤파이터"> 
                        <div>던전앤파이터</div>
                        <div><ul class="playlist">
                          <li><a href="#none">
                            <div>
                              <div>
                                <strong>
                                  <span class="open_hour">15</span>&nbsp;:&nbsp;<span class="open_minute">20</span>
                                </strong>
                              </div>
                              <div>
                                <div>
                                  <span class="empty_seat">88</span>&nbsp;/&nbsp;<span class="entire_seat">190</span>
                                </div>
                                <div>
                                  <span class="cinema_room">2</span><span>관</span>
                                </div>
                              </div>
                            </div>
                            <div>
                              종료&nbsp;<span>17</span>&nbsp;:&nbsp;<span>30</span>
                            </div>
                          </a></li>
                          <li><a href="#none">
                            <div>
                              <div>
                                <strong>
                                  <span class="open_hour">17</span>&nbsp;:&nbsp;<span class="open_minute">40</span>
                                </strong>
                              </div>
                              <div>
                                <div>
                                  <span class="empty_seat">134</span>&nbsp;/&nbsp;<span class="entire_seat">190</span>
                                </div>
                                <div>
                                  <span class="cinema_room">2</span><span>관</span>
                                </div>
                              </div>
                            </div>
                            <div>
                              종료&nbsp;<span>19</span>&nbsp;:&nbsp;<span>50</span>
                            </div>
                          </a></li>
                          <li><a href="#none">
                            <div>
                              <div>
                                <strong>
                                  <span class="open_hour">20</span>&nbsp;:&nbsp;<span class="open_minute">05</span>
                                </strong>
                              </div>
                              <div>
                                <div>
                                  <span class="empty_seat">100</span>&nbsp;/&nbsp;<span class="entire_seat">190</span>
                                </div>
                                <div>
                                  <span class="cinema_room">2</span><span>관</span>
                                </div>
                              </div>
                            </div>
                            <div>
                              종료&nbsp;<span>22</span>&nbsp;:&nbsp;<span>15</span>
                            </div>
                          </a></li>
                        </ul></div>
                      </li>
                      <li class="movie_play" data-movie="크레이지 아케이드: 정상인 출입금지 유해불건전 병동방송"> 
                        <div>크레이지 아케이드: 정상인 출입금지 유해불건전 병동방송</div>
                        <div><ul class="playlist">
                          <li><a href="#none">
                            <div>
                              <div>
                                <strong>
                                  <span class="open_hour">14</span>&nbsp;:&nbsp;<span class="open_minute">45</span>
                                </strong>
                              </div>
                              <div>
                                <div>
                                  <span class="empty_seat">113</span>&nbsp;/&nbsp;<span class="entire_seat">175</span>
                                </div>
                                <div>
                                  <span class="cinema_room">5</span><span>관</span>
                                </div>
                              </div>
                            </div>
                            <div>
                              종료&nbsp;<span>17</span>&nbsp;:&nbsp;<span>00</span>
                            </div>
                          </a></li>
                          <li><a href="#none">
                            <div>
                              <div>
                                <strong>
                                  <span class="open_hour">17</span>&nbsp;:&nbsp;<span class="open_minute">15</span>
                                </strong>
                              </div>
                              <div>
                                <div>
                                  <span class="empty_seat">123</span>&nbsp;/&nbsp;<span class="entire_seat">175</span>
                                </div>
                                <div>
                                  <span class="cinema_room">5</span><span>관</span>
                                </div>
                              </div>
                            </div>
                            <div>
                              종료&nbsp;<span>19</span>&nbsp;:&nbsp;<span>30</span>
                            </div>
                          </a></li>
                          <li><a href="#none">
                            <div>
                              <div>
                                <strong>
                                  <span class="open_hour">19</span>&nbsp;:&nbsp;<span class="open_minute">45</span>
                                </strong>
                              </div>
                              <div>
                                <div>
                                  <span class="empty_seat">100</span>&nbsp;/&nbsp;<span class="entire_seat">175</span>
                                </div>
                                <div>
                                  <span class="cinema_room">5</span><span>관</span>
                                </div>
                              </div>
                            </div>
                            <div>
                              종료&nbsp;<span>22</span>&nbsp;:&nbsp;<span>00</span>
                            </div>
                          </a></li>
                          <li><a href="#none">
                            <div>
                              <div>
                                <strong>
                                  <span class="open_hour">22</span>&nbsp;:&nbsp;<span class="open_minute">15</span>
                                </strong>
                              </div>
                              <div>
                                <div>
                                  <span class="empty_seat">70</span>&nbsp;/&nbsp;<span class="entire_seat">175</span>
                                </div>
                                <div>
                                  <span class="cinema_room">5</span><span>관</span>
                                </div>
                              </div>
                            </div>
                            <div>
                              종료&nbsp;<span>24</span>&nbsp;:&nbsp;<span>30</span>
                            </div>
                          </a></li>
                        </ul></div>
                      </li>
                      <li class="movie_play" data-movie="원신">
                        <div>원신</div>
                        <div><ul class="playlist">
                          <li><a href="#none">
                            <div>
                              <div>
                                <strong>
                                  <span class="open_hour">14</span>&nbsp;:&nbsp;<span class="open_minute">00</span>
                                </strong>
                              </div>
                              <div>
                                <div>
                                  <span class="empty_seat">143</span>&nbsp;/&nbsp;<span class="entire_seat">200</span>
                                </div>
                                <div>
                                  <span class="cinema_room">1</span><span>관</span>
                                </div>
                              </div>
                            </div>
                            <div>
                              종료&nbsp;<span>15</span>&nbsp;:&nbsp;<span>55</span>
                            </div>
                          </a></li>
                          <li><a href="#none">
                            <div>
                              <div>
                                <strong>
                                  <span class="open_hour">16</span>&nbsp;:&nbsp;<span class="open_minute">10</span>
                                </strong>
                              </div>
                              <div>
                                <div>
                                  <span class="empty_seat">151</span>&nbsp;/&nbsp;<span class="entire_seat">200</span>
                                </div>
                                <div>
                                  <span class="cinema_room">1</span><span>관</span>
                                </div>
                              </div>
                            </div>
                            <div>
                              종료&nbsp;<span>18</span>&nbsp;:&nbsp;<span>05</span>
                            </div>
                          </a></li>
                          <li><a href="#none">
                            <div>
                              <div>
                                <strong>
                                  <span class="open_hour">18</span>&nbsp;:&nbsp;<span class="open_minute">20</span>
                                </strong>
                              </div>
                              <div>
                                <div>
                                  <span class="empty_seat">118</span>&nbsp;/&nbsp;<span class="entire_seat">200</span>
                                </div>
                                <div>
                                  <span class="cinema_room">1</span><span>관</span>
                                </div>
                              </div>
                            </div>
                            <div>
                              종료&nbsp;<span>20</span>&nbsp;:&nbsp;<span>15</span>
                            </div>
                          </a></li>
                          <li><a href="#none">
                            <div>
                              <div>
                                <strong>
                                  <span class="open_hour">20</span>&nbsp;:&nbsp;<span class="open_minute">30</span>
                                </strong>
                              </div>
                              <div>
                                <div>
                                  <span class="empty_seat">99</span>&nbsp;/&nbsp;<span class="entire_seat">200</span>
                                </div>
                                <div>
                                  <span class="cinema_room">1</span><span>관</span>
                                </div>
                              </div>
                            </div>
                            <div>
                              종료&nbsp;<span>22</span>&nbsp;:&nbsp;<span>25</span>
                            </div>
                          </a></li>
                          <li><a href="#none">
                            <div>
                              <div>
                                <strong>
                                  <span class="open_hour">22</span>&nbsp;:&nbsp;<span class="open_minute">40</span>
                                </strong>
                              </div>
                              <div>
                                <div>
                                  <span class="empty_seat">170</span>&nbsp;/&nbsp;<span class="entire_seat">200</span>
                                </div>
                                <div>
                                  <span class="cinema_room">1</span><span>관</span>
                                </div>
                              </div>
                            </div>
                            <div>
                              종료&nbsp;<span>24</span>&nbsp;:&nbsp;<span>35</span>
                            </div>
                          </a></li>
                        </ul></div>
                      </li>
                      <li class="movie_play" data-movie="카트라이더: 킬러조의 습격"> 
                        <div>카트라이더: 킬러조의 습격</div>
                        <div><ul class="playlist">
                          <li><a href="#none">
                            <div>
                              <div>
                                <strong>
                                  <span class="open_hour">23</span>&nbsp;:&nbsp;<span class="open_minute">00</span>
                                </strong>
                              </div>
                              <div>
                                <div>
                                  <span class="empty_seat">166</span>&nbsp;/&nbsp;<span class="entire_seat">190</span>
                                </div>
                                <div>
                                  <span class="cinema_room">2</span><span>관</span>
                                </div>
                              </div>
                            </div>
                            <div>
                              종료&nbsp;<span>25</span>&nbsp;:&nbsp;<span>30</span>
                            </div>
                          </a></li>
                          <li><a href="#none">
                            <div>
                              <div>
                                <strong>
                                  <span class="open_hour">23</span>&nbsp;:&nbsp;<span class="open_minute">15</span>
                                </strong>
                              </div>
                              <div>
                                <div>
                                  <span class="empty_seat">170</span>&nbsp;/&nbsp;<span class="entire_seat">200</span>
                                </div>
                                <div>
                                  <span class="cinema_room">4</span><span>관</span>
                                </div>
                              </div>
                            </div>
                            <div>
                              종료&nbsp;<span>25</span>&nbsp;:&nbsp;<span>45</span>
                            </div>
                          </a></li>
                        </ul></div>
                      </li>
                    </ul>

                  </div>
              </div>  


          </section>
        </main>

    </div>
    
    <jsp:include page="/WEB-INF/views/common/footer.jsp" />
    
    

</body>

</html>