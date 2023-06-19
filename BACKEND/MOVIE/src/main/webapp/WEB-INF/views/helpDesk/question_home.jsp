<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>자주찾는 질문</title>


    <script src="https://kit.fontawesome.com/dc6e43e0ad.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css" />
    <script src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"></script>
    <script src="https://kit.fontawesome.com/dc6e43e0ad.js" crossorigin="anonymous"></script>
         <script src="https://code.jquery.com/jquery-3.6.0.min.js"
                integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

   <link rel="stylesheet"
	href="${contextPath}/resources/css/helpDesk/question_home.css" />
	
<link rel="stylesheet"
	href="${contextPath}/resources/css/common/outline.css">

<link rel="stylesheet"
	href="${contextPath}/resources/css/common/notice_Aside.css">

</head>

<body>
    <div id="wrap">
      <jsp:include page="/WEB-INF/views/common/header.jsp" />

		<main>
			<section>

				<jsp:include page="/WEB-INF/views/common/noticeAside.jsp" />

                <div class="container">
                    <div class="notice-wraaper">
                        <div>
                            <div class="notice-content-wrap">
                                <h2>자주 찾는 질문</h2>
                                <div class="cont-search-wrap">
                                    <span>빠른검색</span>
                                    <form action="">
                                        <input type="text" placeholder=" 질문을 입력해주세요!">
                                        <button>
                                            <img src="../../images/headerPng/glass.png" alt="">
                                        </button>
                                    </form>
                                </div>
                            </div>

                            <div class="btn-wrap">
                                <button>전체</button>
                                <button>영화예매</button>
                                <button>할인혜택</button>
                                <button>결제수단/관람권</button>
                                <button>멤버십</button>
                                <button>VIP</button>
                                <button>극장</button>
                                <button>특별관</button>
                                <button>스토어</button>
                                <button>홈페이지/모바일</button>
                            </div>

                            <div class="list-wrap">
                                <p><span>전체</span><span>250</span>건</p>

                                <ul class="cNumber">

                                    <!-- 1241241242141234124 -->
                                    <li>
                                        <div class="qList">
                                            <p>[영화예매]</p>
                                            <p><span><strong>Q</strong> 질문내용을입력해주세요</span><span><i class="fa-solid fa-chevron-down"></i></span></p>
                                        </div>

                                        <ul class="qList_detail none">
                                            <li>인터넷 예매시에는 예매매수의 전체환불 및 교환만 가능합니다.<br>
                                                인터넷 예매분에 대해 교환환불 및 취소하고자 하실 경우, 예매하신 내역 전체에 대해 취소 후<br>
                                                새로 예매를 하시거나 해당 영화관을 방문하셔서 처리하셔야 합니다. <br>
                                                <br>
                                                1) 인터넷상 취소 가능시간 (상영시간 20분전까지만 가능) <br>
                                                - 전체 취소가능하며, 부분 취소 불가<br>
                                                EX) 인원수, 관람자, 시간변경은 모두 취소 후 재예매 해주셔야합니다.<br>
                                                <br>
                                                2) 현장 취소 가능시간(상영시간 전까지만 가능) <br>
                                                - 전체환불 및 교환가능<br>
                                                단, 부분환불 및 교환은 사용하신 카드로 전체 취소 후 재결제하셔야 합니다.
                                            </li>
                                        </ul>
                                    </li> 
                                    <!-- 1241241242141234124 -->
                                    <!-- 1241241242141234124 -->
                                    <li>
                                        <div class="qList">
                                            <p>[영화예매]</p>
                                            <p><span><strong>Q</strong> 질문내용을입력해주세요</span><span><i class="fa-solid fa-chevron-down"></i></span></p>
                                        </div>

                                        <ul class="qList_detail none">
                                            <li>인터넷 예매시에는 예매매수의 전체환불 및 교환만 가능합니다.<br>
                                                인터넷 예매분에 대해 교환환불 및 취소하고자 하실 경우, 예매하신 내역 전체에 대해 취소 후<br>
                                                새로 예매를 하시거나 해당 영화관을 방문하셔서 처리하셔야 합니다. <br>
                                                <br>
                                                1) 인터넷상 취소 가능시간 (상영시간 20분전까지만 가능) <br>
                                                - 전체 취소가능하며, 부분 취소 불가<br>
                                                EX) 인원수, 관람자, 시간변경은 모두 취소 후 재예매 해주셔야합니다.<br>
                                                <br>
                                                2) 현장 취소 가능시간(상영시간 전까지만 가능) <br>
                                                - 전체환불 및 교환가능<br>
                                                단, 부분환불 및 교환은 사용하신 카드로 전체 취소 후 재결제하셔야 합니다.
                                            </li>
                                        </ul>
                                    </li> 
                                    <!-- 1241241242141234124 -->
                                    <!-- 1241241242141234124 -->
                                    <li>
                                        <div class="qList">
                                            <p>[영화예매]</p>
                                            <p><span><strong>Q</strong> 질문내용을입력해주세요</span><span><i class="fa-solid fa-chevron-down"></i></span></p>
                                        </div>

                                        <ul class="qList_detail none">
                                            <li>인터넷 예매시에는 예매매수의 전체환불 및 교환만 가능합니다.<br>
                                                인터넷 예매분에 대해 교환환불 및 취소하고자 하실 경우, 예매하신 내역 전체에 대해 취소 후<br>
                                                새로 예매를 하시거나 해당 영화관을 방문하셔서 처리하셔야 합니다. <br>
                                                <br>
                                                1) 인터넷상 취소 가능시간 (상영시간 20분전까지만 가능) <br>
                                                - 전체 취소가능하며, 부분 취소 불가<br>
                                                EX) 인원수, 관람자, 시간변경은 모두 취소 후 재예매 해주셔야합니다.<br>
                                                <br>
                                                2) 현장 취소 가능시간(상영시간 전까지만 가능) <br>
                                                - 전체환불 및 교환가능<br>
                                                단, 부분환불 및 교환은 사용하신 카드로 전체 취소 후 재결제하셔야 합니다.
                                            </li>
                                        </ul>
                                    </li> 
                                    <!-- 1241241242141234124 -->
                                    <!-- 1241241242141234124 -->
                                    <li>
                                        <div class="qList">
                                            <p>[영화예매]</p>
                                            <p><span><strong>Q</strong> 질문내용을입력해주세요</span><span><i class="fa-solid fa-chevron-down"></i></span></p>
                                        </div>

                                        <ul class="qList_detail none">
                                            <li>인터넷 예매시에는 예매매수의 전체환불 및 교환만 가능합니다.<br>
                                                인터넷 예매분에 대해 교환환불 및 취소하고자 하실 경우, 예매하신 내역 전체에 대해 취소 후<br>
                                                새로 예매를 하시거나 해당 영화관을 방문하셔서 처리하셔야 합니다. <br>
                                                <br>
                                                1) 인터넷상 취소 가능시간 (상영시간 20분전까지만 가능) <br>
                                                - 전체 취소가능하며, 부분 취소 불가<br>
                                                EX) 인원수, 관람자, 시간변경은 모두 취소 후 재예매 해주셔야합니다.<br>
                                                <br>
                                                2) 현장 취소 가능시간(상영시간 전까지만 가능) <br>
                                                - 전체환불 및 교환가능<br>
                                                단, 부분환불 및 교환은 사용하신 카드로 전체 취소 후 재결제하셔야 합니다.
                                            </li>
                                        </ul>
                                    </li> 
                                    <!-- 1241241242141234124 -->
                                    <!-- 1241241242141234124 -->
                                    <li>
                                        <div class="qList">
                                            <p>[영화예매]</p>
                                            <p><span><strong>Q</strong> 질문내용을입력해주세요</span><span><i class="fa-solid fa-chevron-down"></i></span></p>
                                        </div>

                                        <ul class="qList_detail none">
                                            <li>인터넷 예매시에는 예매매수의 전체환불 및 교환만 가능합니다.<br>
                                                인터넷 예매분에 대해 교환환불 및 취소하고자 하실 경우, 예매하신 내역 전체에 대해 취소 후<br>
                                                새로 예매를 하시거나 해당 영화관을 방문하셔서 처리하셔야 합니다. <br>
                                                <br>
                                                1) 인터넷상 취소 가능시간 (상영시간 20분전까지만 가능) <br>
                                                - 전체 취소가능하며, 부분 취소 불가<br>
                                                EX) 인원수, 관람자, 시간변경은 모두 취소 후 재예매 해주셔야합니다.<br>
                                                <br>
                                                2) 현장 취소 가능시간(상영시간 전까지만 가능) <br>
                                                - 전체환불 및 교환가능<br>
                                                단, 부분환불 및 교환은 사용하신 카드로 전체 취소 후 재결제하셔야 합니다.
                                            </li>
                                        </ul>
                                    </li> 
                                    <!-- 1241241242141234124 -->
                                    <!-- 1241241242141234124 -->
                                    <li>
                                        <div class="qList">
                                            <p>[영화예매]</p>
                                            <p><span><strong>Q</strong> 질문내용을입력해주세요</span><span><i class="fa-solid fa-chevron-down"></i></span></p>
                                        </div>

                                        <ul class="qList_detail none">
                                            <li>인터넷 예매시에는 예매매수의 전체환불 및 교환만 가능합니다.<br>
                                                인터넷 예매분에 대해 교환환불 및 취소하고자 하실 경우, 예매하신 내역 전체에 대해 취소 후<br>
                                                새로 예매를 하시거나 해당 영화관을 방문하셔서 처리하셔야 합니다. <br>
                                                <br>
                                                1) 인터넷상 취소 가능시간 (상영시간 20분전까지만 가능) <br>
                                                - 전체 취소가능하며, 부분 취소 불가<br>
                                                EX) 인원수, 관람자, 시간변경은 모두 취소 후 재예매 해주셔야합니다.<br>
                                                <br>
                                                2) 현장 취소 가능시간(상영시간 전까지만 가능) <br>
                                                - 전체환불 및 교환가능<br>
                                                단, 부분환불 및 교환은 사용하신 카드로 전체 취소 후 재결제하셔야 합니다.
                                            </li>
                                        </ul>
                                    </li> 
                                    <!-- 1241241242141234124 -->

                                </ul>


                                <!-- 10개씩 -->
                                <ul class="pagination">
                                    <li><a href="#">1</a></li>
                                    <li><a href="#">2</a></li>
                                    <li><a href="#">3</a></li>
                                    <li><a href="#">4</a></li>
                                    <li><a href="#">5</a></li>
                                  </ul>
                            </div>

                        </div>



                    </div>
                </div>


            </section>
        </main>

    </div>
 	<jsp:include page="/WEB-INF/views/common/footer.jsp" />

     
   
            <script src="../../js/common/header.js"></script>
    <script src="${contextPath}/resources/js/helpDesk/question_home.js"></script>
</body>

</html>