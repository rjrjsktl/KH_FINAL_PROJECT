<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>비밀번호찾기 페이지</title>

<link rel="stylesheet"	href="${contextPath}/resources/css/common/outline.css">
<link rel="stylesheet" href="${contextPath}/resources/css/login/find_Pw_Email_2.css">
<script src="https://kit.fontawesome.com/dc6e43e0ad.js" crossorigin="anonymous"></script>
		<script src="https://code.jquery.com/jquery-3.6.0.min.js"
							integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
							crossorigin="anonymous"></script>

</head>

<body>
	<div id="wrap">
		
		<!-- header -->
		<jsp:include page="/WEB-INF/views/common/header.jsp" />
		
		<main>
            <h1>
                
            </h1>

            <div>
                <div><!-- main>:nth-child(2)>:nth-child(1) -->

                    <p>아이디/비밀번호 찾기</p>
                    <div>
                        <ul>
                            <li>
                                <a href="findEmail">아이디 찾기</a>
                            </li>
                            <li>
                                <a href="findPw">비밀번호 찾기</a>
                            </li>
                        </ul>
                        <h3>※ 찾으려고하는 비밀번호의 이름 생년월일 이메일을 기입해주세요</h3>
                        <div>
                            <table>
                                <caption></caption>
                                <colgroup></colgroup>
                                <tbody>
                                    <tr>
                                        <th>이름</th>
                                        <td><input type="text" placeholder="이름" name="userName" id="userName"></td>
                                    </tr>
                                    <tr>
                                        <th>생년월일</th>
                                        <td><input type="text" placeholder="생년월일 (ex:19920517)" name="userBirth" id="userBirth"></td>
                                    </tr>
                                    <tr>
                                        <th>이메일</th>
                                        <td>
                                            <input type="text" placeholder="이메일" name="userEmail" id="userEmail">
                                            <button id="sendBtn">인증요청</button>
                                        </td>
                                        
                                    </tr>
                                    <tr>
                                        <th>인증번호</th>
                                        <td>
                                            <input type="text" placeholder="인증번호" name="cNumber" id="cNumber">
                                            <!-- 5:00 타이머 -->
                                            <span class="signUp-message" id="cMessage"></span>
                                        </td>
                                    </tr>
                                    
                                </tbody>
                            </table>
                        </div>
                        
                        <div>
                        	<button id="cBtn" onclick="location.href='pwChange'">인증완료</button>
                        </div>
                        
                    </div>
                </div>
            </div>
        </main>

	</div>
	
	<!-- footer -->
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />

	<script src="${contextPath}/resources/js/login/findPw.js"></script>
</body>

</html>