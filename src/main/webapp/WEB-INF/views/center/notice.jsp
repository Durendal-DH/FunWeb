<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='<c:url value="/resources/css/default.css"/>' rel="stylesheet" type="text/css">
<link href='<c:url value="/resources/css/subpage.css"/>' rel="stylesheet" type="text/css">
<!--[if lt IE 9]>
<script src="http://ie7-js.googlecode.com/svn/version/2.1(beta4)/IE9.js" type="text/javascript"></script>
<script src="http://ie7-js.googlecode.com/svn/version/2.1(beta4)/ie7-squish.js" type="text/javascript"></script>
<script src="http://html5shim.googlecode.com/svn/trunk/html5.js" type="text/javascript"></script>
<![endif]-->
<!--[if IE 6]>
 <script src="../script/DD_belatedPNG_0.0.8a.js"></script>
 <script>
   /* EXAMPLE */
   DD_belatedPNG.fix('#wrap');
   DD_belatedPNG.fix('#main_img');   

 </script>
 <![endif]-->
</head>
<body>
<div id="wrap">
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->

<!-- 본문들어가는 곳 -->
<!-- 메인이미지 -->
<div id="sub_img_center"></div>
<!-- 메인이미지 -->

<!-- 왼쪽메뉴 -->
<nav id="sub_menu">
<ul>
<li><a href="#">Notice</a></li>
<li><a href="#">Public News</a></li>
<li><a href="#">Driver Download</a></li>
<li><a href="#">Service Policy</a></li>
</ul>
</nav>
<!-- 왼쪽메뉴 -->
<!-- 게시판 -->
<article>
<h1>Notice</h1>
<table id="notice">
<tr><th class="tno">No.</th>
    <th class="ttitle">Title</th>
    <th class="twrite">Writer</th>
    <th class="tdate">Date</th>
    <th class="tread">Read</th></tr>
    <c:forEach var="bb" items="${boardList }">
    <tr onclick="location.href='<c:url value="/board/content?num=${bb.num}&pageNum=${pb.pageNum }"/>'">
    <td>${bb.num }</td>
    <td class="left">
      <c:if test="${bb.re_lev > 0}">
        <c:set var="wid" value="${bb.re_lev*10 }"/>
        <img src='<c:url value="/resources/images/center/level.gif"/>' width="${wid}">
      	<img src='<c:url value="/resources/images/center/re.gif"/>'>
      </c:if>
    ${bb.subject }</td>
    <td>${bb.name}</td>
    <td>${bb.date }</td>
    <td>${bb.readcount }</td></tr>
    </c:forEach>
</table>
<div id="table_search">
<input type="button" value="글쓰기" class="btn" 
onclick="location.href='<c:url value="/board/write"/>'">
</div>
<div id="table_search">
<form action="noticeSearch.jsp" method="get">
<input type="text" name="search" class="input_box">
<input type="submit" value="search" class="btn">
</form>
</div>
<div class="clear"></div>
<div id="page_control">
<c:if test="${pb.startPage > pb.pageBlock }">
<a href='<c:url value="/board/list?pageNum=${pb.startPage-pb.pageBlock }"/>'>Prev</a>
</c:if>
<c:forEach var="i" begin="${pb.startPage}" end="${pb.endPage}" step="1">
	<a href='<c:url value="/board/list?pageNum=${i}"/>'>${i}</a>
</c:forEach>
<c:if test="${pb.endPage < pb.pageCount }">
<a href='<c:url value="/board/list?pageNum=${pb.startPage+pb.pageBlock }"/>'>Next</a>
</c:if>
</div>
</article>
<!-- 게시판 -->
<!-- 본문들어가는 곳 -->
<div class="clear"></div>
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->
</div>
</body>
</html>