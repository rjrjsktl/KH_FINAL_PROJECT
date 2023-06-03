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
    <link rel="stylesheet" href="${contextPath}/resources/css/reserve/reserve.css">
    <link rel="stylesheet"	href="${contextPath}/resources/css/common/outline.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css" />  
    <script src="https://kit.fontawesome.com/dc6e43e0ad.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"></script>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <script src="${contextPath}/resources/js/reserve/reserve.js" defer></script>

</head>

<body>
    <div id="wrap">
        <jsp:include page="/WEB-INF/views/common/header.jsp" />

        <!-- 예매 페이지  -->

        <main>
          <section>
              <!-- 예매 절차 영역 -->
              <div>
                  <ul>
                      <!-- 클릭 이벤트 리스너 + 두번재 div를 순서대로 출력 만약 값이 F면 작동x -->
                      <li>
                          <p>01</p>
                          <p>상영시간</p>
                      </li>
                      <li>
                          <p>02</p>
                          <p>인원/좌석</p>
                      </li>
                      <li>
                          <p>03</p>
                          <p>결제</p>
                      </li>
                      <li>
                          <p>04</p>
                          <p>결제완료</p>
                      </li>
                  </ul>
              </div>

              <!-- 현재 예매 절차 -->
              <div>
                  <div>
                      <div>
                        <p id="cinema_select">극장 선택</p>
                      </div>
                      <div>Tab</div>
                      <div>
                          <div>
                              <ul id="region_list">
                                  <li><a href="#none"><P>서울</P></a></li>
                                  <li><a href="#none"><P>경기 / 인천</P></a></li>
                                  <li><a href="#none"><P>충청 / 대전</P></a></li>
                                  <li><a href="#none"><P>경남 / 부산</P></a></li>
                                  <li><a href="#none"><P>경북 / 대구</P></a></li>
                                  <li><a href="#none"><P>전라 / 광주</P></a></li>
                                  <li><a href="#none"><P>강원 / 제주</P></a></li>
                              </ul>
                          </div>
                          <div>
                              <ul class="cinema_list" data-region="서울">
                                  <li><a href="#none"><P>강남</P></a></li>
                                  <li><a href="#none"><P>건대입구</P></a></li>
                                  <li><a href="#none"><P>구로</P></a></li>
                                  <li><a href="#none"><P>노원</P></a></li>
                                  <li><a href="#none"><P>동대문</P></a></li>
                                  <li><a href="#none"><P>명동</P></a></li>
                                  <li><a href="#none"><P>상봉</P></a></li>
                                  <li><a href="#none"><P>상암</P></a></li>
                                  <li><a href="#none"><P>신림</P></a></li>
                                  <li><a href="#none"><P>신촌</P></a></li>
                                  <li><a href="#none"><P>영등포</P></a></li>
                                  <li><a href="#none"><P>왕십리</P></a></li>
                                  <li><a href="#none"><P>용산</P></a></li>
                                  <li><a href="#none"><P>잠실</P></a></li>
                                  <li><a href="#none"><P>종로</P></a></li>
                                  <li><a href="#none"><P>청량리</P></a></li>

                              </ul>
                              <ul class="cinema_list" data-region="경기"> 
                                  <li><a href="#none"><P>구리</P></a></li>   
                                  <li><a href="#none"><P>김포</P></a></li>
                                  <li><a href="#none"><P>남양주</P></a></li>
                                  <li><a href="#none"><P>동탄</P></a></li>
                                  <li><a href="#none"><P>부천</P></a></li>
                                  <li><a href="#none"><P>성남</P></a></li> 
                                  <li><a href="#none"><P>수원</P></a></li>
                                  <li><a href="#none"><P>안산</P></a></li>
                                  <li><a href="#none"><P>안양</P></a></li>
                                  <li><a href="#none"><P>인천(부평)</P></a></li>
                                  <li><a href="#none"><P>인천(송도)</P></a></li>
                                  <li><a href="#none"><P>인천(주안)</P></a></li>
                                  <li><a href="#none"><P>일산</P></a></li>
                                  <li><a href="#none"><P>하남</P></a></li>
                              </ul>
                              <ul class="cinema_list" data-region="충청">
                                  <li><a href="#none"><P>공주</P></a></li>
                                  <li><a href="#none"><P>대전(은행동)</P></a></li>
                                  <li><a href="#none"><P>대전(충남대)</P></a></li>
                                  <li><a href="#none"><P>세종</P></a></li>  
                                  <li><a href="#none"><P>아산</P></a></li>  
                                  <li><a href="#none"><P>천안</P></a></li>
                                  <li><a href="#none"><P>충주</P></a></li>
                              </ul>
                              <ul class="cinema_list" data-region="경남">
                                  <li><a href="#none"><P>김해</P></a></li>
                                  <li><a href="#none"><P>마산</P></a></li>
                                  <li><a href="#none"><P>부산(부산대)</P></a></li>
                                  <li><a href="#none"><P>부산(서면)</P></a></li>
                                  <li><a href="#none"><P>부산(센텀시티)</P></a></li>
                                  <li><a href="#none"><P>부산(해운대)</P></a></li>
                                  <li><a href="#none"><P>울산(울산역)</P></a></li> 
                                  <li><a href="#none"><P>울산(태화강)</P></a></li>   
                                  <li><a href="#none"><P>진주</P></a></li>  
                                  <li><a href="#none"><P>창원</P></a></li>
                              </ul>
                              <ul class="cinema_list" data-region="경북">
                                  <li><a href="#none"><P>경주</P></a></li>
                                  <li><a href="#none"><P>구미</P></a></li>
                                  <li><a href="#none"><P>대구(경북대)</P></a></li>
                                  <li><a href="#none"><P>대구(동성로)</P></a></li>
                                  <li><a href="#none"><P>안동</P></a></li>
                                  <li><a href="#none"><P>영주</P></a></li>
                                  <li><a href="#none"><P>포항</P></a></li>
                              </ul>
                              <ul class="cinema_list" data-region="전라">
                                  <li><a href="#none"><P>광주(상무)</P></a></li>
                                  <li><a href="#none"><P>광주(전남대)</P></a></li>
                                  <li><a href="#none"><P>군산</P></a></li>
                                  <li><a href="#none"><P>목포</P></a></li>
                                  <li><a href="#none"><P>순천</P></a></li>
                                  <li><a href="#none"><P>익산</P></a></li>
                                  <li><a href="#none"><P>전주</P></a></li>
                              </ul>
                              <ul class="cinema_list" data-region="강원">
                                  <li><a href="#none"><P>동해</P></a></li>
                                  <li><a href="#none"><P>원주</P></a></li>
                                  <li><a href="#none"><P>제주</P></a></li>
                                  <li><a href="#none"><P>춘천</P></a></li>
                              </ul>
                          </div>
                      </div>
                  </div>
                  <div>
                      <div>
                        <p id="movie_select">영화 선택</p>
                      </div>
                      <div>
                        <div><a href="#none" id="movie_option1">버전 1</a></div>
                        <div><a href="#none" id="movie_option2">버전 2</a></div>
                      </div>
                      <div>
                        <ul class="movielist" id="movielist_text">
                          <li><a href="#none">
                            <div class="age12">12</div>
                            <div><span class="movie_name">메이플스토리</span></div>
                          </a></li>
                          <li><a href="#none">
                            <div class="age15">15</div>
                            <div><span class="movie_name">던전앤파이터</span></div>
                          </a></li>
                          <li><a href="#none">
                            <div class="age19">19</div>
                            <div><span class="movie_name">크레이지 아케이드: 정상인 출입금지 유해불건전 병동방송</span></div>
                          </a></li>
                          <li><a href="#none">
                            <div class="age12">12</div>
                            <div><span class="movie_name">피파온라인4</span></div>
                          </a></li>
                          <li><a href="#none">
                            <div class="age00">All</div>
                            <div><span class="movie_name">원신</span></div>
                          </a></li>
                          <li><a href="#none">
                            <div class="age19">19</div>
                            <div><span class="movie_name">카트라이더: 킬러조의 습격</span></div>
                          </a></li>
                          <li><a href="#none">
                            <div class="age12">12</div>
                            <div><span class="movie_name">마비노기</span></div>
                          </a></li>
                        </ul>
                        <ul class="movielist" id="movielist_thumb">
                          <li><a href="#none">
                            <div><span>1</span></div>
                            <div>
                              <div>
                                <div class="age12">12</div>
                                <div><span class="movie_name">메이플스토리</span></div>
                              </div>
                              <div>
                                <div>
                                  <div>예매율 : <strong><span>30.2</span>%</strong></div>
                                  <div><i class="fa solid fa-star"></i><strong><span>9.5</span></strong></div>
                                </div>
                                <div>
                                  개봉일 : <span>2023.05.22</span>
                                </div>
                              </div>
                            </div>
                          </a></li>
                          <li><a href="#none">
                            <div><span>2</span></div>
                            <div>
                              <div>
                                <div class="age15">15</div>
                                <div><span class="movie_name">던전앤파이터</span></div>
                              </div>
                              <div>
                                <div>
                                  <div>예매율 : <strong><span>23.8</span>%</strong></div>
                                  <div><i class="fa solid fa-star"></i><strong><span>9.1</span></strong></div>
                                </div>
                                <div>
                                  개봉일 : <span>2023.05.17</span>
                                </div>
                              </div>
                            </div>
                          </a></li>
                          <li><a href="#none">
                            <div><span>3</span></div>
                            <div>
                              <div>
                                <div class="age19">19</div>
                                <div><span class="movie_name">크레이지 아케이드: 정상인 출입금지 유해불건전 병동방송</span></div>
                              </div>
                              <div>
                                <div>
                                  <div>예매율 : <strong><span>17.2</span>%</strong></div>
                                  <div><i class="fa solid fa-star"></i><strong><span>8.8</span></strong></div>
                                </div>
                                <div>
                                  개봉일 : <span>2023.05.19</span>
                                </div>
                              </div>
                            </div>
                          </a></li>
                          <li><a href="#none">
                            <div><span>4</span></div>
                            <div>
                              <div>
                                <div class="age12">12</div>
                                <div><span class="movie_name">피파온라인4</span></div>
                              </div>
                              <div>
                                <div>
                                  <div>예매율 : <strong><span>11.8</span>%</strong></div>
                                  <div><i class="fa solid fa-star"></i><strong><span>9.0</span></strong></div>
                                </div>
                                <div>
                                  개봉일 : <span>2023.05.10</span>
                                </div>
                              </div>
                            </div>
                          </a></li>
                          <li><a href="#none">
                            <div><span>5</span></div>
                            <div>
                              <div>
                                <div class="age00">All</div>
                                <div><span class="movie_name">원신</span></div>
                              </div>
                              <div>
                                <div>
                                  <div>예매율 : <strong><span>7.7</span>%</strong></div>
                                  <div><i class="fa solid fa-star"></i><strong><span>9.9</span></strong></div>
                                </div>
                                <div>
                                  개봉일 : <span>2023.05.01</span>
                                </div>
                              </div>
                            </div>
                          </a></li>
                          <li><a href="#none">
                            <div><span>6</span></div>
                            <div>
                              <div>
                                <div class="age19">19</div>
                                <div><span class="movie_name">카트라이더: 킬러조의 습격</span></div>
                              </div>
                              <div>
                                <div>
                                  <div>예매율 : <strong><span>4.4</span>%</strong></div>
                                  <div><i class="fa solid fa-star"></i><strong><span>8.5</span></strong></div>
                                </div>
                                <div>
                                  개봉일 : <span>2023.05.20</span>
                                </div>
                              </div>
                            </div>
                          </a></li>
                          <li><a href="#none">
                            <div><span>7</span></div>
                            <div>
                              <div>
                                <div class="age12">12</div>
                                <div><span class="movie_name">마비노기</span></div>
                              </div>
                              <div>
                                <div>
                                  <div>예매율 : <strong><span>2.9</span>%</strong></div>
                                  <div><i class="fa solid fa-star"></i><strong><span>8.9</span></strong></div>
                                </div>
                                <div>
                                  개봉일 : <span>2023.05.19</span>
                                </div>
                              </div>
                            </div>
                          </a></li>
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
              </div>


          </section>
        </main>

    </div>
    
    <jsp:include page="/WEB-INF/views/common/footer.jsp" />

	<script src="${contextPath}/resources/js/main/main.js"></script>
</body>

</html>