<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


		<!DOCTYPE html>
		<html lang="en">

		<head>
			<meta charset="UTF-8">
			<meta http-equiv="X-UA-Compatible" content="IE=edge">
			<meta name="viewport" content="width=device-width, initial-scale=1.0">
			<title>예매선택 페이지</title>
			<link rel="stylesheet" href="${contextPath}/resources/css/theater/theater.css">
			<link rel="stylesheet" href="${contextPath}/resources/css/common/outline.css">
			<script src="https://kit.fontawesome.com/dc6e43e0ad.js" crossorigin="anonymous"></script>
			<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
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


										<li class="area-name"><span class="location yellowCol">서울</span>

											<div class="list-detail block">
												<ul>
													<li><a href="https://www.naver.com">강남점 </a></li>
													<li><a href="https://www.naver.com">건대입구점</a></li>
													<li><a href="https://www.naver.com">구로점</a></li>
													<li><a href="https://www.naver.com">노원점</a></li>
													<li><a href="https://www.naver.com">동대문점</a></li>
													<li><a href="https://www.naver.com">명동점</a></li>
													<li><a href="https://www.naver.com">상봉점</a></li>
													<li><a href="https://www.naver.com">상암점</a></li>
													<li><a href="https://www.naver.com">신림점</a></li>
													<li><a href="https://www.naver.com">신촌점</a></li>
													<li><a href="https://www.naver.com">영등포점</a></li>
													<li><a href="https://www.naver.com">왕십리점</a></li>
													<li><a href="https://www.naver.com">용산점</a></li>
													<li><a href="https://www.naver.com">잠실점</a></li>
													<li><a href="https://www.naver.com">종로점</a></li>
												</ul>
											</div>
										</li>


										<li class="area-name"><span class="location">경기</span>
											<div class="list-detail none">
												<ul>
													<li><a href="https://www.naver.com">광명점</a></li>
													<li><a href="https://www.naver.com">구리점</a></li>
													<li><a href="https://www.naver.com">김포점</a></li>
													<li><a href="https://www.naver.com">남양주점</a></li>
													<li><a href="https://www.naver.com">동탄점</a></li>
													<li><a href="https://www.naver.com">부천점</a></li>
													<li><a href="https://www.naver.com">성남점</a></li>
													<li><a href="https://www.naver.com">수원점</a></li>
													<li><a href="https://www.naver.com">안산점</a></li>
													<li><a href="https://www.naver.com">안양점</a></li>
													<li><a href="https://www.naver.com">부천점</a></li>
													<li><a href="https://www.naver.com">송도점</a></li>
													<li><a href="https://www.naver.com">주안점</a></li>
													<li><a href="https://www.naver.com">일산점</a></li>
													<li><a href="https://www.naver.com">하남점</a></li>


												</ul>
											</div>
										</li>

										<li class="area-name"><span class="location">충청</span>
											<div class="list-detail none">
												<ul>
													<li><a href="https://www.naver.com">공주점</a></li>
													<li><a href="https://www.naver.com">논산점</a></li>
													<li><a href="https://www.naver.com">신탄진점</a></li>
													<li><a href="https://www.naver.com">은행동점</a></li>
													<li><a href="https://www.naver.com">충남대점</a></li>
													<li><a href="https://www.naver.com">세종점</a></li>
													<li><a href="https://www.naver.com">아산점</a></li>
													<li><a href="https://www.naver.com">제천점</a></li>
													<li><a href="https://www.naver.com">천안점</a></li>
													<li><a href="https://www.naver.com">충주점</a></li>
												</ul>
											</div>
										</li>
										<li class="area-name"><span class="location">전라</span>
											<div class="list-detail none">
												<ul>
													<li><a href="https://www.naver.com">상무점</a></li>
													<li><a href="https://www.naver.com">전남대점</a></li>
													<li><a href="https://www.naver.com">유스퀘어점</a></li>
													<li><a href="https://www.naver.com">군산점</a></li>
													<li><a href="https://www.naver.com">목포점</a></li>
													<li><a href="https://www.naver.com">순천점</a></li>
													<li><a href="https://www.naver.com">완주점</a></li>
													<li><a href="https://www.naver.com">익산점</a></li>
													<li><a href="https://www.naver.com">장성점</a></li>
													<li><a href="https://www.naver.com">전주점</a></li>

												</ul>
											</div>
										</li>
										<li class="area-name"><span class="location">경남</span>
											<div class="list-detail none">
												<ul>
													<li><a href="https://www.naver.com">김해점</a></li>
													<li><a href="https://www.naver.com">마산점</a></li>
													<li><a href="https://www.naver.com">부산대점</a></li>
													<li><a href="https://www.naver.com">서면점</a></li>
													<li><a href="https://www.naver.com">센텀시티점</a></li>
													<li><a href="https://www.naver.com">해운대점</a></li>
													<li><a href="https://www.naver.com">울산역점</a></li>
													<li><a href="https://www.naver.com">태화강점</a></li>
													<li><a href="https://www.naver.com">진주점</a></li>
													<li><a href="https://www.naver.com">창원점</a></li>


												</ul>
											</div>
										</li>
										<li class="area-name"><span class="location">경북</span>
											<div class="list-detail none">
												<ul>
													<li><a href="https://www.naver.com">경주점</a></li>
													<li><a href="https://www.naver.com">구미점</a></li>
													<li><a href="https://www.naver.com">김천점</a></li>
													<li><a href="https://www.naver.com">경북대점</a></li>
													<li><a href="https://www.naver.com">동대구점</a></li>
													<li><a href="https://www.naver.com">동성로점</a></li>
													<li><a href="https://www.naver.com">안동점</a></li>
													<li><a href="https://www.naver.com">영주점</a></li>
													<li><a href="https://www.naver.com">영천점</a></li>
													<li><a href="https://www.naver.com">포항점</a></li>

												</ul>
											</div>
										</li>
										<li class="area-name"><span class="location">강원</span>
											<div class="list-detail none">
												<ul>
													<li><a href="https://www.naver.com">강릉점</a></li>
													<li><a href="https://www.naver.com">동해점</a></li>
													<li><a href="https://www.naver.com">속초점</a></li>
													<li><a href="https://www.naver.com">원주점</a></li>
													<li><a href="https://www.naver.com">춘천점</a></li>

												</ul>
											</div>
										</li>
										<li class="area-name"><span class="location">제주</span>
											<div class="list-detail none">
												<ul>
													<li><a href="https://www.naver.com">제주점ㅋ</a></li>


												</ul>
											</div>
										</li>

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


			<script src="${contextPath}/resources/js/common/header.js"></script>
			<script src="${contextPath}/resources/js/theater/theater.js"></script>
		</body>

		</html>