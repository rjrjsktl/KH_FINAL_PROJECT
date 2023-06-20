<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>1 : 1 문의 작성</title>

<script src="https://kit.fontawesome.com/dc6e43e0ad.js"
	crossorigin="anonymous"></script>


<!-- jQuery 라이브러리 추가(CDN) -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>

<link rel="stylesheet"
	href="${contextPath}/resources/css/common/outline.css">
<link rel="stylesheet"
	href="${contextPath}/resources/css/helpDesk/notice_ask_form.css">
<link rel="stylesheet"
	href="${contextPath}/resources/css/common/notice_Aside.css">



<script src="${contextPath}/resources/js/helpDesk/mTm.js"></script>


</head>

<body>
	<div id="wrap">
		<jsp:include page="/WEB-INF/views/common/header.jsp" />

		<main>
			<section>

				<jsp:include page="/WEB-INF/views/common/noticeAside.jsp" />

				<div class="container">
					<div class="content-wrap">

						<h2>1 : 1 문의 작성</h2>

						<div class="notice-contents content_inner">
							<table class="innerTable">
								<tr class="tteesstt">
									<th>제목</th>
									<td><input type="text" id="titleInput"
										placeholder="제목을 입력해 주세요."></td>
								</tr>
								<tr>
									<th>문의종류</th>
									<td><select id="inquirySelect">
											<option disabled selected>문의 내용을 선택해주세요.</option>
											<option value="영화문의">영화 문의</option>
											<option value="이용문의">이용 문의</option>
											<option value="결제문의">결제 문의</option>
											<option value="환불문의">환불 문의</option>
											<option value="나문희">나문희</option>
									</select></td>
								</tr>
								<tr>
									<th>첨부파일</th>
									<td><input type="file" multiple class="align_File"></td>
								</tr>
							</table>
						</div>
						<div id="writeForm">
							<div class="inner_Textarea_Title">내용</div>
							<textarea class="inner_Textarea" id="contentTextarea"></textarea>
						</div>
						<button id="submitButton">Submit</button>

						<div class="btn_Container">
							<button>작성하기</button>
							<button>취소하기</button>
						</div>
						<p id="mtmNo"></p>
						<p id="userNo"></p>

					</div>

				</div>

			</section>
		</main>

	</div>
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />



</body>

</html>