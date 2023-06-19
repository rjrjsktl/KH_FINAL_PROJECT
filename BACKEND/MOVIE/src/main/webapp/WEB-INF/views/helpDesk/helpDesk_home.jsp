<!-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

 -->

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>예매선택 페이지</title>


<script src="https://kit.fontawesome.com/dc6e43e0ad.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css" />
<script src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"></script>


<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>

<link rel="stylesheet"
	href="${contextPath}/resources/css/helpDesk/helpDeskHome.css" />

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
								<h2>고객센터</h2>
								<div class="cont-search-wrap">
									<span>빠른검색</span>
									<form action="">
										<input type="text" placeholder=" 질문을 입력해주세요!">
										<button>
											<img src="${contextPath}/resources/images/headerPng/glass.png" alt="">
										</button>
									</form>
								</div>
							</div>

							<div class="new-wrap">

								<div>
									<a href="${contextPath}/helpDesk/notice_List"><img
										src="${contextPath}/resources/images/helpDesk/notice01.png"
										alt=""> <a href="${contextPath}/helpDesk/notice_List"><p>공지사항</p>
										<span>공지사항을 확인해보세요</span></a>
								</div>


								<div>
									<a href="${contextPath}/helpDesk/lost_List"><img
										src="${contextPath}/resources/images/helpDesk/notice02.png"
										alt=""></a> <a href="${contextPath}/helpDesk/lost_List"><p>분실물 문의</p> <span>질질
											흘리고다니기나하고.. 으휴</span></a>

								</div>
								<div>
									<a href="#"><img
										src="${contextPath}/resources/images/helpDesk/notice03.png"
										alt=""></a> <a href=""><p>단체 / 대관 문의</p> <span>돈도많으시네요</span></a>
								</div>
								<div>
									<a href="#"><img
										src="${contextPath}/resources/images/helpDesk/notice04.png"
										alt=""></a> <a href=""><p>자주 찾는 나문희</p> <span>머리가
											나쁜가..</span></a>

								</div>
								<div>
									<a href="#"><img src="${contextPath}/resources/images/helpDesk/notice05.png"
										alt=""></a> <a href=""><p>내 상담 내역</p> <span>적당히들
											하시오 적당히들</span></a>
								</div>
								<div>
									<a href="${contextPath}/helpDesk/mTm_List"><img src="${contextPath}/resources/images/helpDesk/notice06.png"
										alt=""></a>	<a href="${contextPath}/helpDesk/mTm_List"><p>1:1
											나문희</p> <span>맞짱뜨실?</span></a>
								</div>
							</div>

							<div class="table-wrap">
								<div class="question_tbl_wrap">
									<p>
										<span>자주 처 물어보는 질문 BEST5</span> <a href="#"><span>더보기
												&gt</span></a>
									</p>

									<table class="question_tbl">
										<tbody>
											<tr class="row">
												<td>[영화예매]</td>
												<th><a href="#">내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용</a></th>
												<td>2023.05.26</td>
											</tr>
											<tr class="row">
												<td>[극장]</td>
												<th><a href="#">내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용</a></th>
												<td>2023.05.26</td>
											</tr>
											<tr class="row">
												<td>[홈페이지/모바일]</td>
												<th><a href="#">내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용</a></th>
												<td>2023.05.26</td>
											</tr>
											<tr class="row">
												<td>[VIP]</td>
												<th><a href="#">내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용</a></th>
												<td>2023.05.26</td>
											</tr>
											<tr class="row">
												<td>[영화예매]</td>
												<th><a href="#">내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용</a></th>
												<td>2023.05.26</td>
											</tr>

										</tbody>
									</table>






								</div>

								<div class="notice_tbl_wrap">
									<p>
										<span>공지사항</span> <a href="#"><span>더보기 &gt</span></a>
									</p>

									<table class="notice_tbl">


										<c:choose>

											<c:when test="${empty userNoticeList.noticeLists}">
												<tr>
													<th colspan="3">게시글이 존재하지 않습니다.</th>
												</tr>
											</c:when>
											<c:otherwise>
												<c:forEach var="userNoticeList"
													items="${userNoticeList.noticeLists}" varStatus="loop">
													<c:if test="${loop.index < 5}">
														<tr class="row">
															<td>${userNoticeList.noticeNo}</td>
															<th><a href="#">${userNoticeList.noticeTitle}</a></th>
															<td>${userNoticeList.noticeRegDate}</td>
														</tr>
													</c:if>
												</c:forEach>
											</c:otherwise>
										</c:choose>


									</table>


								</div>
							</div>




						</div>

						<div class="event-wrap">
							<div>
								<div class="event-title">
								<p style="font-size:1.5rem">EVENT</p>
									<div>
										<button><a href="${contextPath}/eventList/detail_List">전체보기</a></button>
									</div>
								</div>

								<div class="swiper-container">
										<div class="swiper-wrapper">
							<c:forEach var="event" items="${getEvnetList['getEvnetList']}"
								varStatus="status">
								<c:choose>
									<c:when test="${event['eventStatus'] ne 'N'}">
										<input type="hidden" class="eventNo"
											value="${event['eventNo']}" />
										<div class="swiper-slide">
											<a
												href="${contextPath}/eventList/detail_List/introduce/${event['eventNo']}">
												<img src="${event['eventImg']}" alt=""
												onmouseenter="zoomIn(event)" onmouseleave="zoomOut(event)">
												<strong>${event['eventTitle']}</strong> <span>${event['eventStart']}&nbsp;~&nbsp;
													${event['eventEnd']}</span>
											</a>
										</div>
									</c:when>
									<c:otherwise>

									</c:otherwise>
								</c:choose>
							</c:forEach>

						</div>
									<div class="swiper-button-next swipe-nbtn"></div>
									<div class="swiper-button-prev swipe-pbtn"></div>
								</div>

							</div>


						</div>
					</div>
				</div>

			</section>
		</main>

	</div>
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />


	<script src="../../js/common/header.js"></script>

	<script src="${contextPath}/resources/js/notice/notice-home.js"></script>
</body>

</html>