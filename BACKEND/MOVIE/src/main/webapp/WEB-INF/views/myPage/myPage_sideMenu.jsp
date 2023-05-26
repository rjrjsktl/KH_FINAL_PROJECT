<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

<!-- 마이페이지 원하는 곳으로 이동시켜주는 sideMenu -->
<section class="side-main">
    MY KGV HOME
    <ul class="list-group">
        <li> <a href="mypage_info.html">정보 수정</a> </li>
        <!-- <li> <a href="${contextPath}/member/myPage/profile">정보 수정</a> </li> -->

        <!-- /community/member/myPage/myboard -->
        <!-- 리뷰나 평점이라고 말 바꿔야함 -->
        <li> <a href="mypage_myboard.html">내가 쓴 리뷰</a></li>
        <!-- <li> <a href="${contextPath}/member/myPage/myboard">내 글 확인</a> </li> -->

        <!-- /community/member/myPage/reservationCf -->
        <li> <a href="mypage_reservationCf.html">내가 본 영화</a> </li>
        <!-- <li> <a href="${contextPath}/member/myPage/reservationCf">예약확인</a> </li> -->

        <!-- /community/member/myPage/changePw -->
        <li> <a href="mypage_changePw.html">비밀번호 변경</a> </li>
        <!-- <li> <a href="${contextPath}/member/myPage/changePw">비밀번호 변경</a> </li> -->

        <!-- /community/member/myPage/secession -->
        <li> <a href="mypage_secession.html">회원 탈퇴</a> </li>
        <!-- <li> <a href="${contextPath}/member/myPage/secession">회원 탈퇴</a> </li> -->

    </ul>
</section>