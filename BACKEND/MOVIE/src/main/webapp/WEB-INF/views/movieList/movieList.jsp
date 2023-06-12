<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>전체영화</title>
<link rel="stylesheet" href="${contextPath}/resources/css/movieList/movieList.css">
<link rel="stylesheet" href="${contextPath}/resources/css/common/outline.css">

</head>

<body>
	<div id="wrap">

		<jsp:include page="/WEB-INF/views/common/header.jsp" />

		<main>
			<div>
				<span>영화 목록</span>
			</div>


			<div>
				<ol>
				
					<li>
						<div>
							<span> 1<!-- 숫자 1~20까지 for문돌려서 박아야합니다. -->
							</span> <a href="../../html/introduce/introduce.html"><img
								src="../../images/movieList/movie_01.jpg"></a>
						</div>

						<div>
							<a href="../../html/introduce/introduce.html"> <span>영화제목</span></a>
							<div>
								<p>
									예매율&nbsp<span>100.0</span>%
								</p>
								<p>
									개봉일&nbsp<span>2023.01.01</span>
								</p>
							</div>
						</div>

						<div>
							<!-- 1좋아요버튼 -->
							<button>0</button>
							<button>예매</button>
						</div>

					</li>



				</ol>
			</div>



		</main>
	</div>


	<jsp:include page="/WEB-INF/views/common/footer.jsp" />

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"
		integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
		crossorigin="anonymous"></script>

	<script src="${contextPath}/resources/js/introduce/introduce.js"></script>

</body>

</html>