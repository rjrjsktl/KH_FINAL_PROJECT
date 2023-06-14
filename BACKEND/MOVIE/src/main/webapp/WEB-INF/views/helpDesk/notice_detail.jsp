<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

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
							<div>
								<span>[${detail.noticeNo}]&nbsp;${detail.noticeTitle}</span>
							</div>
							<div>
								<span>[${detail.noticeUploader}]<span></span> <span>|</span>
									<span>${detail.noticeRegDate} </span></span>
							</div>
							<div>

						<c:out value="${detail.noticeContent}" escapeXml="false" /> 
							
							</div>

						</div>

						<div class="move-page-wrap">
							<div class="prev-page">
								<p>이전</p>
								<a href="#"></a>
							</div>
							<div class="next-page">
								<p>다음</p>
								<a href="#">[${detail.noticeNo-1}] ${detail.noticeTitle}</a>

							</div>
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
	<script 	src="${contextPath}/resources/js/notice/noticeTest.js"></script>
</body>

</html>