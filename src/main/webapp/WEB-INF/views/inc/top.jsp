<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
<%
// 세션값 가져오기
String id=(String)session.getAttribute("id");
// 세션값이 없으면  login | join
// 세션값이 있으면  ..님 | logout | 회원정보 수정
if(id==null){
	%><div id="login"><a href='<c:url value="/member/login"/>'>login</a> | <a href='<c:url value="/member/insert"/>'>join</a></div><%
}else{
	%><div id="login"><%=id %>님 | <a href='<c:url value="/member/logout"/>'>logout</a> | <a href='<c:url value="/member/update"/>'>회원정보수정</a></div><%
}
%>
<div class="clear"></div>
<!-- 로고들어가는 곳 -->
<div id="logo"><img src='<c:url value="/resources/images/logo.gif"/>' width="265" height="62" alt="Fun Web"></div>
<!-- 로고들어가는 곳 -->
<nav id="top_menu">
<ul>
	<li><a href='<c:url value="/member/main"/>'>메인</a></li>
	<li><a href='<c:url value="/welcome"/>'>개발자소개</a></li>
	<li><a href='<c:url value="/board/crawler"/>'>기사 크롤링</a></li>
	<li><a href='<c:url value="/board/list"/>'>기사 자료실</a></li>
	<li><a href="#">통계</a></li>
</ul>
</nav>
</header>