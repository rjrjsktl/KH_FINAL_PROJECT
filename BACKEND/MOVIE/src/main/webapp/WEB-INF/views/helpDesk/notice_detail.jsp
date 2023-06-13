<!-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 -->

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지 세부</title>

    <script src="https://kit.fontawesome.com/dc6e43e0ad.js" crossorigin="anonymous"></script>

    <!-- jQuery 라이브러리 추가(CDN) -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
        integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

    <script src="/ckeditor5/build/ckeditor.js"></script>

<link rel="stylesheet"
	href="${contextPath}/resources/css/common/outline.css">
<link rel="stylesheet"
	href="${contextPath}/resources/css/helpDesk/notice_detail.css">
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
                    <div class="content-wrap">

                        <h2>공지사항</h2>

                        <div class="notice-contents">
                            <div> <span>[점포위치]&nbsp;[대분류]&nbsp;내용내용내용내용내용내용내용내용 (날짜 ex 6/5 등)&nbsp;</span></div>
                            <div><span>구분<span> [대분류]&nbsp;</span> <span>|</span>&nbsp 등록일<span> (날짜 ex
                                        2023.05.23)</span></span></div>
                            <div>
                                안녕하세요.<br>
                                메가박스 입니다.<br>

                                6월 8일 GS&POINT 통합로열티 시스템 정기 점검 작업이 진행될 예정입니다.<br>
                                점검 작업이 진행되는 동안 GS&POINT 사용이 어려운 부분에 대해 양해 부탁드리겠습니다.<br>
                                <br>
                                <시스템 점검 시간 및 내용><br>
                                    <br>
                                    1. 작업 일시 : 2023년 6월 8일(목) 02:00 ~ 06:00 (4시간)<br>
                                    <br>
                                    2. 서비스 중단대상<br>
                                    &nbsp;&nbsp;&nbsp;- 통합로열티 시스템<br>
                                    &nbsp;&nbsp;&nbsp;- 로열티 관련 시스템<br>
                                    <br>
                                    3. 작업 내용<br>
                                    &nbsp;&nbsp;&nbsp;- 통합로열티 시스템 정기 점검, 프로그램 추가 반영<br>
                                    &nbsp;&nbsp;&nbsp;- 통합로열티 EAI 정기 점검<br>
                                    <br>
                                    4. 서비스 중단 내역<br>
                                    &nbsp;&nbsp;&nbsp;- GS&POINT 조회 및 사용, 그룹회원가입, 포인트 선물하기 등<br>
                                    &nbsp;&nbsp;&nbsp;(포인트 적립은 적립대행 서비스를 통해서 수행됨)<br>
                                    <br>
                                    이용에 불편을 드린 점 양해부탁드리며,<br>
                                    빠르게 조치하여 정상적인 서비스를 제공 할수 있도록 노력하겠습니다. <br>
                                    <br>
                                    감사합니다.<br>
                            </div>
                        </div>

                        <div class="move-page-wrap">
                            <div class="prev-page"><p>이전</p><a href="#">이전글이 없습니다.</a></div>
                            <div class="next-page"><p>다음</p><a href="#">[지점] [성수] 2023 서울국제환경영화제(2023 SIEFF) 개최 안내</a></div>
                        </div>

                        <div>
                            <button>목록으로</button>
                        </div>

                    </div>

                </div>

            </section>
        </main>

    </div>
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />

	
</body>

</html>