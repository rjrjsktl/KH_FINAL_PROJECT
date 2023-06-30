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
    <link rel="stylesheet" href="${contextPath}/resources/css/theater/theaterS4.css">
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
                            <li><a href="${contextPath}/theater/theaterS"> KMAX </li>
                                <li><a href="${contextPath}/theater/theaterS2">DOLBY</a></li>
                                <li><a href="${contextPath}/theater/theaterS5">DISH &
                                        WINE</a></li>
                                <li><a href="${contextPath}/theater/theaterS3">WITH A
                                        PUPPY</a></li>
                                <li><a href="${contextPath}/theater/theaterS4">KIDS</a></li>
            </ul>
                     </div>
                 </div>
 
                 <!-- 두번째 영역 -->
                 <div>
                     <div>
                         <div class="left_stheaterwrap">
                             <span>Cultureplex for Kids & Families</span>
                             <span>어린이와 가족 고객을 위한 키즈 전용 씨네마를 경험하세요.
                            </span>
                         </div>
 
 
 
                     </div>
                 </div>
 
 
                 <!-- 4 -->
                 <div>
                     <div>
                         <img src="${contextPath}/resources/images/teater_special/specialtheater_cinekids_0.jpg" alt="">
                  
                     </div>
                 </div>
                 <!-- 5 -->
 
                 <div>
                     <div>
                         <div><img src="${contextPath}/resources/images/teater_special/specialtheater_cinekids_10.jpg">
                             <div class="explain">
                             </div>
                         </div>
                         <div><img src="${contextPath}/resources/images/teater_special/specialtheater_cinekids_11.jpg">
                             <div class="explain">
                             </div>
                         </div>
              
                     </div>
                 </div>
 
 
 
 
                 <!-- 6 -->
                 <div>
                    <div class="left_stheaterwrap">
                        <span style="padding:10px 0;">드라이빙 존
                        </span>
                        <span style="font-size: 1rem;">아이들이 직접 운전해 볼 수 있는 다양한 종류의 어린이 전동차와 드라이빙 트랙이 구비되어 있습니다.<br>CINE KIDS 자동차석 관람 어린이 대상 10분간 드라이빙 체험을 무료로 제공합니다.
                       </span>
                    </div>
                    
                     <div>
                         <img  src="${contextPath}/resources/images/teater_special/specialtheater_cinekids_20.jpg" alt="">
                         <img  src="${contextPath}/resources/images/teater_special/specialtheater_cinekids_21.jpg" alt="">
                     </div>
          
                 </div>
    
 
 
 
 
                 <!-- 7-- -->
                 <div>
                     <div>
                         <p>KIDS 상영관</p>
 
                         <div class="stheater_wrap">
                            <ul>
                                <c:forEach var="screen" items="${screenInfo}">
                                    <li><a href="#">${screen.screenStyle} <span>${screen.cinemaName}</span></a></li>
                                </c:forEach>
                            </ul>
                        </div>
 
                     </div>
                 </div>
                 <!-- 8 -->
                 <div>
                     <div>
                         <!-- TOP3만 올리세요 스와이퍼넣기싫어 귀찮아 제발.. -->
                         <p>아이와 함께하는 추천영화</p>
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