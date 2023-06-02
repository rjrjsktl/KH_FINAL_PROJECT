<!-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 -->

<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원 리스트</title>

<link rel="stylesheet"
	href="${contextPath}/resources/css/manager/manager_member_list.css">
<link rel="stylesheet"
	href="${contextPath}/resources/css/manager/reset.css">

<!-- fontawesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
	integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

<!-- jQuery 라이브러리 추가(CDN) -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>


</head>

<body>
	<main>

		<div class="main_Wrapper">
			<div id="left_Nav_Container">
				<div class="nav_Title">로고영역</div>
				<!-- NAV 영역 -->
				<jsp:include page="/WEB-INF/views/manager/manager_nav.jsp" />

			</div>

			<div class="right_items_Container">
				<!-- 내부 HEADER 영역 -->
				<jsp:include page="/WEB-INF/views/manager/manager_inner_Header.jsp" />

				<div id="items_Wrapper">
					<div class="set_Edge">
						<div class="table_Wrapper">
							<div class="table_Title">
								<span>회원목록</span>
								<div class="search_Box">
									<input placeholder="검색" />
									<button>
										<i class="fa-solid fa-magnifying-glass fa-2xs"></i>
									</button>
								</div>
							</div>
							<table class="table_main">
								<tr>
									<th>번호</th>
									<th>아이디</th>
									<th>이름</th>
									<th>닉네임</th>
									<th>연락처</th>
									<th>주소</th>
									<th>생년월일</th>
									<th>성별</th>
									<th>가입일</th>
									<th>탈퇴일</th>
									<th>탈퇴 여부</th>
									<th>보유 포인트</th>
									<th>SNS 가입</th>
									<th>관리자</th>
									<th>이용제한</th>
								</tr>
								<tr>
									<td>1</td>
									<td>cropruch@naver.com</td>
									<td>김민수</td>
									<td>Nickname</td>
									<td>01020823987</td>
									<td>경기도,성남시,수정구,위례순환로 111</td>
									<td>19940227</td>
									<td>남</td>
									<td>2023.05.27 03:32:32</td>
									<td>-</td>
									<td>N</td>
									<td>1,000,000</td>
									<td>Y</td>
									<td><select name="Is_Manager">
											<option value="N" selected>N</option>
											<option value="Y">Y</option>
									</select></td>
									<td><select name="Is_Blocked">
											<option value="N" selected>N</option>
											<option value="Y">Y</option>
									</select></td>
								</tr>
								<tr>
									<td>2</td>
									<td>cropruch@naver.com</td>
									<td>김민수</td>
									<td>Nickname</td>
									<td>01020823987</td>
									<td>경기도,성남시,수정구,위례순환로 111</td>
									<td>19940227</td>
									<td>남</td>
									<td>2023.05.27 03:32:32</td>
									<td>2023.05.27 03:48:59</td>
									<td>Y</td>
									<td>0</td>
									<td>Y</td>
									<td><select>
											<option selected>N</option>
											<option>Y</option>
									</select></td>
									<td><select name="Is_Blocked">
											<option value="N" selected>N</option>
											<option value="Y">Y</option>
									</select></td>
								</tr>
								<tr>
									<td>3</td>
									<td>cropruch@naver.com</td>
									<td>김민수</td>
									<td>Nickname</td>
									<td>01020823987</td>
									<td>경기도,성남시,수정구,위례순환로 111</td>
									<td>19940227</td>
									<td>남</td>
									<td>2023.05.27 03:32:32</td>
									<td>-</td>
									<td>N</td>
									<td>0</td>
									<td>N</td>
									<td><select>
											<option selected>N</option>
											<option>Y</option>
									</select></td>
									<td><select name="Is_Blocked">
											<option value="N" selected>N</option>
											<option value="Y">Y</option>
									</select></td>
								</tr>
								<tr>
									<td>4</td>
									<td>cropruch@naver.com</td>
									<td>김민수</td>
									<td>Nickname</td>
									<td>01020823987</td>
									<td>경기도,성남시,수정구,위례순환로 111</td>
									<td>19940227</td>
									<td>남</td>
									<td>2023.05.27 03:32:32</td>
									<td>-</td>
									<td>N</td>
									<td>2,000</td>
									<td>N</td>
									<td><select>
											<option selected>N</option>
											<option>Y</option>
									</select></td>
									<td><select name="Is_Blocked">
											<option value="N" selected>N</option>
											<option value="Y">Y</option>
									</select></td>
								</tr>
								<tr>
									<td>5</td>
									<td>cropruch@naver.com</td>
									<td>김민수</td>
									<td>Nickname</td>
									<td>01020823987</td>
									<td>경기도,성남시,수정구,위례순환로 111</td>
									<td>19940227</td>
									<td>남</td>
									<td>2023.05.27 03:32:32</td>
									<td>-</td>
									<td>N</td>
									<td>0</td>
									<td>N</td>
									<td><select>
											<option selected>N</option>
											<option>Y</option>
									</select></td>
									<td><select name="Is_Blocked">
											<option value="N" selected>N</option>
											<option value="Y">Y</option>
									</select></td>
								</tr>
								<tr>
									<td>6</td>
									<td>cropruch@naver.com</td>
									<td>김민수</td>
									<td>Nickname</td>
									<td>01020823987</td>
									<td>경기도,성남시,수정구,위례순환로 111</td>
									<td>19940227</td>
									<td>남</td>
									<td>2023.05.27 03:32:32</td>
									<td>-</td>
									<td>N</td>
									<td>0</td>
									<td>N</td>
									<td><select>
											<option selected>N</option>
											<option>Y</option>
									</select></td>
									<td><select name="Is_Blocked">
											<option value="N" selected>N</option>
											<option value="Y">Y</option>
									</select></td>
								</tr>
								<tr>
									<td>7</td>
									<td>cropruch@naver.com</td>
									<td>김민수</td>
									<td>Nickname</td>
									<td>01020823987</td>
									<td>경기도,성남시,수정구,위례순환로 111</td>
									<td>19940227</td>
									<td>여</td>
									<td>2023.05.27 03:32:32</td>
									<td>-</td>
									<td>N</td>
									<td>0</td>
									<td>N</td>
									<td><select>
											<option selected>N</option>
											<option>Y</option>
									</select></td>
									<td><select name="Is_Blocked">
											<option value="N" selected>N</option>
											<option value="Y">Y</option>
									</select></td>
								</tr>
								<tr>
									<td>8</td>
									<td>cropruch@naver.com</td>
									<td>김민수</td>
									<td>Nickname</td>
									<td>01020823987</td>
									<td>경기도,성남시,수정구,위례순환로 111</td>
									<td>19940227</td>
									<td>남</td>
									<td>2023.05.27 03:32:32</td>
									<td>-</td>
									<td>N</td>
									<td>0</td>
									<td>N</td>
									<td><select>
											<option selected>N</option>
											<option>Y</option>
									</select></td>
									<td><select name="Is_Blocked">
											<option value="N" selected>N</option>
											<option value="Y">Y</option>
									</select></td>
								</tr>
								<tr>
									<td>9</td>
									<td>cropruch@naver.com</td>
									<td>김민수</td>
									<td>Nickname</td>
									<td>01020823987</td>
									<td>경기도,성남시,수정구,위례순환로 111</td>
									<td>19940227</td>
									<td>선택안함</td>
									<td>2023.05.27 03:32:32</td>
									<td>-</td>
									<td>N</td>
									<td>0</td>
									<td>N</td>
									<td><select>
											<option selected>N</option>
											<option>Y</option>
									</select></td>
									<td><select name="Is_Blocked">
											<option value="N" selected>N</option>
											<option value="Y">Y</option>
									</select></td>
								</tr>
								<tr>
									<td>10</td>
									<td>cropruch@naver.com</td>
									<td>김민수</td>
									<td>Nickname</td>
									<td>01020823987</td>
									<td>경기도,성남시,수정구,위례순환로 111</td>
									<td>19940227</td>
									<td>남</td>
									<td>2023.05.27 03:32:32</td>
									<td>-</td>
									<td>N</td>
									<td>0</td>
									<td>N</td>
									<td><select>
											<option selected>N</option>
											<option>Y</option>
									</select></td>
									<td><select name="Is_Blocked">
											<option value="N" selected>N</option>
											<option value="Y">Y</option>
									</select></td>
								</tr>

							</table>
							<div class="page_Nation">
								<div>&lt;</div>
								<div class="selected_Cp">1</div>
								<div>2</div>
								<div>3</div>
								<div>4</div>
								<div>5</div>
								<div>6</div>
								<div>7</div>
								<div>&gt;</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>

	</main>

    <script src="${contextPath}/resources/js/manager/manager_select.js"></script>
	<script src="${contextPath}/resources/js/manager/manager_member_list.js"></script>
	<script src="${contextPath}/resources/js/manager/manager_inner_Header.js"></script>
	<script src="${contextPath}/resources/js/manager/manager_nav.js"></script>
</body>

</html>