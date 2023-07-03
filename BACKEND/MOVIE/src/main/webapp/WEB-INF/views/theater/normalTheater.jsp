 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>예매선택 페이지</title>
<link rel="stylesheet"
	href="${contextPath}/resources/css/common/outline.css">
<link rel="stylesheet"
	href="${contextPath}/resources/css/theater/theater.css">
<script src="https://kit.fontawesome.com/dc6e43e0ad.js"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
		integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
		crossorigin="anonymous"></script>
</head>

<body>
	<div id="wrap">
		<jsp:include page="/WEB-INF/views/common/header.jsp" />

		<main>


			<section>
				<div class="theater-wrap">
					<h2>전체극장</h2>
					<div class="cont-wrap">
						<div class="list_wrap">



							
							<ul class="area-wrap">
								<c:forEach var="cinemaList" items="${cinemaList.cinemaList}">									
								<li><span class="location" name="area">${cinemaList.cinemaArea}</span>
									<div class="list-detail none"></div>
								</li>
							</c:forEach>

								<!-- <li class="area-name"><span class="location" name="area">제주</span>
									<div class="list-detail none">
										<ul>
											<li><a href=""> </a></li>
										</ul>
									</div></li> -->

							</ul>
						</div>
						<!-- cont -->

					</div>
				</div>
			</section>

			<div class="event-wrap">
				<div class="event-wrap-title">
					<span>극장 이벤트</span><a href="">더보기></a>
				</div>
				<div>
					<div>
						<a href=""><img src="" alt=""></a>
					</div>
					<div>
						<a href=""><img src="" alt=""></a>
					</div>
				</div>
			</div>

			<div class="table-wrap">
				<span>극장 공지사항</span>

				<table>
					<thead>
						<th>번호</th>
						<th>내용</th>
						<th>등록일</th>
					</thead>
					<tbody>

						<c:choose>
							<c:when test="${empty getNoticeList.noticeLists}">
								<tr>
									<th colspan="3">게시글이 존재하지 않습니다.</th>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach var="getNotice" items="${getNoticeList['noticeLists']}" varStatus="loop">
									<c:if test="${loop.index < 5}">
										<tr class="row">
											<td>${getNotice.noticeNo}</td>
											<td>${getNotice.noticeTitle}</td>
											<td>${getNotice.noticeRegDate}</td>
											<td>${getNotice.noticeView}</td>
										</tr>
									</c:if>
								</c:forEach>
							</c:otherwise>
						</c:choose>
						
						
					</tbody>
				</table>

			</div>



		</main>

	</div>

	<jsp:include page="/WEB-INF/views/common/footer.jsp" />

	
	<script src="${contextPath}/resources/js/theater/theater.js"></script>
</body>

</html>