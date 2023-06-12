<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>극장 등록</title>

	<link rel="stylesheet" href="${contextPath}/resources/css/manager/manager_inner_Header.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/manager/reset.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/manager/manager_cinema_add.css">

    <!-- fontawesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
        integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    
    <!-- swiper -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css" />
    
    <!-- jQuery 라이브러리 추가(CDN) -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
        integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</head>

<body class="dark light">
    <main>

        <div class="main_Wrapper">
            <div id="left_Nav_Container">
                <div class="nav_Title">로고영역</div>
                <jsp:include page="/WEB-INF/views/manager/manager_nav.jsp" />
            </div>

            <div class="right_items_Container">
                <jsp:include page="/WEB-INF/views/manager/manager_inner_Header.jsp" />

                <div id="items_Wrapper">
                    <div class="set_Edge">
                        <div class="table_Wrapper">
                            <div class="table_Title">
                                <span>극장 등록</span>
                            </div>
                            <form action="manager_cinema_add/test" method="post">
                                <div class="table_main">
                                    <div>
                                        <span>이름</span>
                                        <div>
                                          <input id="cinemaName" name="cinemaName" type="text">
                                          <p id="cinemaNameMessage">메시지</p>
                                        </div>
                                        
                                    </div>
                                    <div>
                                        <span>주소</span>
                                        <div>
                                            <div>
                                                <input type="text" id="cinemaPostCode" name="cinemaAddr" placeholder="우편번호" maxlength="6" readonly>
                                                <button type="button" onclick="return sample4_execDaumPostcode()">주소검색</button>
                                            </div>
                                            <div>
                                                <input type="text" id="cinemaRoadAddress" name="cinemaAddr" placeholder="도로명주소" readonly>
                                            </div>
                                            <div>
                                                <input type="text" id="cinemaDetailAddress" name="cinemaAddr" placeholder="상세주소" readonly>
                                            </div>
                                        </div> 
                                    </div>
                                    <div>
                                        <span>상영관</span>
                                        <div class="swiper mySwiper">
                                            <div class="swiper-wrapper">
                                                <c:forEach var="i" begin="1" end="4">
                                                <div class="swiper-slide" data-room-no='${i}'>
                                                    <div>
                                                        <div>
                                                            <span>${i}</span>관
                                                            <span class="room_type">일반관</span>
                                                        </div>
                                                        <div>
                                                            <button type="button" class="room_edit"><i class="fa-sharp fa-solid fa-pen-to-square"></i></button>
                                                        </div>
                                                    
                                                    </div>
                                                    <div style="display:none">
                                                        <input type="text" class="status" name="roomStatus">
                                                    </div>
                                                    
                                                </div>
                                                
                                                </c:forEach>
                                                
                                            </div>

                                        </div>
                                    </div>  
                                    <div id="room_area">
                                    	<div><span id="room_no"></span>관 편집창</div>
                                    	<div>
                                    	    <div id="seat_area"></div>
                                    	    <div id="edit_area">
                                    	        <div>
                                    	            타입 : 
                                			        <select id="temp_type">
                                				        <option>일반관</option>
                                				        <option>특수관1</option>
                                				        <option>특수관2</option>
                                				        <option>특수관3</option>
                                				        <option>멍멍이</option>
                                				        <option>키즈존</option>
                                			        </select>
                                    	        </div>
                                			    
                                			    <div>
                                			        가로 : <input id="temp_row" class="temp_rc" type="number" min="1" max="12" value="12" onkeypress="return false;">
                                			    </div>
                                			    <div>
                                			        세로 : <input id="temp_column" class="temp_rc" type="number" min="1" max="25" value="24" onkeypress="return false;">
                                			    </div>
                                			    <div id="seat_option">
                                			        옵션 :
                                			        <select>
                                			            <option selected style="display: none"></option>
                                			            <option>통로 만들기</option>
                                			            <option>통로 없애기</option>
                                			            <option>공간 만들기</option>
                                			            <option>공간 없애기</option>
                                			            <option style="color: magenta;">스위트석 지정</option>
                                			            <option style="color: green;">장애인석 지정</option>
                                			            <option>특수석 없애기</option>
                                			        </select>
                                			    </div>
                                			    <div id="seat_option_confirm">
                                			        <a href='#none'>해당 옵션을 적용하기</a>
                                			    </div>
                                			    
                                			    
                                			 
                                			    <div>
                                		            <button type="button" id="room_confirm">확인</button>
                                		            <button type="button" id="room_reset">리셋</button>
                                		            <button type="button" id="room_cancle">취소</button>
                                		        </div>
                                		        
                                		    </div>
                                		    
                                    	    
                                    	</div>
                                    </div>    
                                </div>
                                
                            <div class="table_bottom">
                                <button type="submit" class="bottom_Submit">저장</button>
                                <button class="bottom_Cancel">취소</button>
                            </div>
                                
                            </form>
                              
                            
                        </div>
                    </div>
                </div>
			</div>
        </div>

    </main>

    <script src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="${contextPath}/resources/js/manager/manager_cinema_add.js"></script>
    <script src="${contextPath}/resources/js/manager/manager_inner_Header.js"></script>
    <script src="${contextPath}/resources/js/manager/manager_nav.js"></script>
 
</body>

</html>