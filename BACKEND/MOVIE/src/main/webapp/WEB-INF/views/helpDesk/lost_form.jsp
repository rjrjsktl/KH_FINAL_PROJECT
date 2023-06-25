<!-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 -->

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>분실물 문의 작성</title>

<script src="https://kit.fontawesome.com/dc6e43e0ad.js"
	crossorigin="anonymous"></script>


<!-- jQuery 라이브러리 추가(CDN) -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>


<link rel="stylesheet"
	href="${contextPath}/resources/css/common/outline.css">
<link rel="stylesheet"
	href="${contextPath}/resources/css/helpDesk/lost_form.css">
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

						<h2>분실물 신고</h2>

						<div class="notice-contents content_inner">
							<table class="innerTable">
								<tr>
									<th>제목</th>
									<td><input id="titleInput" type="text"
										placeholder=" 제목을 입력해 주세요."></td>
								</tr>
								<tr>
									<th>물품</th>
									<td><input id="lostItem" type="text"
										placeholder=" 잃어버린 물품에 대해 입력해 주세요."></td>
								</tr>
								<tr>
									<th>위치</th>
									<td><input id="lostArea" type="text"
										placeholder=" 상세한 위치를 입력해 주세요."></td>
								</tr>
								<tr>
									<th>날짜</th>
									<td><input id="lostDate" type="date"
										placeholder=" 잃어버린 날짜를 입력해 주세요." class="dateBtn"
										onfocus="this.showPicker()"></td>
								</tr>
								<tr>
									<th>첨부파일</th>
									<td><input id="lostFile" type="file" multiple
										class="align_File"></td>
								</tr>
							
							</table>
						</div>

						<div id="writeForm">
							<div class="inner_Textarea_Title">상세 내용</div>
							<textarea id="contentTextarea" class="inner_Textarea"
								placeholder="잃어버리신 물건의 이름, 크기, 색상 등을 자세하게 설명해 주세요."></textarea>
						</div>

						<div class="btn_Container">
							<button id="registLost">작성하기</button>
							<button>취소하기</button>
						</div>

					</div>

				</div>

			</section>
		</main>

	</div>
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />



	<script src="${contextPath}/resources/js/helpDesk/lost_form.js"></script>
</body>

</html>