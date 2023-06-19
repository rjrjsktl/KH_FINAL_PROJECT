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

<script src="https://kit.fontawesome.com/dc6e43e0ad.js"
	crossorigin="anonymous"></script>

<!-- jQuery 라이브러리 추가(CDN) -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>

<script src="/ckeditor5/build/ckeditor.js"></script>

<link rel="stylesheet"
	href="${contextPath}/resources/css/common/outline.css">
<link rel="stylesheet"
	href="${contextPath}/resources/css/helpDesk/lost_detail.css">
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

						<h2>분실물 문의</h2>

					

						<div class="notice-contents">
							<div>
								<span>${lostdetail.lostTitle}</span>
							</div>
							<div>
								<span><span>${lostdetail.lostWriter}</span> <span>|</span> <span>${lostdetail.lostDate}
								</span></span>
							</div>
							<div>${lostdetail.lostContent} </div>
						</div>

						<div class="movie-reply">

							<div class="replywritewrap">
								<span>분실물 작성</span>

								<div>
									<form action="" class="replywrite">
										<textarea name="" id="" cols="30" rows="3"></textarea>
										<div class="replyBtn">문의 작성</div>
									</form>
								</div>
							</div>





							<div class="replyList">


								<ul>

									<li class="review" style="display: none;"><span> <img
											src="" alt="이미지">
									</span>
										<div>
											<span>씨*럼</span> <span>2023.05.24</span>
										</div>
										<div>
											이제 다리안아픔 개꿀띠임 역시 현대의학 개좆지리누<br> ㅋㅋㄹㅃㅃ<br>
										</div></li>



								</ul>
							</div>



						</div>

					</div>

					<div>
						<button>목록으로</button>
					</div>
				</div>

			</section>
		</main>

	</div>
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"
		integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
		crossorigin="anonymous"></script>
	<script src="${contextPath}/resources/js/common/replys.js"></script>
</body>

</html>