<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

<!-- 최신화 종료 건들일없음 -->

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>마이페이지</title>

<script src="https://kit.fontawesome.com/dc6e43e0ad.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css" />
<script src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"></script>
<script src="https://kit.fontawesome.com/dc6e43e0ad.js"
	crossorigin="anonymous"></script>

<link rel="stylesheet"
	href="${contextPath}/resources/css/common/outline.css">
<link rel="stylesheet"
	href="${contextPath}/resources/css/myPage/myPage_aSide.css">
<link rel="stylesheet"
	href="${contextPath}/resources/css/myPage/myPage_home.css">
<link rel="stylesheet"
	href="${contextPath}/resources/css/myPage/myPage_randomMovie.css">


</head>

<body>
	<div id="wrap">

		<!-- header -->
		<jsp:include page="/WEB-INF/views/common/header.jsp" />

		<main>
			<section>
				<div class="asideAconatiner">

					<!-- aSide -->
					<jsp:include page="/WEB-INF/views/myPage/myPage_aSide.jsp" />

					<div class="container">
						<div>
							<div class="notice-content-wrap">
								<h2>My Page</h2>
								<div class="cont-search-wrap">

									<sapn>${loginUser.userNick}</sapn>
									<span>님 환영합니다.</span>

								</div>
							</div>

							<div class="new-wrap">

								<div>
									<a href="#"><img src="../../images/noticePng/notice01.png"
										alt=""></a> <a href="">
										<p>내가 쓴 리뷰</p>
										<span>내 리뷰를 확인하세요!</span>
									</a>
								</div>


								<div>
									<a href="#"><img src="" alt="내가 본 영화 이미지 찾기"></a> <a
										href="">
										<p>내가 본 영화</p>
										<span>내 영화를 확인하세요!</span>
									</a>

								</div>
								<div>
									<a href="#"><img src="../../images/noticePng/notice05.png"
										alt=""></a> <a href="">
										<p>내 문의 내역</p>
										<span>내 문의를 확인하세요!</span>
									</a>
								</div>
								<div>
									<a href="#"><img src="../../images/noticePng/notice02.png"
										alt=""></a> <a href="">
										<p>내 분실물 문의 내역</p>
										<span>내 물건을 확인하세요!</span>
									</a>

								</div>
								<div>
									<a href="#"><img src="../../images/noticePng/notice04.png"
										alt=""></a> <a href="">
										<p>개인정보 수정</p>
										<span>내 정보를 수정하세요!</span>
									</a>
								</div>
								<div>
									<a href="#"><img src="" alt="비밀번호 수정 이미지 찾기"></a> <a
										href="">
										<p>비밀번호 수정</p>
										<span>내 비밀번호를 수정하세요!</span>
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- event-wrap -->
				<jsp:include page="/WEB-INF/views/myPage/myPage_randomMovie.jsp" />
			</section>
		</main>
	</div>

	<!-- footer -->
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />

	<div id="myModal" class="modal">
		<div class="modal-content">
			<div class="close-button">&times;</div>
			<iframe src="../login/login.html" frameborder="0" width="500px"
				height="500px"></iframe>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"
		integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
		crossorigin="anonymous"></script>
	<script src="${contextPath}/resources/js/common/header.js"></script>
	<script src="${contextPath}/resources/js/myPage/myPage_swiper.js"></script>
	<script src="${contextPath}/resources/js/myPage/myPage_randomMovie.js"></script>
</body>

</html>