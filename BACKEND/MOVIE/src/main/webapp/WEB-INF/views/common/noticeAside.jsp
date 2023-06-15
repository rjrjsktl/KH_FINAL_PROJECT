<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<!-- 최신화 종료 건들일없음 -->


<aside>
	<div class="aside-ul-wrap">
		<ul class="aslide-list">
			<li><a href="${contextPath}/helpDesk/helpDesk_home"><h1>고객센터</h1></a></li>
			<li><a href="${contextPath}/helpDesk/notice_List">공지사항</a></li>
			<li><a href="${contextPath}/helpDesk/mTm_List">1:1 문의</a></li>
			<li><a href="${contextPath}/helpDesk/question_home">자주찾는 질문</a></li>
			<li><a href="${contextPath}/helpDesk/lost_List">분실문 문의</a></li>
			<li><a href="#">이용약관</a></li>
			<li><a href="#">개인정보처리</a></li>
			<li><a href="#"> 편성 기준 </a></li>
		</ul>
	</div>
</aside>