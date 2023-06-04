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
                          <ul id="region_list">
                              <li><a href="#none"><span>서울</span></a></li>
                              <li><a href="#none"><span>경기 / 인천</span></a></li>
                              <li><a href="#none"><span>충청 / 대전</span></a></li>
                              <li><a href="#none"><span>경남 / 부산</span></a></li>
                              <li><a href="#none"><span>경북 / 대구</span></a></li>
                              <li><a href="#none"><span>전라 / 광주</span></a></li>
                              <li><a href="#none"><span>강원 / 제주</span></a></li>
                          </ul>
                      </div>
                      <div>
                          <ul class="cinema_list" data-region="서울">
                              <li><a href="#none"><span>강남</span></a></li>
                              <li><a href="#none"><span>건대입구</span></a></li>
                              <li><a href="#none"><span>구로</span></a></li>
                              <li><a href="#none"><span>노원</span></a></li>
                              <li><a href="#none"><span>동대문</span></a></li>
                              <li><a href="#none"><span>명동</span></a></li>
                              <li><a href="#none"><span>상봉</span></a></li>
                              <li><a href="#none"><span>상암</span></a></li>
                              <li><a href="#none"><span>신림</span></a></li>
                              <li><a href="#none"><span>신촌</span></a></li>
                              <li><a href="#none"><span>영등포</span></a></li>
                              <li><a href="#none"><span>왕십리</span></a></li>
                              <li><a href="#none"><span>용산</span></a></li>
                              <li><a href="#none"><span>잠실</span></a></li>
                              <li><a href="#none"><span>종로</span></a></li>
                              <li><a href="#none"><span>청량리</span></a></li>

                          </ul>
                          <ul class="cinema_list" data-region="경기">
                              <li><a href="#none"><span>광명</span></a></li> 
                              <li><a href="#none"><span>구리</span></a></li>   
                              <li><a href="#none"><span>김포</span></a></li>
                              <li><a href="#none"><span>남양주</span></a></li>
                              <li><a href="#none"><span>동탄</span></a></li>
                              <li><a href="#none"><span>부천</span></a></li>
                              <li><a href="#none"><span>성남</span></a></li> 
                              <li><a href="#none"><span>수원</span></a></li>
                              <li><a href="#none"><span>안산</span></a></li>
                              <li><a href="#none"><span>안양</span></a></li>
                              <li><a href="#none"><span>인천(부평)</span></a></li>
                              <li><a href="#none"><span>인천(송도)</span></a></li>
                              <li><a href="#none"><span>인천(주안)</span></a></li>
                              <li><a href="#none"><span>일산</span></a></li>
                              <li><a href="#none"><span>하남</span></a></li>
                          </ul>
                          <ul class="cinema_list" data-region="충청">
                              <li><a href="#none"><span>공주</span></a></li>
                              <li><a href="#none"><span>대전(은행동)</span></a></li>
                              <li><a href="#none"><span>대전(충남대)</span></a></li>
                              <li><a href="#none"><span>세종</span></a></li>  
                              <li><a href="#none"><span>아산</span></a></li>  
                              <li><a href="#none"><span>천안</span></a></li>
                              <li><a href="#none"><span>충주</span></a></li>
                          </ul>
                          <ul class="cinema_list" data-region="경남">
                              <li><a href="#none"><span>김해</span></a></li>
                              <li><a href="#none"><span>마산</span></a></li>
                              <li><a href="#none"><span>부산(부산대)</span></a></li>
                              <li><a href="#none"><span>부산(서면)</span></a></li>
                              <li><a href="#none"><span>부산(센텀시티)</span></a></li>
                              <li><a href="#none"><span>부산(해운대)</span></a></li>
                              <li><a href="#none"><span>울산(울산역)</span></a></li> 
                              <li><a href="#none"><span>울산(태화강)</span></a></li>   
                              <li><a href="#none"><span>진주</span></a></li>  
                              <li><a href="#none"><span>창원</span></a></li>
                          </ul>
                          <ul class="cinema_list" data-region="경북">
                              <li><a href="#none"><span>경주</span></a></li>
                              <li><a href="#none"><span>구미</span></a></li>
                              <li><a href="#none"><span>대구(경북대)</span></a></li>
                              <li><a href="#none"><span>대구(동성로)</span></a></li>
                              <li><a href="#none"><span>안동</span></a></li>
                              <li><a href="#none"><span>영주</span></a></li>
                              <li><a href="#none"><span>포항</span></a></li>
                          </ul>
                          <ul class="cinema_list" data-region="전라">
                              <li><a href="#none"><span>광주(상무)</span></a></li>
                              <li><a href="#none"><span>광주(전남대)</span></a></li>
                              <li><a href="#none"><span>군산</span></a></li>
                              <li><a href="#none"><span>목포</span></a></li>
                              <li><a href="#none"><span>순천</span></a></li>
                              <li><a href="#none"><span>익산</span></a></li>
                              <li><a href="#none"><span>전주</span></a></li>
                          </ul>
                          <ul class="cinema_list" data-region="강원">
                              <li><a href="#none"><span>동해</span></a></li>
                              <li><a href="#none"><span>원주</span></a></li>
                              <li><a href="#none"><span>제주</span></a></li>
                              <li><a href="#none"><span>춘천</span></a></li>
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
                      <li><a href="#none">
                        <div class="age15">15</div>
                        <div><span class="movie_name">던전앤파이터</span></div>
                      </a></li>
                      <li><a href="#none">
                        <div class="age12">12</div>
                        <div><span class="movie_name">마비노기</span></div>
                      </a></li>
                      <li><a href="#none">
                        <div class="age12">12</div>
                        <div><span class="movie_name">메이플스토리</span></div>
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
                        <div class="age19">19</div>
                        <div><span class="movie_name">크레이지 아케이드: 정상인 출입금지 유해불건전 병동방송</span></div>
                      </a></li>
                      <li><a href="#none">
                        <div class="age12">12</div>
                        <div><span class="movie_name">피파온라인4</span></div>
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


          </section>
        </main>

    </div>
    
    <jsp:include page="/WEB-INF/views/common/footer.jsp" />

</body>

</html>