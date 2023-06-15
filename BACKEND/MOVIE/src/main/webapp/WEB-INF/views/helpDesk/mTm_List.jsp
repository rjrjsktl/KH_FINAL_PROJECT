<!-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 -->

<!-- 최신화 종료 건들일없음 -->


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>1:1문의</title>

    <script src="https://kit.fontawesome.com/dc6e43e0ad.js" crossorigin="anonymous"></script>

<link rel="stylesheet"
	href="${contextPath}/resources/css/common/outline.css">
<link rel="stylesheet"
	href="${contextPath}/resources/css/helpDesk/mtm_List.css">
<link rel="stylesheet"
	href="${contextPath}/resources/css/common/notice_Aside.css">


</head>

<body>
    <div id="wrap">
     <div id="wrap">
		<jsp:include page="/WEB-INF/views/common/header.jsp" />

		<main>
			<section>

				<jsp:include page="/WEB-INF/views/common/noticeAside.jsp" />

                <div class="container">
                    <div>
                        <div class="notice-content-wrap">
                            <div class="notice-header">
                                <h2>1:1 문의</h2>
                                <p>문의 사항이 있으실 경우 빠른 시일 내로 답변드리겠습니다.</p>
                            </div>

                            <div class="search-area">
                                <p>1:1문의 게시글 총<span style="color:red">1</span><span>/</span><span>3</span>건</p>
                            </div>

                            <div class="table-wrap">
                                <table>

                                    <thead>
                                        <th>번호</th>
                                        <th>내용</th>
                                        <th>등록일</th>
                                        <th>조회수</th>
                                    </thead>
                                    <tbody>
                                        <tr class="row">
                                            <td>1</td>
                                            <th><a href="">내용123</a><span>...[0]</span></th>
                                            <td>2023.01.01</td>
                                            <td>1</td>
                                        </tr>
                                        <tr class="row">
                                            <td>2</td>
                                            <th><a href="">내용123</a><span>...[1]</span></th>
                                            <td>2023.01.01</td>
                                            <td>23</td>
                                        </tr>
                                        <tr class="row">
                                            <td>3</td>
                                            <th><a href="">내용123</a><span>...[1]</span></th>
                                            <td>2023.01.01</td>
                                            <td>456</td>
                                        </tr>



                                    </tbody>

                                </table>

                                <div>
                                    <button>게시물 등록</button>
                                </div>
                                <!-- 10개씩 -->
                                <ul class="pagination">
                                    <li><a href="#">&lt;&lt;</a></li>
                                    <li><a href="#">&lt;</a></li>
                                    <li><a href="#">1</a></li>
                                    <li><a href="#">2</a></li>
                                    <li><a href="#">3</a></li>
                                    <li><a href="#">4</a></li>
                                    <li><a href="#">5</a></li>
                                    <li><a href="#">&gt;</a></li>
                                    <li><a href="#">&gt;&gt;</a></li>
                                </ul>

                            </div>
                        </div>
                    </div>
                </div>
        </main>

    </div>

	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
	
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
        integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <script src="../../js/common/header.js"></script>
    

</body>

</html>